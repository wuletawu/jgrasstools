<h2>Description</h2>

Module that extracts contour lines from a raster. Algorithm comes from <a href='http://code.google.com/p/jai-tools/'> jai-tools</a>, which used <a href='http://local.wasp.uwa.edu.au/~pbourke/papers/conrec/'> the Conrec</a> contouring subroutine.
<br>
<br>
<h3>Inputs</h3>
<ul>
<li>the raster on which to calculate the contours</li>
<li>the minimum value for the contours</li>
<li>the maximum value for the contours</li>
<li>the contours interval</li>
</ul>
<br>
<br>
<h3>Output</h3>
<ul>
<li>the generated contour lines vector</li>
</ul>
<h3>Notes</h3>
The module has a couple of known issues:<br>
<ul>
<li>it missbehaves if there are cell values that happen to be equal to the contour values (see above referenced article for further explanation).</li>
<li>isolines can accumulate at image borders</li>
</ul>


<h2>General Information</h2>

<blockquote>Module status: UNKNOWN</blockquote>

<blockquote>Name to use in a script: <b>contourextract</b></blockquote>

<blockquote>Authors: Andrea Antonello</blockquote>

<blockquote>Contacts: <a href='http://www.hydrologis.com'>http://www.hydrologis.com</a></blockquote>

<blockquote>License: General Public License Version 3 (GPLv3)</blockquote>

<blockquote>Keywords: Raster, Vector</blockquote>


<h2>Parameters</h2>

<h3>Input parameters</h3>
<table cellpadding='10' width='70%' border='1'>
<tr>
<td width='50%'> <b>inCoverage</b> </td><td width='50%'> The raster on which to calculate the contours. </td>
</tr>
<tr>
<td width='50%'> <b>pMin</b> </td><td width='50%'> The minimum value for the contours. </td>
</tr>
<tr>
<td width='50%'> <b>pMax</b> </td><td width='50%'> The maximum value for the contours. </td>
</tr>
<tr>
<td width='50%'> <b>pInterval</b> </td><td width='50%'> The contours interval. </td>
</tr>
</table>

<h3>Output parameters</h3>
<table cellpadding='10' width='70%' border='1'>
<tr>
<td width='50%'> <b>outGeodata</b> </td><td width='50%'> The generated contour lines vector. </td>
</tr>
</table>
