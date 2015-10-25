
```
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

/*
 * This script generates tiles for a set of raster and vector layers.
 * 
 * @author Andrea Antonello - www.hydrologis.com
 * @since 0.7.6
 */

// name of the output tiles folder for each iteration (in this case we show a cycle over 4 tileset configurations)
def tilesName = [
            "valsole_depositi_tr200",
            "valsole_h_tr200",
            "valsole_vel_tr200",
            "valsole_intensita_tr200"
            ];

// path into which to generate the output tiles folder
def outputTilesFolder = "/home/moovida/TMP/AAAAAAAAA_BM/mappe_x_android/outtiles/"

// the file containing the list of rasters to load for each iteration
def inRasterFile = [
            "/home/moovida/TMP/AAAAAAAAA_BM/mappe_x_android/zzz_rasters_depositi.txt",
            "/home/moovida/TMP/AAAAAAAAA_BM/mappe_x_android/zzz_rasters_h.txt",
            "/home/moovida/TMP/AAAAAAAAA_BM/mappe_x_android/zzz_rasters_vel.txt",
            "/home/moovida/TMP/AAAAAAAAA_BM/mappe_x_android/zzz_rasters_intensita.txt"
            ];

// the file containing the list of vectors to load (the same for each iteration)
def inVectorFile = "/home/moovida/TMP/AAAAAAAAA_BM/mappe_x_android/zzz_vectors.txt";

// the shapefile defining the area to process
def bondsShapePath = "/home/moovida/TMP/AAAAAAAAA_BM/mappe_x_android/area_stampa.shp";

// read the bounds from the area file
double[] nsew = org.jgrasstools.gears.io.vectorreader.VectorReader.readBounds(bondsShapePath);

// iterate over each map to process
for(int i = 0; i < 4; i++){

    // create the cimulation object
    sim = new oms3.SimBuilder(logging:'ALL').sim(name:'tmsgenerator') {
       model {

          // define the components in the game
          components  {
            'gen'         'tmsgenerator'  // only component we need is the tile generator
          }

          // define the parameters of the components
          parameter  {
            'gen.inVectorFile'         inVectorFile        // file containing the vector files to use
            'gen.inRasterFile'         inRasterFile[i]     // file containing the raster files to use
            'gen.pMinzoom'             13                  // the minimum zoom for which to generate tiles
            'gen.pMaxzoom'             17                  // the maximum zoom for which to generate tiles
            'gen.pName'                tilesName[i]        // the name of the currently processed tileset
            'gen.inPath'               outputTilesFolder   // the folder where to place the tileset
            'gen.pWest'                nsew[3]             // west of ROI
            'gen.pEast'                nsew[2]             // east of ROI
            'gen.pNorth'               nsew[0]             // north of ROI
            'gen.pSouth'               nsew[1]             // south of ROI
            'gen.pEpsg'                'EPSG:32632'        // the EPSG code of the dataset used
          }
            
          // connect modules (in this case there is just one)
          connect  {
          }

       }
    }

    // run this simulation
    sim.run();
}


```