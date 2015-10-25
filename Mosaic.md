<h2>Description</h2>

Patches a set on input rasters into one single raster.
<br>
<br>
<h3>Inputs</h3>
<ul>
<li>the list of maps that have to be patched</li>
<li>the interpolation type to use</li>
</ul>
<br>
<br>
<h3>Output</h3>
<ul>
<li>the file containing the map the patched map</li>
</ul>
<br>
<br>
<h3>Notes</h3>
The supported interpolation types are:<br>
<ul>
<li>0: nearest neightbour(default)</li>
<li>1: bilinear</li>
<li>2: bicubic</li>
</ul>


<h2>General Information</h2>

<blockquote>Module status: CERTIFIED</blockquote>

<blockquote>Name to use in a script: <b>mosaic</b></blockquote>

<blockquote>Authors: Andrea Antonello</blockquote>

<blockquote>Contacts: <a href='http://www.hydrologis.com'>http://www.hydrologis.com</a></blockquote>

<blockquote>License: General Public License Version 3 (GPLv3)</blockquote>

<blockquote>Keywords: Mosaic, Raster</blockquote>


<h2>Parameters</h2>

<h3>Input parameters</h3>
<table cellpadding='10' width='70%' border='1'>
<tr>
<td width='50%'> <b>inFiles</b> </td><td width='50%'> The list of maps that have to be patched. </td>
</tr>
<tr>
<td width='50%'> <b>pInterpolation</b> </td><td width='50%'> The interpolation type to use: nearest neightbour (0-default), bilinear (1), bicubic (2) </td>
</tr>
</table>

<h3>Output parameters</h3>
<table cellpadding='10' width='70%' border='1'>
<tr>
<td width='50%'> <b>outRaster</b> </td><td width='50%'> The patched map. </td>
</tr>
</table>

<h2>Developer example</h2>

An example usage of the algorithm can be found in the testcases suite:<br>
<a href='http://code.google.com/p/jgrasstools/source/browse/jgrassgears/src/test/java/org/jgrasstools/gears/modules/TestMosaic.java'>Mosaic</a>