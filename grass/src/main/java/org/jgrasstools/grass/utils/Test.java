package org.jgrasstools.grass.utils;

import java.io.IOException;
import java.io.StringReader;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.Source;
import javax.xml.transform.sax.SAXSource;

import org.jgrasstools.grass.dtd64.Flag;
import org.jgrasstools.grass.dtd64.GrassInterface;
import org.jgrasstools.grass.dtd64.Parameter;
import org.jgrasstools.grass.dtd64.ParameterGroup;
import org.jgrasstools.grass.dtd64.Task;
import org.jgrasstools.grass.dtd64.Value;
import org.jgrasstools.grass.dtd64.Values;
import org.xml.sax.EntityResolver;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

public class Test {

    private static final String FEATURE_NAMESPACES = "http://xml.org/sax/features/namespaces";
    private static final String FEATURE_NAMESPACE_PREFIXES = "http://xml.org/sax/features/namespace-prefixes";

    public Test() throws Exception {
        System.setProperty(GrassUtils.GRASS_ENVIRONMENT_GISBASE_KEY, "/usr/lib/grass64");

        GrassRunner grassRunner = new GrassRunner(null, null, false);
        String result = grassRunner.runModule(new String[]{"/usr/lib/grass64/bin/v.in.ascii", "--interface-description"});

        System.out.println(result);

        JAXBContext jaxbContext = JAXBContext.newInstance(GrassInterface.class);

        XMLReader xmlreader = XMLReaderFactory.createXMLReader();
        xmlreader.setFeature(FEATURE_NAMESPACES, true);
        xmlreader.setFeature(FEATURE_NAMESPACE_PREFIXES, true);
        xmlreader.setEntityResolver(new EntityResolver(){
            public InputSource resolveEntity( String publicId, String systemId ) throws SAXException, IOException {
                InputSource inputSource = new InputSource(GrassInterface.class.getResourceAsStream("grass-interface.dtd"));
                return inputSource;
            }
        });

        InputSource input = new InputSource(new StringReader(result));
        Source source = new SAXSource(xmlreader, input);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        Task grassInterface = (Task) unmarshaller.unmarshal(source);

        String name = grassInterface.getName();
        String desc = grassInterface.getDescription();
        System.out.println(name.trim());
        System.out.println(desc.trim());

        List<Flag> flagList = grassInterface.getFlag();
        System.out.println("Flags:");
        for( Flag flag : flagList ) {
            String flagName = flag.getName().trim();
            System.out.print("\t" + flagName + " - ");
            String descr = flag.getDescription().trim();
            System.out.println(descr);
        }

        List<ParameterGroup> parameterGroupList = grassInterface.getParameterGroup();
        if (parameterGroupList.size() > 0) {
            System.out.println("ParameterGroup:");
            for( ParameterGroup parameterGroup : parameterGroupList ) {
                String pgName = parameterGroup.getName().trim();
                System.out.println(pgName);
                String pgDescr = parameterGroup.getDescription().trim();
                System.out.println(pgDescr);
            }
        }

        List<Parameter> parameterList = grassInterface.getParameter();
        if (parameterList.size() > 0) {
            System.out.println("Parameters:");
            for( Parameter parameter : parameterList ) {
                String pgName = parameter.getName().trim();
                System.out.print("\t" + pgName + " - ");
                String pgDescr = parameter.getDescription().trim();
                System.out.println(pgDescr);

                String req = parameter.getRequired().trim();
                System.out.println("\t\t" + req);
                String type = parameter.getType().trim();
                System.out.println("\t\t" + type);
                String defaultv = parameter.getDefault();
                if (defaultv != null) {
                    defaultv = defaultv.trim();
                    System.out.println("\t\t" + defaultv);
                }
                String multiple = parameter.getMultiple().trim();
                System.out.println("\t\t" + multiple);

                Values values = parameter.getValues();
                if (values != null) {
                    System.out.println("\t\tValues:");
                    List<Value> value = values.getValue();
                    for( Value v : value ) {
                        String name2 = v.getName().trim();
                        System.out.print("\t\t\t" + name2 + " - ");
                        String description = v.getDescription().trim();
                        System.out.println(description);
                    }
                }
            }
        }
    }

    public static void main( String[] args ) throws Exception {
        new Test();
    }

}
