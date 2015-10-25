<h2>Description</h2>

Experimental semivariogram

<h2>General Information</h2>

> Module status: CERTIFIED

> Name to use in a script: <b>variogram</b>

> Authors: Giuseppe Formetta, Francesco Adami, Silvia Franceschi

> Contacts:

> License: General Public License Version 3 (GPLv3)

> Keywords: Experimental semivariogram, Kriging, Hydrology


<h2>Parameters</h2>

<h3>Input parameters</h3>
<table cellpadding='10' width='70%' border='1'>
<tr>
<td width='50%'> <b>inStations</b> </td><td width='50%'> The vector of the measurement point, containing the position of the stations. </td>
</tr>
<tr>
<td width='50%'> <b>fStationsid</b> </td><td width='50%'> The field of the vector of stations, defining the id. </td>
</tr>
<tr>
<td width='50%'> <b>fStationsZ</b> </td><td width='50%'> The field of the vector of stations, defining the elevation. </td>
</tr>
<tr>
<td width='50%'> <b>inData</b> </td><td width='50%'> The file with the measured data, to be interpolated. </td>
</tr>
<tr>
<td width='50%'> <b>pPath</b> </td><td width='50%'> The path to the printed file. </td>
</tr>
<tr>
<td width='50%'> <b>pCutoff</b> </td><td width='50%'> Spatial separation distance up to which point pairs are included in semivariance estimates; as a default, the length of the diagonal of the box spanning the data is divided by three. </td>
</tr>
</table>

<h3>Output parameters</h3>
<table cellpadding='10' width='70%' border='1'>
<tr>
<td width='50%'> <b>outResult</b> </td><td width='50%'> The Experimental Variogram. </td>
</tr>
</table>

<h2>Example result</h2>

<img src='http://wiki.jgrasstools.googlecode.com/git/images/hortonmachine/variogram.png' alt='Variogram' />
<br>
<h2>Developer example</h2>

An example usage of the algorithm can be found in the testcases suite:<br>
<a href='http://code.google.com/p/jgrasstools/source/browse/hortonmachine/src/test/java/org/jgrasstools/hortonmachine/models/hm/TestVariogram.java'>Variogram</a>