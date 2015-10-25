<h2>Description</h2>

Module for vector reprojection.
<ul>
<li>add one or more new columns to the vector table attribute</li>
<li>convert the geometry into a derived geometry (from polygons to points or to lines)</li>
<li>delete  from the vector table attribute</li>
</ul>
<br>
The model can run into two different modes:<br>
<ul>
<li>using only the available parameters for the reprojection</li>
<li>forcing the model to use the most precise parameters for Datum transformation (the so called Bursa Wolf parameters), in this case the choosen CRS has to contain those parameters</li>
<br>
<br>
<h3>Inputs</h3>
<ul>
<li>the vector that has to be reprojected</li>
<li>the code defining the target coordinate reference system, composed by authority and code number (ex. EPSG:4328)</li>
<li>a coordinate reference system on which to force the input, composed by authority and code number (ex. EPSG:4328)</li>
<li>set to true this flag, the reprojection can have some error due to different datums, if set to false, it won't reproject without Bursa Wolf parameters</li>
</ul>
<br>
<br>
<h3>Output</h3>
<ul>
<li>the output reprojected vector</li>
</ul>


<h2>General Information</h2>

<blockquote>Module status: CERTIFIED</blockquote>

<blockquote>Name to use in a script: <b>vreproject</b></blockquote>

<blockquote>Authors: Andrea Antonello</blockquote>

<blockquote>Contacts: <a href='http://www.hydrologis.com'>http://www.hydrologis.com</a></blockquote>

<blockquote>License: General Public License Version 3 (GPLv3)</blockquote>

<blockquote>Keywords: CRS, Reprojection, Vector</blockquote>


<h2>Parameters</h2>

<h3>Input parameters</h3>
<table cellpadding='10' width='70%' border='1'>
<tr>
<td width='50%'> <b>inVector</b> </td><td width='50%'> The vector that has to be reprojected. </td>
</tr>
<tr>
<td width='50%'> <b>pCode</b> </td><td width='50%'> The code defining the target coordinate reference system, composed by authority and code number (ex. EPSG:4328). </td>
</tr>
<tr>
<td width='50%'> <b>doLongitudeFirst</b> </td><td width='50%'> A flag to modify the axes order. </td>
</tr>
<tr>
<td width='50%'> <b>pForceCode</b> </td><td width='50%'> A coordinate reference system on which to force the input, composed by authority and code number (ex. EPSG:4328). </td>
</tr>
<tr>
<td width='50%'> <b>doLenient</b> </td><td width='50%'> Switch that set to true allows for some error due to different datums. If set to false, it won't reproject without Bursa Wolf parameters. </td>
</tr>
</table>

<h3>Output parameters</h3>
<table cellpadding='10' width='70%' border='1'>
<tr>
<td width='50%'> <b>outVector</b> </td><td width='50%'> The output reprojected vector. </td>
</tr>
</table>

<h2>Developer example</h2>

An example usage of the algorithm can be found in the testcases suite:<br>
<a href='http://code.google.com/p/jgrasstools/source/browse/jgrassgears/src/test/java/org/jgrasstools/gears/modules/TestVectorReprojector.java'>VectorReprojector</a>