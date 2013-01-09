/* This file is part of JGrasstools (http://www.jgrasstools.org)
 * (C) HydroloGIS - www.hydrologis.com 
 * 
 * JGrasstools is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.jgrasstools.modules;

import static org.jgrasstools.gears.libs.modules.JGTConstants.isNovalue;

import java.awt.image.WritableRaster;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;

import javax.media.jai.iterator.RandomIterFactory;
import javax.media.jai.iterator.WritableRandomIter;

import oms3.annotations.Author;
import oms3.annotations.Description;
import oms3.annotations.Documentation;
import oms3.annotations.Execute;
import oms3.annotations.In;
import oms3.annotations.Keywords;
import oms3.annotations.Label;
import oms3.annotations.License;
import oms3.annotations.Name;
import oms3.annotations.Out;
import oms3.annotations.Status;

import org.geotools.coverage.grid.GridCoverage2D;
import org.geotools.coverage.grid.GridGeometry2D;
import org.geotools.data.simple.SimpleFeatureCollection;
import org.geotools.feature.FeatureCollection;
import org.geotools.feature.FeatureIterator;
import org.geotools.feature.SchemaException;
import org.geotools.geometry.DirectPosition2D;
import org.jgrasstools.gears.libs.exceptions.ModelsIllegalargumentException;
import org.jgrasstools.gears.libs.exceptions.ModelsRuntimeException;
import org.jgrasstools.gears.libs.modules.JGTConstants;
import org.jgrasstools.gears.libs.modules.JGTModel;
import org.jgrasstools.gears.libs.modules.ModelsEngine;
import org.jgrasstools.gears.utils.RegionMap;
import org.jgrasstools.gears.utils.coverage.CoverageUtilities;
import org.jgrasstools.gears.utils.math.matrixes.ColumnVector;
import org.jgrasstools.gears.utils.math.matrixes.LinearSystem;
import org.jgrasstools.hortonmachine.i18n.HortonMessageHandler;
import org.opengis.feature.simple.SimpleFeature;
import org.opengis.geometry.DirectPosition;
import org.opengis.geometry.MismatchedDimensionException;
import org.opengis.referencing.operation.MathTransform;

import com.vividsolutions.jts.geom.Coordinate;
import com.vividsolutions.jts.geom.Geometry;

@Description("Ordinary kriging algorithm.")
@Documentation("OmsKriging.html")
@Author(name = "Giuseppe Formetta, Daniele Andreis, Silvia Franceschi, Andrea Antonello", contact = "http://www.hydrologis.com,  http://www.ing.unitn.it/dica/hp/?user=rigon")
@Keywords("OmsKriging, Hydrology")
@Label(JGTConstants.STATISTICS)
@Name("_kriging")
@Status(Status.EXPERIMENTAL)
@License("General Public License Version 3 (GPLv3)")
@SuppressWarnings("nls")
public class OmsKriging extends JGTModel {

    @Description("The vector of the measurement point, containing the position of the stations.")
    @In
    public SimpleFeatureCollection inStations = null;

    @Description("The field of the vector of stations, defining the id.")
    @In
    public String fStationsid = null;

    @Description("The field of the vector of stations, defining the elevation.")
    @In
    public String fStationsZ = null;

    @Description("The file with the measured data, to be interpolated.")
    @In
    public HashMap<Integer, double[]> inData = null;

    @Description("The vector of the points in which the data have to be interpolated.")
    @In
    public SimpleFeatureCollection inInterpolate = null;

    @Description("The field of the interpolated vector points, defining the id.")
    @In
    public String fInterpolateid = null;

    @Description("The field of the interpolated vector points, defining the elevation.")
    @In
    public String fPointZ = null;

    /**
     * Define the mode. It is possible 4 alternatives: <li>mode ==0, the value
     * to calculate are in a non-regular grid (the coordinates are stored in a
     * {@link FeatureCollection}, pointsToInterpolate. This is a 2-D
     * interpolation, so the z coordinates are null. <li>mode ==1, the value to
     * calculate are in a non-regular grid (the coordinates are stored in a
     * {@link FeatureCollection}, pointsToInterpolate. This is a 3-D
     * interpolation.. <li>mode ==2, the value to calculate are in a regular
     * grid (the coordinates are stored in a {@link GridCoverage2D},
     * gridToInterpolate. This is a 2-D interpolation. <li>mode ==3, the value
     * to calculate are in a regular grid (the coordinates are stored in a
     * {@link GridCoverage2D}, gridToInterpolate. This is a 3-D interpolation,
     * so the grid have to contains a dem.
     */
    @Description("The interpolation mode (0 = interpolate on irregular grid, 1 = interpolate on regular grid).")
    @In
    public int pMode = 0;

    /**
     * The integral scale, this is necessary to calculate the variogram if the
     * program use {@link Kriging2.variogram(rx,ry,rz)}.
     */
    @Description("The integral scale.")
    @In
    public double[] pIntegralscale = null;

    /**
     * Variance of the measure field.
     */
    @Description("The variance.")
    @In
    public double pVariance = 0;

    /**
     * The logarithm selector, if it's true then the models runs with the log of
     * the data.
     */
    @Description("Switch for logaritmic run selection.")
    @In
    public boolean doLogarithmic = false;

    @Description("The collection of the points in which the data needs to be interpolated.")
    @In
    public GridGeometry2D inInterpolationGrid = null;

    public int defaultVariogramMode = 0;

    @Description("The type of theoretical semivariogram: 0 = Gaussian; 1 = Exponential.")
    @In
    public double pSemivariogramType = 0;

    @Description("Include zeros in computations (default is true).")
    @In
    public boolean doIncludezero = true;

    @Description("The range if the models runs with the gaussian variogram.")
    @In
    public double pA;

    @Description("The sill if the models runs with the gaussian variogram.")
    @In
    public double pS;

    @Description("Is the nugget if the models runs with the gaussian variogram.")
    @In
    public double pNug;

    @Description("The interpolated gridded data (for mode 2 and 3.")
    @Out
    public GridCoverage2D outGrid = null;

    @Description("The interpolated data (for mode 0 and 1).")
    @Out
    public HashMap<Integer, double[]> outData = null;

    /**
     * A tolerance.
     */
    private static final double TOLL = 1.0d * 10E-8;

    private HortonMessageHandler msg = HortonMessageHandler.getInstance();

    private WritableRaster outWR = null;
    private int cols;
    private int rows;
    private double south;
    private double west;
    private double xres;
    private double yres;

    /**
     * Executing ordinary kriging.
     * <p>
     * <li>Verify if the parameters are correct.
     * <li>Calculating the matrix of the covariance (a).
     * <li>For each point to interpolated, evalutate the know term vector (b)
     * and solve the system (a x)=b where x is the weight.
     * </p>
     * 
     * @throws SchemaException
     */

    @Execute
    public void executeKriging() throws Exception {
        verifyInput();

        List<Double> xStationList = new ArrayList<Double>();
        List<Double> yStationList = new ArrayList<Double>();
        List<Double> zStationList = new ArrayList<Double>();
        List<Double> hStationList = new ArrayList<Double>();

        /*
         * counter for the number of station with measured value !=0.
         */
        int n1 = 0;
        /*
         * Store the station coordinates and measured data in the array.
         */
        FeatureIterator<SimpleFeature> stationsIter = inStations.features();
        try {
            while( stationsIter.hasNext() ) {
                SimpleFeature feature = stationsIter.next();
                int id = ((Number) feature.getAttribute(fStationsid)).intValue();
                double z = 0;
                if (fStationsZ != null) {
                    try {
                        z = ((Number) feature.getAttribute(fStationsZ)).doubleValue();
                    } catch (NullPointerException e) {
                        pm.errorMessage(msg.message("kriging.noStationZ"));
                        throw new Exception(msg.message("kriging.noStationZ"));

                    }
                }
                Coordinate coordinate = ((Geometry) feature.getDefaultGeometry()).getCentroid().getCoordinate();
                double[] h = inData.get(id);
                if (h == null || isNovalue(h[0])) {
                    /*
                     * skip data for non existing stations, they are allowed.
                     * Also skip novalues.
                     */
                    continue;
                }
                if (defaultVariogramMode == 0) {
                    if (doIncludezero) {
                        if (Math.abs(h[0]) >= 0.0) { // TOLL
                            xStationList.add(coordinate.x);
                            yStationList.add(coordinate.y);
                            zStationList.add(z);
                            hStationList.add(h[0]);
                            n1 = n1 + 1;
                        }
                    } else {
                        if (Math.abs(h[0]) > 0.0) { // TOLL
                            xStationList.add(coordinate.x);
                            yStationList.add(coordinate.y);
                            zStationList.add(z);
                            hStationList.add(h[0]);
                            n1 = n1 + 1;
                        }
                    }
                } else if (defaultVariogramMode == 1) {
                    if (doIncludezero) {
                        if (Math.abs(h[0]) >= 0.0) { // TOLL
                            xStationList.add(coordinate.x);
                            yStationList.add(coordinate.y);
                            zStationList.add(z);
                            hStationList.add(h[0]);
                            n1 = n1 + 1;
                        }
                    } else {
                        if (Math.abs(h[0]) > 0.0) { // TOLL
                            xStationList.add(coordinate.x);
                            yStationList.add(coordinate.y);
                            zStationList.add(z);
                            hStationList.add(h[0]);
                            n1 = n1 + 1;
                        }
                    }

                }
            }
        } finally {
            stationsIter.close();
        }

        int nStaz = xStationList.size();
        /*
         * The coordinates of the station points plus in last position a place
         * for the coordinate of the point to interpolate.
         */
        double[] xStation = new double[nStaz + 1];
        double[] yStation = new double[nStaz + 1];
        double[] zStation = new double[nStaz + 1];
        double[] hStation = new double[nStaz + 1];
        boolean areAllEquals = true;
        if (nStaz != 0) {
            xStation[0] = xStationList.get(0);
            yStation[0] = yStationList.get(0);
            zStation[0] = zStationList.get(0);
            hStation[0] = hStationList.get(0);
            double previousValue = hStation[0];

            for( int i = 1; i < nStaz; i++ ) {

                double xTmp = xStationList.get(i);
                double yTmp = yStationList.get(i);
                double zTmp = zStationList.get(i);
                double hTmp = hStationList.get(i);
                boolean doubleStation = ModelsEngine.verifyDoubleStation(xStation, yStation, zStation, hStation, xTmp, yTmp,
                        zTmp, hTmp, i, false, pm);
                if (!doubleStation) {
                    xStation[i] = xTmp;
                    yStation[i] = yTmp;
                    zStation[i] = zTmp;
                    hStation[i] = hTmp;
                    if (areAllEquals && hStation[i] != previousValue) {
                        areAllEquals = false;
                    }
                    previousValue = hStation[i];
                }
            }
        }
        LinkedHashMap<Integer, Coordinate> pointsToInterpolateId2Coordinates = null;
        // vecchio int numPointToInterpolate = getNumPoint(inInterpolate);
        int numPointToInterpolate = 0;

        /*
         * if the isLogarithmic is true then execute the model with log value.
         */
        // vecchio double[] result = new double[numPointToInterpolate];

        if (pMode == 0) {
            pointsToInterpolateId2Coordinates = getCoordinate(numPointToInterpolate, inInterpolate, fInterpolateid);
        } else if (pMode == 1) {
            pointsToInterpolateId2Coordinates = getCoordinate(inInterpolationGrid);
            numPointToInterpolate = pointsToInterpolateId2Coordinates.size();
        } else {
            throw new ModelsIllegalargumentException("The parameter pMode can only be 0 or 1.", this);
        }

        Set<Integer> pointsToInterpolateIdSet = pointsToInterpolateId2Coordinates.keySet();
        Iterator<Integer> idIterator = pointsToInterpolateIdSet.iterator();
        int j = 0;
        // vecchio int[] idArray = new int[inInterpolate.size()];
        int[] idArray = new int[pointsToInterpolateId2Coordinates.size()];
        double[] result = new double[pointsToInterpolateId2Coordinates.size()];
        if (n1 != 0) {
            if (doLogarithmic) {
                for( int i = 0; i < nStaz; i++ ) {
                    if (hStation[i] > 0.0) {
                        hStation[i] = Math.log(hStation[i]);
                    }
                }
            }

            /*
             * calculating the covariance matrix.
             */
            double[][] covarianceMatrix = covMatrixCalculating(xStation, yStation, zStation, n1);
            /*
             * extract the coordinate of the points where interpolated.
             */

            /*
             * initialize the solution and its variance vector.
             */

            if (!areAllEquals && n1 > 1) {
                // pm.beginTask(msg.message("kriging.working"),inInterpolate.size());
                pm.beginTask(msg.message("kriging.working"), pointsToInterpolateId2Coordinates.size());
                while( idIterator.hasNext() ) {
                    double sum = 0.;
                    int id = idIterator.next();
                    idArray[j] = id;
                    Coordinate coordinate = (Coordinate) pointsToInterpolateId2Coordinates.get(id);
                    xStation[n1] = coordinate.x;
                    yStation[n1] = coordinate.y;
                    zStation[n1] = coordinate.z;
                    /*
                     * calculating the right hand side of the kriging linear
                     * system.
                     */
                    double[] knownTerm = knownTermsCalculation(xStation, yStation, zStation, n1);

                    /*
                     * solve the linear system, where the result is the weight.
                     */
                    ColumnVector knownTermColumn = new ColumnVector(knownTerm);
                    LinearSystem linearSystem = new LinearSystem(covarianceMatrix);
                    ColumnVector solution = linearSystem.solve(knownTermColumn, true);
                    // Matrix a = new Matrix(covarianceMatrix);
                    // Matrix b = new Matrix(knownTerm, knownTerm.length);
                    // Matrix x = a.solve(b);
                    double[] moltiplicativeFactor = solution.copyValues1D();

                    double h0 = 0.0;
                    for( int k = 0; k < n1; k++ ) {
                        h0 = h0 + moltiplicativeFactor[k] * hStation[k];
                        sum = sum + moltiplicativeFactor[k];
                    }

                    if (doLogarithmic) {
                        h0 = Math.exp(h0);
                    }
                    result[j] = h0;
                    j++;
                    if (Math.abs(sum - 1) >= TOLL) {
                        throw new ModelsRuntimeException("Error in the coffeicients calculation", this.getClass().getSimpleName());
                    }

                }
                pm.worked(1);
            } else if (n1 == 1 || areAllEquals) {
                double tmp = hStation[0];
                int k = 0;
                pm.message(msg.message("kriging.setequalsvalue"));
                pm.beginTask(msg.message("kriging.working"), inInterpolate.size());
                while( idIterator.hasNext() ) {
                    int id = idIterator.next();
                    result[k] = tmp;
                    idArray[k] = id;
                    k++;
                    pm.worked(1);
                }

            }
            pm.done();
            if (pMode == 0) {
                storeResult(result, idArray);
            } else {
                storeResult(result, pointsToInterpolateId2Coordinates);
            }
        } else {
            pm.errorMessage("No rain for this time step");
            j = 0;
            double[] value = inData.values().iterator().next();
            while( idIterator.hasNext() ) {
                int id = idIterator.next();
                idArray[j] = id;
                result[j] = value[0];
                j++;
            }
            if (pMode == 0) {
                storeResult(result, idArray);
            } else {
                storeResult(result, pointsToInterpolateId2Coordinates);
            }
        }
    }

    /**
     * Verify the input of the model.
     */
    private void verifyInput() {
        if (inData == null || inStations == null) {
            throw new NullPointerException(msg.message("kriging.stationproblem"));
        }
        if (pMode < 0 || pMode > 1) {
            throw new IllegalArgumentException(msg.message("kriging.defaultMode"));
        }
        // if (pMode == 0 && (fStationsZ == null || fPointZ == null)) {
        // pm.errorMessage(msg.message("kriging.noElevation"));
        // throw new IllegalArgumentException(msg.message("kriging.noElevation"));
        // }

        if (defaultVariogramMode != 0 && defaultVariogramMode != 1) {
            throw new IllegalArgumentException(msg.message("kriging.variogramMode"));
        }
        if (defaultVariogramMode == 0) {
            if (pVariance == 0 || pIntegralscale[0] == 0 || pIntegralscale[1] == 0 || pIntegralscale[2] == 0) {

                pm.errorMessage(msg.message("kriging.noParam"));
                pm.errorMessage("varianza " + pVariance);
                pm.errorMessage("Integral scale x " + pIntegralscale[0]);
                pm.errorMessage("Integral scale y " + pIntegralscale[1]);
                pm.errorMessage("Integral scale z " + pIntegralscale[2]);
            }
        }
        if (defaultVariogramMode == 1) {
            if (pNug == 0 || pS == 0 || pA == 0) {
                pm.errorMessage(msg.message("kriging.noParam"));
                pm.errorMessage("Nugget " + pNug);
                pm.errorMessage("Sill " + pS);
                pm.errorMessage("Range " + pA);
            }
        }

        if ((pMode == 0) && inInterpolate == null) {
            throw new ModelsIllegalargumentException(msg.message("kriging.noPoint"), this);
        }
        if (pMode == 1 && inInterpolationGrid == null) {
            throw new ModelsIllegalargumentException("The gridded interpolation needs a gridgeometry in input.", this);
        }

    }

    /**
     * Store the result in a HashMap (if the mode is 0 or 1)
     * 
     * @param result2
     *            the result of the model
     * @param id
     *            the associated id of the calculating points.
     * @throws SchemaException
     * @throws SchemaException
     */
    private void storeResult( double[] result2, int[] id ) throws SchemaException {
        outData = new HashMap<Integer, double[]>();
        for( int i = 0; i < result2.length; i++ ) {
            outData.put(id[i], new double[]{result2[i]});
        }
    }

    private void storeResult( double[] interpolatedValues, HashMap<Integer, Coordinate> interpolatedCoordinatesMap )
            throws MismatchedDimensionException, Exception {

        WritableRandomIter outIter = RandomIterFactory.createWritable(outWR, null);

        Set<Integer> pointsToInterpolateIdSett = interpolatedCoordinatesMap.keySet();
        Iterator<Integer> idIterator = pointsToInterpolateIdSett.iterator();
        int c = 0;
        MathTransform transf = inInterpolationGrid.getCRSToGrid2D();

        final DirectPosition gridPoint = new DirectPosition2D();

        while( idIterator.hasNext() ) {
            int id = idIterator.next();
            Coordinate coordinate = (Coordinate) interpolatedCoordinatesMap.get(id);

            DirectPosition point = new DirectPosition2D(inInterpolationGrid.getCoordinateReferenceSystem(), coordinate.x,
                    coordinate.y);
            transf.transform(point, gridPoint);

            double[] gridCoord = gridPoint.getCoordinate();
            int x = (int) gridCoord[0];
            int y = (int) gridCoord[1];

            outIter.setSample(x, y, 0, interpolatedValues[c]);
            c++;

        }

        RegionMap regionMap = CoverageUtilities.gridGeometry2RegionParamsMap(inInterpolationGrid);

        outGrid = CoverageUtilities
                .buildCoverage("gridded", outWR, regionMap, inInterpolationGrid.getCoordinateReferenceSystem());

    }

    private LinkedHashMap<Integer, Coordinate> getCoordinate( GridGeometry2D grid ) {
        LinkedHashMap<Integer, Coordinate> out = new LinkedHashMap<Integer, Coordinate>();
        int count = 0;
        RegionMap regionMap = CoverageUtilities.gridGeometry2RegionParamsMap(grid);
        cols = regionMap.getCols();
        rows = regionMap.getRows();
        south = regionMap.getSouth();
        west = regionMap.getWest();
        xres = regionMap.getXres();
        yres = regionMap.getYres();

        outWR = CoverageUtilities.createDoubleWritableRaster(cols, rows, null, null, null);

        double northing = south;
        double easting = west;
        for( int i = 0; i < cols; i++ ) {
            easting = easting + xres;
            for( int j = 0; j < rows; j++ ) {
                northing = northing + yres;
                Coordinate coordinate = new Coordinate();
                coordinate.x = west + i * xres;
                coordinate.y = south + j * yres;
                out.put(count, coordinate);
                count++;
            }
        }

        return out;
    }

    /**
     * Extract the coordinate of a FeatureCollection in a HashMap with an ID as
     * a key.
     * 
     * @param nStaz
     * @param collection
     * @throws Exception
     *             if a fiel of elevation isn't the same of the collection
     */
    private LinkedHashMap<Integer, Coordinate> getCoordinate( int nStaz, SimpleFeatureCollection collection, String idField )
            throws Exception {
        LinkedHashMap<Integer, Coordinate> id2CoordinatesMap = new LinkedHashMap<Integer, Coordinate>();
        FeatureIterator<SimpleFeature> iterator = collection.features();
        Coordinate coordinate = null;
        try {
            while( iterator.hasNext() ) {
                SimpleFeature feature = iterator.next();
                int name = ((Number) feature.getAttribute(idField)).intValue();
                coordinate = ((Geometry) feature.getDefaultGeometry()).getCentroid().getCoordinate();
                double z = 0;
                if (fPointZ != null) {
                    try {
                        z = ((Number) feature.getAttribute(fPointZ)).doubleValue();
                    } catch (NullPointerException e) {
                        pm.errorMessage(msg.message("kriging.noPointZ"));
                        throw new Exception(msg.message("kriging.noPointZ"));
                    }
                }
                coordinate.z = z;
                id2CoordinatesMap.put(name, coordinate);
            }
        } finally {
            iterator.close();
        }

        return id2CoordinatesMap;
    }

    /**
     * The gaussian variogram
     * 
     * @param c0
     *            nugget.
     * @param a
     *            range.
     * @param sill
     *            sill.
     * @param rx
     *            x distance.
     * @param ry
     *            y distance.
     * @param rz
     *            z distance.
     * @return the variogram value
     */
    private double variogram( double c0, double a, double sill, double rx, double ry, double rz ) {
        if (isNovalue(rz)) {
            rz = 0;
        }
        double value = 0;
        double h2 = Math.sqrt(rx * rx + rz * rz + ry * ry);
        if (pSemivariogramType == 0) {
            value = c0 + sill * (1 - Math.exp(-(h2 * h2) / (a * a)));
        }
        if (pSemivariogramType == 1) {
            // primotest semivariogram
            value = c0 + sill * (1 - Math.exp(-(h2) / (a)));
        }
        return value;
    }

    /**
     * 
     * @param rx
     *            x distance.
     * @param ry
     *            y distance.
     * @param rz
     *            z distance.
     * @return
     */
    private double variogram( double rx, double ry, double rz ) {
        if (isNovalue(rz)) {
            rz = 0;
        }
        double h2 = (rx / pIntegralscale[0]) * (rx / pIntegralscale[0]) + (ry / pIntegralscale[1]) * (ry / pIntegralscale[1])
                + (rz / pIntegralscale[2]) * (rz / pIntegralscale[2]);
        if (h2 < TOLL) {
            return pVariance;
        } else {
            return pVariance * Math.exp(-Math.sqrt(h2));
        }

    }

    /**
     * 
     * 
     * @param x
     *            the x coordinates.
     * @param y
     *            the y coordinates.
     * @param z
     *            the z coordinates.
     * @param n
     *            the number of the stations points.
     * @return
     */
    private double[][] covMatrixCalculating( double[] x, double[] y, double[] z, int n ) {
        double[][] ap = new double[n + 1][n + 1];
        if (defaultVariogramMode == 0) {
            for( int j = 0; j < n; j++ ) {
                for( int i = 0; i <= j; i++ ) {
                    double rx = x[i] - x[j];
                    double ry = y[i] - y[j];
                    double rz = 0;
                    if (pMode == 0) {
                        rz = z[i] - z[j];
                    }
                    double tmp = variogram(rx, ry, rz);

                    ap[j][i] = tmp;
                    ap[i][j] = tmp;

                }
            }
        } else if (defaultVariogramMode == 1) {
            for( int j = 0; j < n; j++ ) {
                for( int i = 0; i < n; i++ ) {
                    double rx = x[i] - x[j];
                    double ry = y[i] - y[j];
                    double rz = 0;
                    if (pMode == 0) {
                        rz = z[i] - z[j];
                    }
                    double tmp = variogram(pNug, pA, pS, rx, ry, rz);

                    ap[j][i] = tmp;
                    ap[i][j] = tmp;

                }
            }

        }
        for( int i = 0; i < n; i++ ) {
            ap[i][n] = 1.0;
            ap[n][i] = 1.0;

        }
        ap[n][n] = 0;
        return ap;

    }

    /**
     * 
     * @param x
     *            the x coordinates.
     * @param y
     *            the y coordinates.
     * @param z
     *            the z coordinates.
     * @param n
     *            the number of the stations points.
     * @return
     */
    private double[] knownTermsCalculation( double[] x, double[] y, double[] z, int n ) {

        double[] gamma = new double[n + 1];
        if (defaultVariogramMode == 0) {
            for( int i = 0; i < n; i++ ) {
                double rx = x[i] - x[n];
                double ry = y[i] - y[n];
                double rz = z[i] - z[n];
                gamma[i] = variogram(rx, ry, rz);
            }
        } else if (defaultVariogramMode == 1) {
            for( int i = 0; i < n; i++ ) {
                double rx = x[i] - x[n];
                double ry = y[i] - y[n];
                double rz = z[i] - z[n];
                gamma[i] = variogram(pNug, pA, pS, rx, ry, rz);
            }

        }
        gamma[n] = 1.0;
        return gamma;

    }

}