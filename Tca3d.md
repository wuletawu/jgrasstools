<h2>Description</h2>

The contributing areas 3d represent the real draining areas afferent to a point in the basin, not only its projection on the plane as the Tca do.
<br>
<br>
<h3>Inputs</h3>
<ul>
<li>the file containing the matrix of pitless elevations (obtained with pitfiller)</li>
<li>the file containing the matrix of drainage directions (obtained with Markoutlets or DrainDir)</li>
</ul>
<br>
<br>
<h3>Output</h3>
<ul>
<li>the file containing the matrix of the real areas</li>
</ul>
<br>
<br>
<h3>Notes</h3>
The way to calculate the 3D area is to approximate with triangles the DEM surface and then summing the triangles area going downstream from sources to outlet.<br>
<br>
<br>
<h2>General Information</h2>

<blockquote>Module status: CERTIFIED</blockquote>

<blockquote>Name to use in a script: <b>tca3d</b></blockquote>

<blockquote>Authors: Daniele Andreis, Antonello Andrea, Erica Ghesla, Cozzini Andrea, Franceschi Silvia, Pisoni Silvano, Rigon Riccardo</blockquote>

<blockquote>Contacts: <a href='http://www.hydrologis.com'>http://www.hydrologis.com</a>, <a href='http://www.ing.unitn.it/dica/hp/?user=rigon'>http://www.ing.unitn.it/dica/hp/?user=rigon</a></blockquote>

<blockquote>License: General Public License Version 3 (GPLv3)</blockquote>

<blockquote>Keywords: Geomorphology, DrainDir, Tca, Ab, Multitca</blockquote>


<h2>Parameters</h2>

<h3>Input parameters</h3>
<table cellpadding='10' width='70%' border='1'>
<tr>
<td width='50%'> <b>inPit</b> </td><td width='50%'> The depitted elevation model. </td>
</tr>
<tr>
<td width='50%'> <b>inFlow</b> </td><td width='50%'> The map of flowdirections. </td>
</tr>
</table>

<h3>Output parameters</h3>
<table cellpadding='10' width='70%' border='1'>
<tr>
<td width='50%'> <b>outTca</b> </td><td width='50%'> The map of total contributing areas 3d. </td>
</tr>
</table>

<h2>Example result</h2>

<img src='http://wiki.jgrasstools.googlecode.com/git/images/hortonmachine/tca3d.png' alt='Tca3d' />
<br>
<h2>Developer example</h2>

An example usage of the algorithm can be found in the testcases suite:<br>
<a href='http://code.google.com/p/jgrasstools/source/browse/hortonmachine/src/test/java/org/jgrasstools/hortonmachine/models/hm/TestTca3d.java'>Tca3d</a>