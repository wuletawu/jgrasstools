<h2>Description</h2>

Module for doing raster map algebra.
<br>
The mapcalc refers to the <i>Jiffle</i> project. All the documentation about the supported functions and the module syntax is available at: <a href='http://jaitools.org/docs/jiffle/latest/userguide/html/'> Jiffle website</a>.<br>
<br>
<br>
<h3>Inputs</h3>
<ul>
<li>the list of maps that are used in the calculation</li>
<li>the function to process</li>
</ul>
<br>
<br>
<h3>Output</h3>
<ul>
<li>the resulting map picked from the inserted function</li>
</ul>


<h2>General Information</h2>

<blockquote>Module status: CERTIFIED</blockquote>

<blockquote>Name to use in a script: <b>mapcalc</b></blockquote>

<blockquote>Authors: Andrea Antonello</blockquote>

<blockquote>Contacts: <a href='http://www.hydrologis.com'>http://www.hydrologis.com</a></blockquote>

<blockquote>License: General Public License Version 3 (GPLv3)</blockquote>

<blockquote>Keywords: Mapcalc, Raster, CutOut</blockquote>


<h2>Parameters</h2>

<h3>Input parameters</h3>
<table cellpadding='10' width='70%' border='1'>
<tr>
<td width='50%'> <b>inRasters</b> </td><td width='50%'> The maps that are used in the calculation. </td>
</tr>
<tr>
<td width='50%'> <b>pFunction</b> </td><td width='50%'> The function to process. </td>
</tr>
</table>

<h3>Output parameters</h3>
<table cellpadding='10' width='70%' border='1'>
<tr>
<td width='50%'> <b>outRaster</b> </td><td width='50%'> The resulting map picked from the inserted function. </td>
</tr>
</table>

<h2>Developer example</h2>

An example usage of the algorithm can be found in the testcases suite:<br>
<a href='http://code.google.com/p/jgrasstools/source/browse/jgrassgears/src/test/java/org/jgrasstools/gears/modules/TestMapcalc.java'>Mapcalc</a>