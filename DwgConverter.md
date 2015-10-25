<h2>Description</h2>

Module to convert dxf files to geotools vecotors (based on jdwglib project).
<br>
Since geospatial vector layers can not contain all kind of features as in a dwg file, the output will be a set of vector containing the different geometry types present in the original dwg. Other three vector layers will be created from the original dwg to store the text, attribute and contours.<br>
<br>
<br>
<h3>Inputs</h3>
<ul>
<li>the dwg input file</li>
<li>the code defining the coordinate reference system, composed by authority and code number (ex. EPSG:4328), applied in the case the <i>prj</i> file is missing</li>
</ul>
<br>
<br>
<h3>Output</h3>
<ul>
<li>the output point vector</li>
<li>the output line vector</li>
<li>the output polygon vector</li>
<li>the output text vector</li>
<li>the output attributes vector</li>
<li>the output contour vector</li>
</ul>


<h2>General Information</h2>

<blockquote>Module status: UNKNOWN</blockquote>

<blockquote>Name to use in a script: <b>dwgimport</b></blockquote>

<blockquote>Authors: Andrea Antonello</blockquote>

<blockquote>Contacts: <a href='http://www.hydrologis.com'>http://www.hydrologis.com</a></blockquote>

<blockquote>License: General Public License Version 3 (GPLv3)</blockquote>

<blockquote>Keywords: IO, DxfConverter, Feature, Vector, Reading</blockquote>


<h2>Parameters</h2>

<h3>Input parameters</h3>
<table cellpadding='10' width='70%' border='1'>
<tr>
<td width='50%'> <b>file</b> </td><td width='50%'> The dwg input file. </td>
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
<td width='50%'> <b>lineVector</b> </td><td width='50%'> The output line vector. </td>
</tr>
<tr>
<td width='50%'> <b>polygonVector</b> </td><td width='50%'> The output polygon vector. </td>
</tr>
<tr>
<td width='50%'> <b>textVector</b> </td><td width='50%'> The output text vector. </td>
</tr>
<tr>
<td width='50%'> <b>attributesVector</b> </td><td width='50%'> The output attributes vector. </td>
</tr>
<tr>
<td width='50%'> <b>contourVector</b> </td><td width='50%'> The output contour vector. </td>
</tr>
</table>
