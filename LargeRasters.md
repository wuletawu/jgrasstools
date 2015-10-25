# Introduction #

One of the worst limitations of the java rasters is given by the fact that images are kept in array mode with integer index. This leads to an integer overflow when the number of rows\*cols is bigger than the maximu integer.
Since in JGrass we used to have the grass rasters backed on a double matrix, we are able to read way larger rasters (well, up to the RAM limit, they are kept in memory) work with them and also write them back to raster again.

# How to use them #

We have added support for matrix backed gridCoverages in some points of the code. It is a dirty hack, but it is also meant to be the last resort, since anyways the code would fail for large size data.

To be able to exploit the large raster support, it is necessary use the utility methods supplied to create rasters and coverages and iterators, since those will do the necessary check and do the right thing. It has to be clear that once the large raster support is used, the only supported format is the GRASS binary raster. It will not be possible to write the content for example to geotiff.

Some examples to:

  * create a writable raster

```
        WritableRaster pitRaster = CoverageUtilities.createDoubleWritableRaster(nCols, nRows, null, null, null);
```

  * get an iterator out of it

```
        pitIter = CoverageUtilities.getWritableRandomIterator(pitRaster);
```

  * which then can be used as always:

```
        for( int i = 0; i < nRows; i++ ) {
            for( int j = 0; j < nCols; j++ ) {
                double value = elevationIter.getSampleDouble(j, i, 0);
                if (!isNovalue(value)) {
                    pitIter.setSample(j, i, 0, value);
                } else {
                    pitIter.setSample(j, i, 0, PITNOVALUE);
                }
            }
        }
```

  * to then make a coverage out of it make sure to use the right method:

```
        outPit = CoverageUtilities.buildCoverage("pitfiller", pitRaster, regionMap, crs);
```