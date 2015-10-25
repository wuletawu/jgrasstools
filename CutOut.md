<h2>Description</h2>

Extracts raster thresholding and masking:
<ul>
<li>extract map sub areas with values between the given lower and upper threshold</li>
<li>extract the map in the area defined of the mask map </li>
</ul>
<br>
<br>
<h3>Inputs</h3>
<ul>
<li>the file containing the map that has to be processed</li>
<li>the file containing the map to use as mask</li>
</ul>
<br>
<br>
<h3>Output</h3>
<ul>
<li>the file containing the result of thresholding or masking</li>
</ul>
<br>
<br>
<h3>Notes</h3>
The program can be used also to extract only the area outside the mask map using the inverse mode.<br>
<br>
<br>
<h2>General Information</h2>

<blockquote>Module status: CERTIFIED</blockquote>

<blockquote>Name to use in a script: <b>cutout</b></blockquote>

<blockquote>Authors: Silvia Franceschi, Andrea Antonello</blockquote>

<blockquote>Contacts: <a href='http://www.hydrologis.com'>http://www.hydrologis.com</a></blockquote>

<blockquote>License: General Public License Version 3 (GPLv3)</blockquote>

<blockquote>Keywords: Raster, Threshold, Mapcalc</blockquote>


<h2>Parameters</h2>

<h3>Input parameters</h3>
<table cellpadding='10' width='70%' border='1'>
<tr>
<td width='50%'> <b>inRaster</b> </td><td width='50%'> The map that has to be processed. </td>
</tr>
<tr>
<td width='50%'> <b>inMask</b> </td><td width='50%'> The map to use as mask. </td>
</tr>
<tr>
<td width='50%'> <b>pMax</b> </td><td width='50%'> The upper threshold value. </td>
</tr>
<tr>
<td width='50%'> <b>pMin</b> </td><td width='50%'> The lower threshold value. </td>
</tr>
<tr>
<td width='50%'> <b>doInverse</b> </td><td width='50%'> Switch for doing extraction of the mask area or the inverse (negative). Default is false and extract the mask area. </td>
</tr>
</table>

<h3>Output parameters</h3>
<table cellpadding='10' width='70%' border='1'>
<tr>
<td width='50%'> <b>outRaster</b> </td><td width='50%'> The processed map. </td>
</tr>
</table>

<h2>Developer example</h2>

An example usage of the algorithm can be found in the testcases suite:<br>
<a href='http://code.google.com/p/jgrasstools/source/browse/jgrassgears/src/test/java/org/jgrasstools/gears/modules/TestCutOut.java'>CutOut</a>