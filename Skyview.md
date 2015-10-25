<h2>Description</h2>

It estimates the fraction of the sky which is visible from the point, a number between 0 and 1.
<br>
The sky view factor is 1 in a flat area and it decreases in a valley, the more narrow the valley is, the smaller it is.<br>
<br>
The algorithm implemented is derived from <i>Corripio:2003</i>.<br>
<br>
<br>
<h3>Inputs</h3>
<ul>
<li>the file containing the matrix of the elevations, usually the DEM or the output of pitfiller </li>
</ul>
<br>
<br>
<h3>Output</h3>
<ul>
<li>the file containing the sky view factor matrix (as numbers between 0 and 1)</li>
</ul>


<h2>General Information</h2>

<blockquote>Module status: CERTIFIED</blockquote>

<blockquote>Name to use in a script: <b>skyview</b></blockquote>

<blockquote>Authors: Daniele Andreis and Riccardo Rigon</blockquote>

<blockquote>Contacts: <a href='http://www.ing.unitn.it/dica/hp/?user=rigon'>http://www.ing.unitn.it/dica/hp/?user=rigon</a></blockquote>

<blockquote>License: General Public License Version 3 (GPLv3)</blockquote>

<blockquote>Keywords: Hydrology, Radiation, Insolation, Hillshade</blockquote>


<h2>Parameters</h2>

<h3>Input parameters</h3>
<table cellpadding='10' width='70%' border='1'>
<tr>
<td width='50%'> <b>inElev</b> </td><td width='50%'> The map of the elevation. </td>
</tr>
</table>

<h3>Output parameters</h3>
<table cellpadding='10' width='70%' border='1'>
<tr>
<td width='50%'> <b>outSky</b> </td><td width='50%'> The map of skyview factor. </td>
</tr>
</table>

<h2>Example result</h2>

<img src='http://wiki.jgrasstools.googlecode.com/git/images/hortonmachine/skyview.png' alt='Skyview' />
<br>
<h2>Developer example</h2>

An example usage of the algorithm can be found in the testcases suite:<br>
<a href='http://code.google.com/p/jgrasstools/source/browse/hortonmachine/src/test/java/org/jgrasstools/hortonmachine/models/hm/TestSkyview.java'>Skyview</a>