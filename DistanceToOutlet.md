<h2>Description</h2>

<p>Calculates the distance of each pixel from the outlet, measured along the drainage directions. By aggregating the matrix so obtained, we<br>
get the so called <i>width function</i>. It can evaluate the distance  as a projection of the plan or the real distance (3d mode).<br>
</p>


&lt;BR&gt;


The program can work in three different ways:
<ol>
<li> calculate the distance (projected on the plane)  from the outlet in pixel number (pMode = 0)</li>
<li> calculate the distance (projected on the plane)  from the outlet in meters on the plane (pMode = 1)</li>
<li> calculate the distance (in 3d) from the outlet in meters in 3d (pMode = 1 and the inPit map not null)</li>
</ol>
<br>
<br>
<h3>Inputs</h3>
<ul>
<li> The GridCoverage containing the matrix of the drainage directions (obtained with <a href='Markoutlets.md'>Markoutlets</a>);</li>
<li> The GridCoverage of elevations (obtained with [Pitﬁller]) if it run in 3d mode;</li>
</ul>
<br>
<br>
<h3>Output</h3>
<ul>
<li> The GridCoverage containing the matrix of the distances.</li>
</ul>
<br>
<br<br>
<h3>References</h3>
<ul>
<li><a href='Bibliography#15,.md'>15</a> P. D’Odorico, 2003</li>
<li><a href='Bibliography#16,.md'>16</a> M. Kirkby, 1986</li>
</ul>


<h2>General Information</h2>

<blockquote>Module status: CERTIFIED</blockquote>

<blockquote>Name to use in a script: <b>d2o</b></blockquote>

<blockquote>Authors: Andreis Daniele, Erica Ghesla, Antonello Andrea, Cozzini Andrea, PisoniSilvano, Rigon Riccardo</blockquote>

<blockquote>Contacts:</blockquote>

<blockquote>License: General Public License Version 3 (GPLv3)</blockquote>

<blockquote>Keywords: Geomorphology, DrainDir</blockquote>


<h2>Parameters</h2>

<h3>Input parameters</h3>
<table cellpadding='10' width='70%' border='1'>
<tr>
<td width='50%'> <b>inPit</b> </td><td width='50%'> The map of depitted elevation, if it's null the models work in 2d mode. </td>
</tr>
<tr>
<td width='50%'> <b>inFlow</b> </td><td width='50%'> The map of flowdirections. </td>
</tr>
<tr>
<td width='50%'> <b>pMode</b> </td><td width='50%'> Processing mode, 0= simple mode in meter, 1 = topological distance. </td>
</tr>
</table>

<h3>Output parameters</h3>
<table cellpadding='10' width='70%' border='1'>
<tr>
<td width='50%'> <b>outDistance</b> </td><td width='50%'> The map of the distance to the outlet. </td>
</tr>
</table>

<h2>Example result</h2>

<img src='http://wiki.jgrasstools.googlecode.com/git/images/hortonmachine/distancetooutlet.png' alt='DistanceToOutlet' />
<br>
<h2>Developer example</h2>

An example usage of the algorithm can be found in the testcases suite:<br>
<a href='http://code.google.com/p/jgrasstools/source/browse/hortonmachine/src/test/java/org/jgrasstools/hortonmachine/models/hm/TestDistanceToOutlet.java'>DistanceToOutlet</a>