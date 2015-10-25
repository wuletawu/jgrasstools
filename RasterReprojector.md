<h2>Description</h2>

RasterConverter.html

<h2>General Information</h2>

> Module status: CERTIFIED

> Name to use in a script: <b>rreproject</b>

> Authors: Andrea Antonello

> Contacts: http://www.hydrologis.com

> License: General Public License Version 3 (GPLv3)

> Keywords: Crs, Reprojection, Raster, RasterConverter, RasterReader


<h2>Parameters</h2>

<h3>Input parameters</h3>
<table cellpadding='10' width='70%' border='1'>
<tr>
<td width='50%'> <b>inRaster</b> </td><td width='50%'> The raster that has to be reprojected. </td>
</tr>
<tr>
<td width='50%'> <b>pNorth</b> </td><td width='50%'> The north bound of the region to consider </td>
</tr>
<tr>
<td width='50%'> <b>pSouth</b> </td><td width='50%'> The south bound of the region to consider </td>
</tr>
<tr>
<td width='50%'> <b>pWest</b> </td><td width='50%'> The west bound of the region to consider </td>
</tr>
<tr>
<td width='50%'> <b>pEast</b> </td><td width='50%'> The east bound of the region to consider </td>
</tr>
<tr>
<td width='50%'> <b>pRows</b> </td><td width='50%'> The rows of the region to consider </td>
</tr>
<tr>
<td width='50%'> <b>pCols</b> </td><td width='50%'> The cols of the region to consider </td>
</tr>
<tr>
<td width='50%'> <b>pCode</b> </td><td width='50%'> The code defining the target coordinate reference system, composed by authority and code number (ex. EPSG:4328). </td>
</tr>
<tr>
<td width='50%'> <b>pInterpolation</b> </td><td width='50%'> The interpolation type to use: nearest neightbour (0), bilinear (1), bicubic (2) </td>
</tr>
</table>

<h3>Output parameters</h3>
<table cellpadding='10' width='70%' border='1'>
<tr>
<td width='50%'> <b>outRaster</b> </td><td width='50%'> The reprojected output raster. </td>
</tr>
</table>

<h2>Developer example</h2>

An example usage of the algorithm can be found in the testcases suite:
[RasterReprojector](http://code.google.com/p/jgrasstools/source/browse/jgrassgears/src/test/java/org/jgrasstools/gears/modules/TestRasterReprojector.java)