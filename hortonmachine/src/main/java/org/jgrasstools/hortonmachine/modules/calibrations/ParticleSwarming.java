package org.jgrasstools.hortonmachine.modules.calibrations;

import static org.jgrasstools.gears.libs.modules.JGTConstants.doubleNovalue;

import java.io.BufferedReader;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import oms3.annotations.Description;
import oms3.annotations.Execute;
import oms3.annotations.In;
import oms3.annotations.Out;
import oms3.annotations.UI;
import oms3.annotations.Unit;

import org.jgrasstools.gears.libs.modules.JGTConstants;
import org.jgrasstools.gears.libs.modules.JGTModel;
import org.jgrasstools.gears.libs.monitor.DummyProgressMonitor;
import org.jgrasstools.gears.libs.monitor.IJGTProgressMonitor;
import org.jgrasstools.gears.utils.files.FileUtilities;

public class ParticleSwarming extends JGTModel {

    @UI(JGTConstants.FILEIN_UI_HINT)
    @Description("The file containing the model name (first line) and the ranges of the parameters to calibrate (in form: varname = vmin; vmax).")
    @In
    public String inCalibrationParamfile = null;

    @UI(JGTConstants.FILEIN_UI_HINT)
    @Description("The file containing the input parameters for the model.")
    @In
    public String inParamfile = null;

    @UI(JGTConstants.FILEIN_UI_HINT)
    @Description("The measured values.")
    @In
    public String inMeasuredfile = null;

    @Description("The variable of the model that will point to the output file.")
    @In
    public String pVariable = null;

    @Description("Number of particles to use.")
    @In
    public int pParticles;

    @Description("Maximum iterations number.")
    @In
    public int pMaxiter;

    @Description("The progress monitor.")
    @In
    public IJGTProgressMonitor pm = new DummyProgressMonitor();

    @Description("Optimal value of the objective function.")
    @Out
    public double pOptimal;

    @Description("Calibrated parameters, in the same order as found in the input file.")
    @Out
    public double[] outCalibrated;

    public double[] costvect;
    public double[][] p_best;
    public double[] g_best;
    public double g_best_value;
    public double[] p_best_value;
    public double[] hist_g_best_value;
    public double observed[];
    public double modelled[];

    /**
     * Paramters min values.
     */
    public double[] parRange_minn;
    /**
     * Paramters max values.
     */
    public double[] parRange_maxn;

    private Object modelObject;

    @SuppressWarnings("nls")
    @Execute
    public void process() throws Exception {
        List<String> parametersLines = FileUtilities.readFileToLinesList(new File(inCalibrationParamfile));

        Class< ? > modelClass = Class.forName(parametersLines.get(0).trim());
        modelObject = modelClass.newInstance();

        int parNum = parametersLines.size() - 1;
        parRange_minn = new double[parNum];
        parRange_maxn = new double[parNum];

        List<Double> maxList = new ArrayList<Double>();
        List<Double> minList = new ArrayList<Double>();
        for( int i = 1; i < parametersLines.size(); i++ ) {
            String line = parametersLines.get(i);
            String[] lineSplit = line.split("="); //$NON-NLS-1$
            String varName = lineSplit[0].trim();
            String[] rangesSplit = lineSplit[1].trim().split(";");
            double min = Double.parseDouble(rangesSplit[0].trim());
            double max = Double.parseDouble(rangesSplit[1].trim());

            // set it in the arrays for the calibrator
            parRange_minn[i - 1] = min;
            parRange_maxn[i - 1] = max;
        }

        double[][] parametersMatrix = uniformNumberGenerator(parRange_minn, parRange_maxn, pParticles);
        parametersMatrix = reflectBounds(parametersMatrix, parRange_maxn, parRange_minn);
        double velRange_minn[] = new double[parRange_minn.length];
        double velRange_max[] = new double[parRange_minn.length];
        // ipotizzo che la velocita iniziale sia inizializzata compresa tra 1/100 dei valori max e
        // min dei parametri
        for( int i = 0; i < parRange_maxn.length; i++ ) {
            velRange_minn[i] = parRange_minn[i];
            velRange_max[i] = parRange_maxn[i];
        }

        double vel[][] = uniformNumberGenerator(velRange_minn, velRange_max, pParticles);

        // calculate the cost of each particle
        double[] costvectold = computeCostFunction(parametersMatrix);

        int kkk = 0;
        p_best = parametersMatrix;
        p_best_value = costvectold;
        double min = Math.abs(costvectold[0]);
        int posmin = 0;
        for( int i = 1; i < costvectold.length; i++ ) {
            if (Math.abs(costvectold[i]) < min) {
                min = Math.abs(costvectold[i]);
                posmin = i;
            }
        }
        g_best = new double[parametersMatrix[0].length];
        g_best_value = min;
        for( int i = 0; i < parametersMatrix[0].length; i++ ) {
            g_best[i] = parametersMatrix[posmin][i];
        }

        hist_g_best_value = new double[pMaxiter];
        boolean stop = false;
        while( kkk < (pMaxiter - 1) || !stop ) {
            double[][] x_old = parametersMatrix;
            double[][] velnew = compute_velocity(x_old, vel);
            vel = velnew;
            parametersMatrix = compute_particle(x_old, velnew);
            costvect = computeCostFunction(parametersMatrix);
            p_best = compute_pBest(parametersMatrix, costvect);
            g_best = compute_gBest(parametersMatrix, costvect);
            hist_g_best_value[kkk] = g_best_value;

            if (kkk > 500) {
                int sum = 0;
                for( int c = 0; c < 50; c++ ) {
                    if (Math.abs(hist_g_best_value[kkk - c] - hist_g_best_value[kkk - c - 1]) < 0.001) {
                        sum = sum + 1;
                    }
                }
                if (sum > 30) {
                    stop = true;
                    break;
                }
            }
            if (kkk > pMaxiter - 2) {
                break;
            }
            costvectold = costvect;
            // System.out.println("ite="+kkk);
            // System.out.println("fermati="+fermati);
            kkk++;

        }
        // for(int i=0;i<g_best.length;i++){
        // System.out.println(g_best[i]);
        //
        // }
        // System.out.println(g_best_value);

        pOptimal = g_best_value;
        outCalibrated = g_best;
    }

    private double[][] uniformNumberGenerator( double[] xmin, double[] xmax, int nsample ) {
        // Latin Hypercube sampling
        // double[][] LHSresult=new double [1][1];
        int nvar = xmin.length;
        double[][] s = new double[nsample][nvar];

        double[][] ran = new double[nsample][nvar];
        for( int row = 0; row < ran.length; row++ ) {
            for( int col = 0; col < ran[0].length; col++ ) {
                s[row][col] = (xmax[col] - xmin[col]) * Math.random() + xmin[col];
            }
        }
        return s;
    }

    public double[] computeCostFunction( double parametersMatrix[][] ) throws Exception {
        double[] res = new double[parametersMatrix.length];

        if (ModelName.equals("Banana")) {
            for( int numpart = 0; numpart < parametersMatrix.length; numpart++ ) {
                double xuno = parametersMatrix[numpart][0];
                double xdue = parametersMatrix[numpart][1];
                res[numpart] = 100 * (xdue - xuno * xuno) * (xdue - xuno * xuno) + (1 - xuno) * (1 - xuno);
            }
        }

        if (ModelName.equals("Eggcrate")) {
            for( int numpart = 0; numpart < parametersMatrix.length; numpart++ ) {
                double xuno = parametersMatrix[numpart][0];
                double xdue = parametersMatrix[numpart][1];
                res[numpart] = xuno * xuno + xdue * xdue + 25
                        * (Math.sin(xuno) * Math.sin(xuno) + Math.sin(xdue) * Math.sin(xdue));
            }
        }

        return res;

    }

    private double[] compute_gBest( double xx[][], double[] vettcostnew ) {
        double re[] = g_best;
        int pos = 0;
        double min = g_best_value;
        for( int i = 0; i < vettcostnew.length; i++ ) {
            if (Math.abs(vettcostnew[i]) <= min) {
                g_best_value = Math.abs(vettcostnew[i]);
                min = Math.abs(vettcostnew[i]);
                pos = i;
                for( int ii = 0; ii < xx[0].length; ii++ ) {
                    re[ii] = xx[pos][ii];
                }
            }
        }

        // System.out.println("minimo="+g_best_value);
        return re;
    }

    private double[][] compute_particle( double pos[][], double[][] vel ) {
        double xnew[][] = new double[pos.length][pos[0].length];
        for( int i = 0; i < vel.length; i++ ) {
            for( int j = 0; j < vel[0].length; j++ ) {
                xnew[i][j] = pos[i][j] + vel[i][j];
            }
        }
        double[][] xneww = reflectBounds(xnew, parRange_maxn, parRange_minn);
        return xneww;
    }

    private double[][] compute_velocity( double pos[][], double[][] vel ) {

        double velnew[][] = new double[pos.length][pos[0].length];
        for( int i = 0; i < vel.length; i++ ) {
            for( int j = 0; j < vel[0].length; j++ ) {
                double c1 = 1.5;
                double r1 = Math.random();
                double c2 = 2.5;
                double r2 = Math.random();
                double inertia = 0.5;
                velnew[i][j] = inertia * vel[i][j] + c1 * r1 * (p_best[i][j] - pos[i][j]) + c2 * r2 * (g_best[j] - pos[i][j]);
            }

        }
        return velnew;
    }

    private double[][] compute_pBest( double currentpos[][], double[] currentbest ) {
        double pos_best[][] = p_best;
        for( int i = 0; i < currentbest.length; i++ ) {
            // per tutti
            if (Math.abs(currentbest[i]) < Math.abs(p_best_value[i])) {
                // per nash
                // if(Math.abs(currentbest[i])>Math.abs(p_best_value[i])){
                p_best_value[i] = Math.abs(currentbest[i]);
                for( int j = 0; j < currentpos[0].length; j++ ) {
                    pos_best[i][j] = currentpos[i][j];
                }
            }
        }
        return pos_best;
    }

    private double[][] reflectBounds( double[][] neww, double[] ParRange_maxnn, double[] ParRange_minnn ) {
        double[][] y = neww;
        for( int row = 0; row < neww.length; row++ ) {
            for( int col = 0; col < neww[0].length; col++ ) {
                if (y[row][col] < ParRange_minnn[col]) {
                    y[row][col] = 2 * ParRange_minnn[col] - y[row][col];
                }
                if (y[row][col] > ParRange_maxnn[col]) {
                    y[row][col] = 2 * ParRange_maxnn[col] - y[row][col];
                }
            }
        }
        for( int row = 0; row < neww.length; row++ ) {
            for( int col = 0; col < neww[0].length; col++ ) {
                if (y[row][col] < parRange_minn[col]) {
                    y[row][col] = parRange_minn[col] + Math.random() * (parRange_maxn[col] - parRange_minn[col]);
                }
                if (y[row][col] > parRange_maxn[col]) {
                    y[row][col] = parRange_minn[col] + Math.random() * (parRange_maxn[col] - parRange_minn[col]);
                }
            }
        }

        return y;
    }

}