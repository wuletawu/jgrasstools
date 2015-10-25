<h2>Description</h2>

Module to convert dxf files to geotools vecotors (based on Michael Michauds work).
<br>
Since geospatial vector layers can not contain all kind of features as in a dxf file, the output will be a set of vector containing the different geometry types present in the original dxf.<br>
<br>
<br>
<h3>Inputs</h3>
<ul>
<li>the dxf input file</li>
<li>the code defining the coordinate reference system, composed by authority and code number (ex. EPSG:4328), applied in the case the <i>prj</i> file is missing</li>
</ul>
<br>
<br>
<h3>Output</h3>
<ul>
<li>the output point vector</li>
<li>the output line vector</li>
<li>the output polygon vector</li>
</ul>


<h2>General Information</h2>

<blockquote>Module status: CERTIFIED</blockquote>

<blockquote>Name to use in a script: <b>dxfimport</b></blockquote>

<blockquote>Authors: Andrea Antonello</blockquote>

<blockquote>Contacts: <a href='http://www.hydrologis.com'>http://www.hydrologis.com</a></blockquote>

<blockquote>License: General Public License Version 3 (GPLv3)</blockquote>

<blockquote>Keywords: IO, DwgConverter, Feature, Vector, Reading</blockquote>


<h2>Parameters</h2>

<h3>Input parameters</h3>
<table cellpadding='10' width='70%' border='1'>
<tr>
<td width='50%'> <b>file</b> </td><td width='50%'> The dxf file. </td>
</tr>
<tr>
<td width='50%'> <b>pCode</b> </td><td width='50%'> The code defining the coordinate reference system, composed by authority and code number (ex. EPSG:4328). Applied in the case the file is missing. </td>
</tr>
</table>

<h3>Output parameters</h3>
<table cellpadding='10' width='70%' border='1'>
<tr>
<td width='50%'> <b>pointsVector</b> </td><td width='50%'> The output point vector. </td>
</tr>
<tr>
<td width='50%'> <b>lineVector</b> </td><td width='50%'> The output lines vector. </td>
</tr>
<tr>
<td width='50%'> <b>polygonVector</b> </td><td width='50%'> The output polygons vector. </td>
</tr>
</table>

<h2>Developer example</h2>

An example usage of the algorithm can be found in the testcases suite:<br>
<a href='http://code.google.com/p/jgrasstools/source/browse/jgrassgears/src/test/java/org/jgrasstools/gears/modules/TestDxfConverter.java'>DxfConverter</a>