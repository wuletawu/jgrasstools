<h2>Description</h2>

Generic module for raster reader. Supported raster formats are:
<ul>
<li>ESRI asci</li>
<li>GRASS binary format</li>
<li>tiff</li>
<li>adf (only if there is installed the needed library</li>
</ul>
The model recognize the raster type from the file extension, if you are not using a conventional extension you can force the program to read that format simply specifying the <i>type</i>.
<br>
<br>
<h3>Parameters</h3>
<ul>
<li>the file path of the raster that has to be read</li>
<li>the file nodata</li>
<li>the output raster nodata</li>
<li>the optional coordinates of the boundaries of the raster (north, south, east and west)</li>
<li>the optional working resolution (in x and y)</li>
<li>the optional working number of columns and rows</li>
<li>the raster <i>type</i> to read: supported are: asc, tiff, grass, adf</li>
<li>the read output raster map</li>
</ul>


<h2>General Information</h2>

<blockquote>Module status: CERTIFIED</blockquote>

<blockquote>Name to use in a script: <b>rasterreader</b></blockquote>

<blockquote>Authors: Andrea Antonello</blockquote>

<blockquote>Contacts: <a href='http://www.hydrologis.com'>http://www.hydrologis.com</a></blockquote>

<blockquote>License: General Public License Version 3 (GPLv3)</blockquote>

<blockquote>Keywords: IO, Coverage, Raster, Reading</blockquote>


<h2>Parameters</h2>

<h3>Input parameters</h3>
<table cellpadding='10' width='70%' border='1'>
<tr>
<td width='50%'> <b>file</b> </td><td width='50%'> The raster file to read with extension (supported are: asc, tiff, grass). </td>
</tr>
<tr>
<td width='50%'> <b>fileNovalue</b> </td><td width='50%'> The file novalue. </td>
</tr>
<tr>
<td width='50%'> <b>geodataNovalue</b> </td><td width='50%'> The novalue wanted in the raster. </td>
</tr>
<tr>
<td width='50%'> <b>pNorth</b> </td><td width='50%'> The optional requested boundary north coordinate. </td>
</tr>
<tr>
<td width='50%'> <b>pSouth</b> </td><td width='50%'> The optional requested boundary south coordinate. </td>
</tr>
<tr>
<td width='50%'> <b>pWest</b> </td><td width='50%'> The optional requested boundary west coordinate. </td>
</tr>
<tr>
<td width='50%'> <b>pEast</b> </td><td width='50%'> The optional requested boundary east coordinate. </td>
</tr>
<tr>
<td width='50%'> <b>pXres</b> </td><td width='50%'> The optional requested resolution in x. </td>
</tr>
<tr>
<td width='50%'> <b>pYres</b> </td><td width='50%'> The optional requested resolution in y. </td>
</tr>
<tr>
<td width='50%'> <b>pRows</b> </td><td width='50%'> The optional requested numer of rows. </td>
</tr>
<tr>
<td width='50%'> <b>pCols</b> </td><td width='50%'> The optional requested numer of cols. </td>
</tr>
<tr>
<td width='50%'> <b>doLegacyGrass</b> </td><td width='50%'> Optional flag to force a legacy GRASS driver usage. </td>
</tr>
</table>

<h3>Output parameters</h3>
<table cellpadding='10' width='70%' border='1'>
<tr>
<td width='50%'> <b>outRaster</b> </td><td width='50%'> The read output raster map. </td>
</tr>
</table>

<h2>Developer example</h2>

An example usage of the algorithm can be found in the testcases suite:<br>
<a href='http://code.google.com/p/jgrasstools/source/browse/jgrassgears/src/test/java/org/jgrasstools/gears/modules/TestRasterReader.java'>RasterReader</a>