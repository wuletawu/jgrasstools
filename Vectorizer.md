<h2>Description</h2>

Module for raster to vector conversion.
<br>
<br>
<h3>Inputs</h3>
<ul>
<li>the raster that has to be converted</li>
<li>the value to use to trace the polygons, if it is null then all the values of the raster are used</li>
<li>the field name to use as to store the raster value in the vector</li>
<li>a threshold on cell number to filter away polygons with cells less than that</li>
</ul>
<br>
<br>
<h3>Output</h3>
<ul>
<li>the extracted vector</li>
</ul>


<h2>General Information</h2>

<blockquote>Module status: CERTIFIED</blockquote>

<blockquote>Name to use in a script: <b>vectorizer</b></blockquote>

<blockquote>Authors: Andrea Antonello</blockquote>

<blockquote>Contacts: <a href='http://www.hydrologis.com'>http://www.hydrologis.com</a></blockquote>

<blockquote>License: General Public License Version 3 (GPLv3)</blockquote>

<blockquote>Keywords: Raster, Vector, ScanLineRasterizer</blockquote>


<h2>Parameters</h2>

<h3>Input parameters</h3>
<table cellpadding='10' width='70%' border='1'>
<tr>
<td width='50%'> <b>inRaster</b> </td><td width='50%'> The raster that has to be converted. </td>
</tr>
<tr>
<td width='50%'> <b>pValue</b> </td><td width='50%'> The value to use to trace the polygons. If it is null then all the value of the raster are used. </td>
</tr>
<tr>
<td width='50%'> <b>fDefault</b> </td><td width='50%'> The field name to use as a name for the raster value in the vector. </td>
</tr>
<tr>
<td width='50%'> <b>pThres</b> </td><td width='50%'> A threshold on cell number to filter away polygons with cells less than that. </td>
</tr>
<tr>
<td width='50%'> <b>doRegioncheck</b> </td><td width='50%'> Make a check on the raster first and shrink the boundaries on the region with data. </td>
</tr>
</table>

<h3>Output parameters</h3>
<table cellpadding='10' width='70%' border='1'>
<tr>
<td width='50%'> <b>outVector</b> </td><td width='50%'> The extracted vector. </td>
</tr>
</table>

<h2>Developer example</h2>

An example usage of the algorithm can be found in the testcases suite:<br>
<a href='http://code.google.com/p/jgrasstools/source/browse/jgrassgears/src/test/java/org/jgrasstools/gears/modules/TestVectorizer.java'>Vectorizer</a>