<h2>Description</h2>

<p>Calculates for each hillslope pixel its distance from the river networks, following the steepest<br>
descent (i.e. the drainage directions). It can evaluate the distance a projection of the plan or the real distance (3d mode).<br>
</p>
<br>
<br>
<h3>Inputs</h3>
<ol>
<li>The GridCoverage containing the drainage directions, obtained with <a href='Markoutlets.md'>Markoutlets</a>;</li>
<li>The GridCoverage containing the network, obtained with <a href='ExtractNetwork.md'>ExtractNetwork</a>;</li>
<li>The GridCoverage containing the elevation, obteined with [Pitﬁller];</li>
</ol>
<br>
<br>
<h3>Output</h3>
<ol>
<li>The GridCoverage containing the distance of every point from the river network;</li>
</ol>
<br>
<br>
<h3>Notes</h3>
The program can work in three different ways:<br>
<ol>
<li> calculate the distance (projected on the plane)  from the outlet in pixel number (pMode = 0)</li>
<li> calculate the distance (projected on the plane)  from the outlet in meters on the plane (pMode = 1 and inPit null)</li>
<li> calculate the distance (in 3d) from the outlet in meters in 3d (pMode = 1 and the inPit map not null)</li>
</ol>
<br>
<br>
<h3>References</h3>
<ul>
<li><a href='Bibliography#15,.md'>15</a>, P. D’Odorico, 2003</li>
</ul>


<h2>General Information</h2>

<blockquote>Module status: CERTIFIED</blockquote>

<blockquote>Name to use in a script: <b>h2cd</b></blockquote>

<blockquote>Authors: Erica Ghesla, Antonello Andrea, Cozzini Andrea, Franceschi Silvia, Pisoni Silvano, Rigon Riccardo</blockquote>

<blockquote>Contacts: <a href='http://www.hydrologis.com'>http://www.hydrologis.com</a>, <a href='http://www.ing.unitn.it/dica/hp/?user=rigon'>http://www.ing.unitn.it/dica/hp/?user=rigon</a></blockquote>

<blockquote>License: General Public License Version 3 (GPLv3)</blockquote>

<blockquote>Keywords: Hillslope, Outlet, Distance</blockquote>


<h2>Parameters</h2>

<h3>Input parameters</h3>
<table cellpadding='10' width='70%' border='1'>
<tr>
<td width='50%'> <b>inFlow</b> </td><td width='50%'> The map of flowdirections </td>
</tr>
<tr>
<td width='50%'> <b>inNet</b> </td><td width='50%'> The map of the network. </td>
</tr>
<tr>
<td width='50%'> <b>inElev</b> </td><td width='50%'> The optional map of the elevation used for 3d mode in pMode = 1. </td>
</tr>
<tr>
<td width='50%'> <b>pMode</b> </td><td width='50%'> The processing mode (0 = in number of pixels (default), 1 = in meters). </td>
</tr>
</table>

<h3>Output parameters</h3>
<table cellpadding='10' width='70%' border='1'>
<tr>
<td width='50%'> <b>outH2cd</b> </td><td width='50%'> The map of hillslope to channels distance. </td>
</tr>
</table>

<h2>Example result</h2>

<img src='http://wiki.jgrasstools.googlecode.com/git/images/hortonmachine/h2cd.png' alt='H2cd' />
<br>
<h2>Developer example</h2>

An example usage of the algorithm can be found in the testcases suite:<br>
<a href='http://code.google.com/p/jgrasstools/source/browse/hortonmachine/src/test/java/org/jgrasstools/hortonmachine/models/hm/TestH2cd.java'>H2cd</a>