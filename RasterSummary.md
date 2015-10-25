<h2>Description</h2>

Calculate a summary of the map with base statistics informations:
<ul>
<li>min value</li>
<li>max value</li>
<li>mean value</li>
<li>standard deviation</li>
<li>map name</li>
<li>map sum</li>
<li>map histogram: the calculated values are:<br>
<ul>
<li>the reference value of the bin (middlepoint)</li>
<li>the number of pixels in the bin</li>
<li>the percentage of the pixels in the bin over the total</li>
</ul>
</li>
<li>the number and percentage of nodata values <i>NaN</i> in the raster region</li>
</ul>
<br>
<br>
<h3>Inputs</h3>
<ul>
<li>the file containing the map that has to be processed</li>
</ul>
<br>
<br>
<h3>Output</h3>
<ul>
<li>a summary of base statistics for the current map on standard output</li>
</ul>


<h2>General Information</h2>

<blockquote>Module status: CERTIFIED</blockquote>

<blockquote>Name to use in a script: <b>rsummary</b></blockquote>

<blockquote>Authors: Andrea Antonello</blockquote>

<blockquote>Contacts: <a href='http://www.hydrologis.com'>http://www.hydrologis.com</a></blockquote>

<blockquote>License: General Public License Version 3 (GPLv3)</blockquote>

<blockquote>Keywords: Statistics, Raster, Mapcalc</blockquote>


<h2>Parameters</h2>

<h3>Input parameters</h3>
<table cellpadding='10' width='70%' border='1'>
<tr>
<td width='50%'> <b>inRaster</b> </td><td width='50%'> The map to analize. </td>
</tr>
<tr>
<td width='50%'> <b>pBins</b> </td><td width='50%'> The number of bins for the histogram (default = 100). </td>
</tr>
<tr>
<td width='50%'> <b>doHistogram</b> </td><td width='50%'> Flag that defines if the histogram should be done also (default = false). </td>
</tr>
</table>

<h3>Output parameters</h3>
<table cellpadding='10' width='70%' border='1'>
<tr>
<td width='50%'> <b>outMin</b> </td><td width='50%'> The min value. </td>
</tr>
<tr>
<td width='50%'> <b>outMax</b> </td><td width='50%'> The max value. </td>
</tr>
<tr>
<td width='50%'> <b>outMean</b> </td><td width='50%'> The mean value. </td>
</tr>
<tr>
<td width='50%'> <b>outSdev</b> </td><td width='50%'> The standard deviation value. </td>
</tr>
<tr>
<td width='50%'> <b>outRange</b> </td><td width='50%'> The range value. </td>
</tr>
<tr>
<td width='50%'> <b>outSum</b> </td><td width='50%'> The sum value. </td>
</tr>
<tr>
<td width='50%'> <b>outCb</b> </td><td width='50%'> The histogram. </td>
</tr>
</table>

<h2>Developer example</h2>

An example usage of the algorithm can be found in the testcases suite:<br>
<a href='http://code.google.com/p/jgrasstools/source/browse/jgrassgears/src/test/java/org/jgrasstools/gears/modules/TestRasterSummary.java'>RasterSummary</a>