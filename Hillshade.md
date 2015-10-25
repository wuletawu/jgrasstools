<h2>Description</h2>

Evaluates the hillshade, considering the sunlight and the shaded relief.
<br>
<br>
<h3>Inputs</h3>
<ul>
<li>the file containing the matrix of the elevations, usually the DEM or the output of pitfiller </li>
<li>the minimum diffuse insolation (which default value is set to 0)</li>
<li>the azimuth (which default value is setted to 360)</li>
<li>the elevation of the sun (which default value is set to 90)</li>
</ul>
<br>
<br>
<h3>Output</h3>
<ul>
<li>the matrix containing the hillshade values</li>
</ul>


<h2>General Information</h2>

<blockquote>Module status: CERTIFIED</blockquote>

<blockquote>Name to use in a script: <b>hillshade</b></blockquote>

<blockquote>Authors: Daniele Andreis and Riccardo Rigon</blockquote>

<blockquote>Contacts: <a href='http://www.ing.unitn.it/dica/hp/?user=rigon'>http://www.ing.unitn.it/dica/hp/?user=rigon</a></blockquote>

<blockquote>License: General Public License Version 3 (GPLv3)</blockquote>

<blockquote>Keywords: Hydrology, Radiation, SkyviewFactor, Insolation</blockquote>


<h2>Parameters</h2>

<h3>Input parameters</h3>
<table cellpadding='10' width='70%' border='1'>
<tr>
<td width='50%'> <b>inElev</b> </td><td width='50%'> The map of the elevation. </td>
</tr>
<tr>
<td width='50%'> <b>pMinDiffuse</b> </td><td width='50%'> The minimum value of diffuse insolation between 0 to 1 (default is 0). </td>
</tr>
<tr>
<td width='50%'> <b>pAzimuth</b> </td><td width='50%'> The value of the azimuth (default is 360). </td>
</tr>
<tr>
<td width='50%'> <b>pElev</b> </td><td width='50%'> The sun elevation (default is 90). </td>
</tr>
</table>

<h3>Output parameters</h3>
<table cellpadding='10' width='70%' border='1'>
<tr>
<td width='50%'> <b>outHill</b> </td><td width='50%'> The map of hillshade. </td>
</tr>
</table>

<h2>Example result</h2>

<img src='http://wiki.jgrasstools.googlecode.com/git/images/hortonmachine/hillshade.png' alt='Hillshade' />
<br>
<h2>Developer example</h2>

An example usage of the algorithm can be found in the testcases suite:<br>
<a href='http://code.google.com/p/jgrasstools/source/browse/hortonmachine/src/test/java/org/jgrasstools/hortonmachine/models/hm/TestHillshade.java'>Hillshade</a>