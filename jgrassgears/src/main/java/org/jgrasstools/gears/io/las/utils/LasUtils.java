/*
 * This file is part of JGrasstools (http://www.jgrasstools.org)
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
package org.jgrasstools.gears.io.las.utils;

import java.util.ArrayList;
import java.util.List;

import org.geotools.data.simple.SimpleFeatureCollection;
import org.geotools.feature.simple.SimpleFeatureBuilder;
import org.geotools.feature.simple.SimpleFeatureTypeBuilder;
import org.jgrasstools.gears.io.las.core.LasRecord;
import org.jgrasstools.gears.utils.features.FeatureUtilities;
import org.jgrasstools.gears.utils.geometry.GeometryUtilities;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.opengis.feature.simple.SimpleFeature;
import org.opengis.feature.simple.SimpleFeatureType;
import org.opengis.referencing.crs.CoordinateReferenceSystem;

import com.vividsolutions.jts.geom.Coordinate;
import com.vividsolutions.jts.geom.Geometry;
import com.vividsolutions.jts.geom.Point;

/**
 * Utilities for Las handling classes.
 * 
 * @author Andrea Antonello (www.hydrologis.com)
 */
public class LasUtils {
    public static final String THE_GEOM = "the_geom";
    public static final String ELEVATION = "elev";
    public static final String INTENSITY = "intensity";
    public static final String CLASSIFICATION = "classifica";
    public static final String IMPULSE = "impulse";
    public static final String NUM_OF_IMPULSES = "numimpulse";
    private static SimpleFeatureBuilder lasSimpleFeatureBuilder;

    private static DateTime gpsEpoch = new DateTime(1980, 1, 6, 0, 0, 0, 0, DateTimeZone.UTC);

    public enum POINTTYPE {
        UNCLASSIFIED(1, "UNCLASSIFIED"), //
        GROUND(2, "GROUND"), //
        VEGETATION_MIN(3, "LOW VEGETATION"), //
        VEGETATION_MED(4, "MEDIUM VEGETATION"), //
        VEGETATION_MAX(5, "HIGH VEGETATION"), //
        BUILDING(6, "BUILDING"), //
        LOW_POINT(7, "LOW POINT (NOISE)"), //
        MASS_POINT(8, "MODEL KEY-POINT (MASS)"), //
        WATER(9, "WATER"), //
        OVERLAP(12, "OVERLAP");

        private String label;
        private int value;

        POINTTYPE( int value, String label ) {
            this.value = value;
            this.label = label;
        }

        public String getLabel() {
            return label;
        }

        public int getValue() {
            return value;
        }
    }

    /**
     * Creates a builder for las data.
     * 
     * The attributes are:
     * 
     * <ul>
     *   <li>the_geom:  a point geometry</li>
     *   <li>elev</li>
     *   <li>intensity</li>
     *   <li>classification</li>
     *   <li>impulse</li>
     *   <li>numimpulse</li>
     * </ul>
     * 
     * 
     * @param crs the {@link CoordinateReferenceSystem}.
     * @return the {@link SimpleFeatureBuilder builder}.
     */
    public static SimpleFeatureBuilder getLasFeatureBuilder( CoordinateReferenceSystem crs ) {
        if (lasSimpleFeatureBuilder == null) {
            SimpleFeatureTypeBuilder b = new SimpleFeatureTypeBuilder();
            b.setName("lasdata");
            b.setCRS(crs);
            b.add(THE_GEOM, Point.class);
            b.add(ELEVATION, Double.class);
            b.add(INTENSITY, Double.class);
            b.add(CLASSIFICATION, Integer.class);
            b.add(IMPULSE, Double.class);
            b.add(NUM_OF_IMPULSES, Double.class);
            final SimpleFeatureType featureType = b.buildFeatureType();
            lasSimpleFeatureBuilder = new SimpleFeatureBuilder(featureType);
        }
        return lasSimpleFeatureBuilder;
    }

    public static SimpleFeature tofeature( LasRecord r, CoordinateReferenceSystem crs ) {
        final Point point = GeometryUtilities.gf().createPoint(new Coordinate(r.x, r.y));
        final Object[] values = new Object[]{point, r.z, r.intensity, r.classification, r.returnNumber, r.numberOfReturns};
        SimpleFeatureBuilder lasFeatureBuilder = getLasFeatureBuilder(crs);
        lasFeatureBuilder.addAll(values);
        final SimpleFeature feature = lasFeatureBuilder.buildFeature(null);
        return feature;
    }

    public static List<LasRecord> getLasRecordsFromFeatureCollection( SimpleFeatureCollection lasCollection ) {
        List<SimpleFeature> featuresList = FeatureUtilities.featureCollectionToList(lasCollection);
        List<LasRecord> lasList = new ArrayList<LasRecord>();
        for( SimpleFeature lasFeature : featuresList ) {
            LasRecord r = new LasRecord();
            Coordinate coordinate = ((Geometry) lasFeature.getDefaultGeometry()).getCoordinate();
            r.x = coordinate.x;
            r.y = coordinate.y;
            double elevation = ((Number) lasFeature.getAttribute(ELEVATION)).doubleValue();
            r.z = elevation;
            short intensity = ((Number) lasFeature.getAttribute(INTENSITY)).shortValue();
            r.intensity = intensity;
            int classification = ((Number) lasFeature.getAttribute(CLASSIFICATION)).intValue();
            r.classification = classification;
            int impulse = ((Number) lasFeature.getAttribute(IMPULSE)).intValue();
            r.returnNumber = impulse;
            int numOfImpulses = ((Number) lasFeature.getAttribute(NUM_OF_IMPULSES)).intValue();
            r.numberOfReturns = numOfImpulses;
            lasList.add(r);
        }
        return lasList;
    }

    /**
     * Converts las gps time to {@link DateTime}.
     * 
     * @param gpsTime the time value.
     * @param gpsTimeType the time type (0=week.seconds, 1=adjusted standard gps time)
     * @return the UTC date object.
     */
    public static DateTime gpsTimeToDateTime( double gpsTime, int gpsTimeType ) {
        if (gpsTimeType == 0) {
            throw new RuntimeException("Not implemented yet.");
            // long JAN61980 = 44244;
            // double SEC_PER_DAY = 86400.0;
            // long JAN11901 = 15385;
            // long longModifiedJulianDate = (long) gpsTime;
            // long gpsWeek = (longModifiedJulianDate - JAN61980) / 7;
            //
            // double doubleModifiedJulianDate = gpsTime - longModifiedJulianDate;
            // double secondsOfWeek = ((longModifiedJulianDate - JAN61980) - gpsWeek * 7 +
            // doubleModifiedJulianDate) * SEC_PER_DAY;
            //
            // DateTime dt = new DateTime(1980, 1, 6, 0, 0, 0, 0);
            // System.out.println(dt);
            // dt = dt.plusWeeks((int) gpsWeek);
            // System.out.println(dt);
            // DateTime dt1 = new DateTime(longModifiedJulianDate);
            // System.out.println(dt1);
            // return dt;
        } else {
            // gps time is adjusted gps time
            double standardGpsTimeSeconds = gpsTime + 1E9;
            double standardGpsTimeMillis = standardGpsTimeSeconds * 1000;
            DateTime dt1 = gpsEpoch.plus((long) standardGpsTimeMillis);
            return dt1;
        }

    }

    /**
     * Converts an date object to standard gps time.
     * 
     * @param dateTime the object (UTC).
     * @return the standard gps time in milliseconds.
     */
    public static double dateTimeToStandardGpsTime( DateTime dateTime ) {
        long millis = dateTime.getMillis() - gpsEpoch.getMillis();
        return millis;
    }

    public static void main( String[] args ) {
        System.out.println(gpsTimeToDateTime(206990.867192313, 1));
    }

}