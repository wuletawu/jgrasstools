/*
 * $Id: Controller.java 20 2008-07-25 22:31:07Z od $
 * 
 * This software is provided 'as-is', without any express or implied
 * warranty. In no event will the authors be held liable for any damages
 * arising from the use of this software.
 * 
 * Permission is granted to anyone to use this software for any purpose,
 * including commercial applications, and to alter it and redistribute it
 * freely, subject to the following restrictions:
 * 
 *  1. The origin of this software must not be misrepresented; you must not
 *     claim that you wrote the original software. If you use this software
 *     in a product, an acknowledgment in the product documentation would be
 *     appreciated but is not required.
 * 
 *  2. Altered source versions must be plainly marked as such, and must not be
 *     misrepresented as being the original software.
 * 
 *  3. This notice may not be removed or altered from any source
 *     distribution.
 */
package oms3;

import java.lang.annotation.Annotation;
import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.Executors;
import java.util.logging.Level;
import java.util.logging.Logger;
import oms3.util.Threads;

/** Execution Controller.
 *
 * @author Olaf David odavid@colostate.edu
 * @version $Id: Controller.java 20 2008-07-25 22:31:07Z od $ 
 */
class Controller {

//    static boolean skipCheck = Boolean.getBoolean("oms.skipCheck");
    private static final Logger log = Logger.getLogger("oms3.sim");
    /** Execution event Notification */
    Notification ens = new Notification(this);
    /* data set */
    Set<FieldContent> dataSet = new LinkedHashSet<FieldContent>();
    /*  All the Commands that have been added to the controller */
    Map<Object, ComponentAccess> oMap = new LinkedHashMap<Object, ComponentAccess>(32);
    /* The compount where this controller belongs to */
    ComponentAccess ca;
    // optional skipping the integrity checking.
    Validator val;

    Controller(Object compound) {
        if (log.isLoggable(Level.WARNING)) {
//        if (!skipCheck) {
            val = new Validator();
        }
        ca = new ComponentAccess(compound, ens);
    }

    ComponentAccess lookup(Object cmd) {
        if (cmd == null) {
            throw new IllegalArgumentException("null component.");
        }
        if (cmd == ca.getComponent()) {
            throw new IllegalArgumentException("Cannot add the compound to itself. Create and add an inner class instead.");
        }
        ComponentAccess w = oMap.get(cmd);
        if (w == null) {
            oMap.put(cmd, w = new ComponentAccess(cmd, ens));
        }
        return w;
    }

    Notification getNotification() {
        return ens;
    }

    void mapOut(String out, Object comp, String comp_out) {
        if (comp == ca.getComponent()) {
            throw new IllegalArgumentException("cicular ref on " + out);
        }
        ComponentAccess ac_dest = lookup(comp);
        FieldAccess destAccess = (FieldAccess) ac_dest.output(comp_out);
        FieldAccess srcAccess = (FieldAccess) ca.output(out);
        checkFA(destAccess, comp, comp_out);
        checkFA(srcAccess, ca.getComponent(), out);

        FieldContent data = srcAccess.getData();
        data.tagLeaf();
        data.tagOut();

        destAccess.setData(data);
        dataSet.add(data);
        ens.fireMapOut(srcAccess, destAccess);
    }

    void mapIn(String in, Object comp, String comp_in) {
        if (comp == ca.getComponent()) {
            throw new IllegalArgumentException("cicular ref on " + in);
        }
        ComponentAccess ac_dest = lookup(comp);
        FieldAccess destAccess = (FieldAccess) ac_dest.input(comp_in);
        checkFA(destAccess, comp, comp_in);
        FieldAccess srcAccess = (FieldAccess) ca.input(in);
        checkFA(srcAccess, ca.getComponent(), in);

        FieldContent data = srcAccess.getData();
        data.tagLeaf();
        data.tagIn();

        destAccess.setData(data);
        dataSet.add(data);
        ens.fireMapIn(srcAccess, destAccess);
    }

    // map an input field
    void mapInVal(Object val, Object to, String to_in) {
        if (val == null) {
            throw new IllegalArgumentException("Null value for " + name(to, to_in));
        }
        if (to == ca.getComponent()) {
            throw new IllegalArgumentException("wrong connect:" + to_in);
        }
        ComponentAccess ca_to = lookup(to);
        Access to_access = ca_to.input(to_in);
        checkFA(to_access, to, to_in);
        ca_to.setInput(to_in, new FieldValueAccess(to_access, val));
//            ens.fireMapIn(from_access, to_access);
    }

    // map an input field
    void mapInField(Object from, String from_field, Object to, String to_in) {
        if (to == ca.getComponent()) {
            throw new IllegalArgumentException("wrong connect:" + from_field);
        }
        ComponentAccess ca_to = lookup(to);
        Access to_access = ca_to.input(to_in);
        checkFA(to_access, to, to_in);
        try {
            FieldContent.FA f = new FieldContent.FA(from, from_field);
            ca_to.setInput(to_in, new FieldObjectAccess(to_access, f));

//            ens.fireMapIn(from_access, to_access);
        } catch (Exception E) {
            throw new IllegalArgumentException("No such field '" + from.getClass().getCanonicalName() + "." + from_field + "'");
        }
    }

    //
    void mapOutField(Object from, String from_out, Object to, String to_field) {
        if (from == ca.getComponent()) {
            throw new IllegalArgumentException("wrong connect:" + to_field);
        }
        ComponentAccess ca_from = lookup(from);
        Access from_access = ca_from.output(from_out);
        checkFA(from_access, from, from_out);

        try {
            FieldContent.FA f = new FieldContent.FA(to, to_field);
            ca_from.setOutput(from_out, new FieldObjectAccess(from_access, f));
//            ens.fireMapOut(from_access, from_access);
        } catch (Exception E) {
            throw new IllegalArgumentException("No such field '" + to.getClass().getCanonicalName() + "." + to_field + "'");
        }
    }

    void connect(Object from, String from_out, Object to, String to_in) {
        // add them to the set of commands
        if (from == to) {
            throw new IllegalArgumentException("src == dest.");
        }
        if (to_in == null || from_out == null) {
            throw new IllegalArgumentException("Some field arguments are null");
        }

        ComponentAccess ca_from = lookup(from);
        ComponentAccess ca_to = lookup(to);

        Access from_access = ca_from.output(from_out);
        checkFA(from_access, from, from_out);
        Access to_access = ca_to.input(to_in);
        checkFA(to_access, to, to_in);

        if (!canConnect(from_access, to_access)) {
            throw new IllegalArgumentException(
                    "Type/Access mismatch, Cannot connect: " + from + '.' + to_in + " -> " + to + '.' + from_out);
        }

        // src data object
        FieldContent data = from_access.getData();
        data.tagIn();
        data.tagOut();

        dataSet.add(data);
        to_access.setData(data);                       // connect the two

//        if (!skipCheck) {
        if (log.isLoggable(Level.WARNING)) {
            val.addConnection(from, to);
            val.checkCircular();
        }

        ens.fireConnect(from_access, to_access);
    }

    void feedback(Object from, String from_out, Object to, String to_in) {
        // add them to the set of commands
        if (from == to) {
            throw new IllegalArgumentException("src == dest.");
        }
        if (to_in == null || from_out == null) {
            throw new IllegalArgumentException("Some field arguments are null");
        }

        ComponentAccess ca_from = lookup(from);
        ComponentAccess ca_to = lookup(to);

        Access from_access = ca_from.output(from_out);
        checkFA(from_access, from, from_out);
        Access to_access = ca_to.input(to_in);
        checkFA(to_access, to, to_in);

        if (!canConnect(from_access, to_access)) {
            throw new IllegalArgumentException(
                    "Type/Access mismatch, Cannot connect: " + from + '.' + to_in + " -> " + to + '.' + from_out);
        }

        // src data object
        FieldContent data = from_access.getData();
        data.tagIn();
        data.tagOut();

  //      dataSet.add(data);
        to_access.setData(data);                       // connect the two

        ca_from.setOutput(from_out, new AsyncFieldAccess(from_access));
        ca_to.setInput(to_in, new AsyncFieldAccess(to_access));

//        if (!skipCheck) {
        if (log.isLoggable(Level.WARNING)) {
 //           val.addConnection(from, to);
//            val.checkCircular();
        }
        
        ens.fireConnect(from_access, to_access);
    }

    static String name(Object o, String field) {
        return o.toString() + "@" + field;
    }

    static boolean canConnect(Access me, Access other) {
        return other.getField().getType().isAssignableFrom(me.getField().getType());
    }

    static void checkFA(Object fa, Object o, String field) {
        if (fa == null) {
            throw new IllegalArgumentException("No such field '" + o.getClass().getCanonicalName() + "." + field + "'");
        }
    }

    void sanityCheck() {
//        if (!skipCheck) {
        if (log.isLoggable(Level.WARNING)) {
//            val.checkInFieldAccess();
            val.checkOutFieldAccess();
        }
    }
    // something internal.
    ComponentException E;
    static ExecutorService executor = Executors.newCachedThreadPool();

    static void reload() {
        executor = Executors.newCachedThreadPool();
        Threads.e = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors() + 1);
    }

    public static void shutdown() {
        executor.shutdown();
        Threads.e.shutdown();
    }

    static private class Latch {

        private int count;
        final Object lock = new Object();

        void reload(int count) {
            this.count = count;
        }

        void open() {
            synchronized (lock) {
                count = 0;
                lock.notify();
            }
        }

        void countDown() {
            synchronized (lock) {
                if (--count <= 0) {
                    lock.notify();
                }
            }
        }

        void await() throws InterruptedException {
            synchronized (lock) {
                while (count > 0) {
                    lock.wait();
                }
            }
        }
    }
    
    Latch latch = new Latch();
    Runnable[] rc;
    final Object l = new Object();

    protected void internalExec() throws ComponentException {
        Collection<ComponentAccess> comps = oMap.values();
        if (comps.size() == 0) {
            return;        // compound inputs to internals
        }
        try {
            for (Access a : ca.inputs()) {   // map the inputs
                a.out();
            }
        } catch (Exception Ex) {
            throw new ComponentException(Ex, ca.getComponent());
        }

        for (FieldContent dataRef : dataSet) {
            dataRef.invalidate();
        }

//        final CountDownLatch latch = new CountDownLatch(comps.size());
        latch.reload(comps.size());
        ens.fireStart(ca);
        if (rc == null) {
            rc = new Runnable[comps.size()];
            int i = 0;
            for (final ComponentAccess co : comps) {
                rc[i++] = new Runnable() {

                    @Override
                    public void run() {
                        try {
                            co.exec();
                            latch.countDown();
                        } catch (ComponentException ce) {
                            synchronized (l) {
                                if (E == null) {
                                    E = ce;
                                }
                            }
                            latch.open();
                            executor.shutdownNow();
                        }
                    }
                };
            }
        }
        for (Runnable r : rc) {
            if (E != null) {
                break;
            }
            executor.execute(r);
        }

//        for (final ComponentAccess ca : comps) {
//            executor.execute(new Runnable() {
//
//                @Override
//                public void run() {
//                    try {
//                        ca.exec();
//                    } catch (ComponentException ce) {
//                        synchronized (E) {
//                            if (E == null) {
//                                E = ce;
//                            }
//                        }
//                        executor.shutdownNow();
//                    }
//                    latch.countDown();
//                }
//            });
//        }
        try {
            latch.await();
        } catch (InterruptedException IE) {
            // nothing to do here.
        }

        // some of the components left an
        // exception.
        if (E != null) {
            ens.fireException(E);
            throw E;
        }

        try {
            ens.fireFinnish(ca);
            // map the outputs.
//            System.out.println("Comp " + ca.getComponent() + ": " + ca.outputs());
            for (Access a : ca.outputs()) {
                a.in();
            }
        } catch (Exception Ex) {
            throw new ComponentException(Ex, ca.getComponent());
        }
    }

  

    /**
     * Call an annotated method.
     *
     * @param ann
     */
    void callAnnotated(Class<? extends Annotation> ann, boolean lazy) {
        for (ComponentAccess p : oMap.values()) {
            p.callAnnotatedMethod(ann, lazy);
        }
    }

    /////////////////////////
    /**
     * Validator.
     * The Validator checks for unresolved Fielsaccess connections,
     * circular references, etc.
     */
    private class Validator {

        // node -> [node1, node2, ...]
        Map<Object, List<Object>> graph = new HashMap<Object, List<Object>>();

        void addConnection(Object from, Object to) {
            List<Object> tos = graph.get(from);
            if (tos == null) {
                tos = new ArrayList<Object>();
                graph.put(from, tos);
            }
            tos.add(to);
        }

        private void check(Object probe, Object current) {
            List<Object> nl = graph.get(current);
            if (nl == null) {
                return;
            }
            for (Object o : nl) {
                if (o == probe) {
                    throw new RuntimeException("Circular reference to: " + probe);
                } else {
                    check(probe, o);
                }
            }
        }

        /**
         * Checks the whole graph for circular references that would lead to
         * a deadlock.
         */
        void checkCircular() {
            if (graph.size() == 0) {
                return;
            }
            for (Object probe : graph.keySet()) {
                check(probe, probe);
            }
        }

        void checkInFieldAccess() {
            for (Access in : ca.inputs()) {
                if (!in.getData().isValid()) {
                    throw new IllegalStateException("Invalid Access " + in + " -> " + in.getData().access());
                }
            }
            for (ComponentAccess w : oMap.values()) {
                for (Access in : w.inputs()) {
                    if (!in.isValid()) {
                        throw new IllegalStateException("Missing Connect for: " + in);
                    }
                    if (!in.getData().isValid()) {
                        throw new IllegalStateException("Invalid Access " + in + " -> " + in.getData().access());
                    }
                }
            }
        }

        void checkOutFieldAccess() {
            for (ComponentAccess w : oMap.values()) {
                for (Access out : w.outputs()) {
                    if (!out.isValid()) {
                        log.warning("Empty @Out connect for: " + out);
                    }
                }
            }
        }
    }
}