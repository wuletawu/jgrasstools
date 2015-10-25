<h2>Description</h2>

Module that extracts raster categories and adds them to a feature collection.
<br>
<br>
<h3>Inputs</h3>
<ul>
<li>the raster on which to map the vector features</li>
<li>the vector to use for the geometric mapping</li>
<li>the name for the new field to create</li>
<li>the position of the coordinate to take in the case of multi geometries</li>
</ul>
<br>
<br>
<h3>Output</h3>
<ul>
<li>the extended vector</li>
</ul>


<h2>General Information</h2>

<blockquote>Module status: CERTIFIED</blockquote>

<blockquote>Name to use in a script: <b>rat2featureattr</b></blockquote>

<blockquote>Authors: Andrea Antonello</blockquote>

<blockquote>Contacts: <a href='http://www.hydrologis.com'>http://www.hydrologis.com</a></blockquote>

<blockquote>License: General Public License Version 3 (GPLv3)</blockquote>

<blockquote>Keywords: Raster, Vector</blockquote>


<h2>Parameters</h2>

<h3>Input parameters</h3>
<table cellpadding='10' width='70%' border='1'>
<tr>
<td width='50%'> <b>inRaster</b> </td><td width='50%'> The raster on which to map the vector features. </td>
</tr>
<tr>
<td width='50%'> <b>inVector</b> </td><td width='50%'> The vector to use for the geometric mapping. </td>
</tr>
<tr>
<td width='50%'> <b>fNew</b> </td><td width='50%'> The name for the new field to create. </td>
</tr>
<tr>
<td width='50%'> <b>pPos</b> </td><td width='50%'> The position of the coordinate to take in the case of multi geometries. </td>
</tr>
</table>

<h3>Output parameters</h3>
<table cellpadding='10' width='70%' border='1'>
<tr>
<td width='50%'> <b>outVector</b> </td><td width='50%'> The extended vector. </td>
</tr>
</table>

<h2>Developer example</h2>

An example usage of the algorithm can be found in the testcases suite:<br>
<a href='http://code.google.com/p/jgrasstools/source/browse/jgrassgears/src/test/java/org/jgrasstools/gears/modules/TestRasterCatToFeatureAttribute.java'>RasterCatToFeatureAttribute</a>