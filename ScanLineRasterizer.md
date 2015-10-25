<h2>Description</h2>

Module for polygon vector to raster conversion. It uses the <i>ScanLine algorithm</i> and it works only with polygon vectors.
<br>
<br>
<h3>Inputs</h3>
<ul>
<li>the polygon vector to rasterize</li>
<li>the value to use as raster value if no field is specified</li>
<li>the field to use to retrieve the category value for the raster</li>
</ul>
<br>
<br>
<h3>Output</h3>
<ul>
<li>the output raster</li>
</ul>


<h2>General Information</h2>

<blockquote>Module status: CERTIFIED</blockquote>

<blockquote>Name to use in a script: <b>rscanline</b></blockquote>

<blockquote>Authors: Andrea Antonello</blockquote>

<blockquote>Contacts: <a href='http://www.hydrologis.com'>http://www.hydrologis.com</a></blockquote>

<blockquote>License: General Public License Version 3 (GPLv3)</blockquote>

<blockquote>Keywords: Raster, Vector, Rasterize</blockquote>


<h2>Parameters</h2>

<h3>Input parameters</h3>
<table cellpadding='10' width='70%' border='1'>
<tr>
<td width='50%'> <b>inVector</b> </td><td width='50%'> The vector to rasterize. </td>
</tr>
<tr>
<td width='50%'> <b>pValue</b> </td><td width='50%'> The value to use as raster value if no field is given. </td>
</tr>
<tr>
<td width='50%'> <b>fCat</b> </td><td width='50%'> The field to use to retrieve the category value for the raster. </td>
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
<td width='50%'> <b>pMaxThreads</b> </td><td width='50%'> Max threads to use (default 15) </td>
</tr>
</table>

<h3>Output parameters</h3>
<table cellpadding='10' width='70%' border='1'>
<tr>
<td width='50%'> <b>outRaster</b> </td><td width='50%'> The output raster. </td>
</tr>
</table>

<h2>Developer example</h2>

An example usage of the algorithm can be found in the testcases suite:<br>
<a href='http://code.google.com/p/jgrasstools/source/browse/jgrassgears/src/test/java/org/jgrasstools/gears/modules/TestScanLineRasterizer.java'>ScanLineRasterizer</a>