<h2>Description</h2>

It calculates the draining area per length unit (A/b), where <b>A</b> is the total upstream area and <b>b</b> is the length of the contour line which is assumed as drained by the A area. The contour length is here be estimated by a a novel method based on curvatures.
<br>
<br>
<h3>Inputs</h3>
<ul>
<li>the file containing the matrix of planar curvatures (obtained with Curvatures)</li>
<li>the matrix with the total contributing areas (obtained with draindir or tca)</li>
</ul>
<br>
<br>
<h3>Output</h3>
<ul>
<li>the file containing the matrix of the areas per length unit, A/b</li>
<li>the file containing the matrix of the contour line, b</li>
</ul>
<br>
<br>
<h3>Note</h3>
<br>
The drainage length, b is here evaluated in each point of the basin according to the value of the planar curvature. The contour line is locally approximated by an arc having the radius inversely proportional to the local planar curvature. It is in fact the curvature radius r is:<br>
<table>
<tr>
<td>
<blockquote>r = 1/k<sub>p</sub>
</td>
</tr>
</table>
where k<sub>p</sub> is the planar curvature. Then, assuming that the contour line can be approximated by a circle radius, it is also<br>
<table>
<tr>
<td>
t=alpha*r<br>
</td>
<td>
t'=alpha(r-L)<br>
</td>
</tr>
</table>
where t is the drained contour at the beginning (uphill) of the pixel and  t' is the drained contour at the end of the pixel (downhill), <i>alpha</i> is the angle enclosed between the two contours as an L is the pixel size.</blockquote>

L, in turn can be related to <i>alpha</i> as:<br>
<table>
<tr>
<td>
<blockquote>L = 2r sin(alpha/2)<br>
</td>
</tr>
</table>
and then:<br>
<table>
<tr>
<td>
alpha = 2 arcsin(L/2r)<br>
</td>
</tr>
</table></blockquote>

And substituting, one obtains:<br>
<table>
<tr>
<td>
<blockquote>t = 2 arcsin(L/2r) r<br>
</td>
<td>
t' = 2 arcsin(L/2r)(r-L)<br>
</td>
</tr>
</table></blockquote>

Finally, for every pixel, it is assumed:<br>
<table>
<tr>
<td>
<blockquote>b = t'<br>
</td>
</tr>
</table>
where b is the drained contour.</blockquote>

To very convergent sites, there correspond a proportionally shrinking contour line, and to divergent site an enlarging drainage line.<br>
<br>
<br>
<br>
<h2>General Information</h2>

<blockquote>Module status: CERTIFIED</blockquote>

<blockquote>Name to use in a script: <b>ab</b></blockquote>

<blockquote>Authors: Andrea Antonello, Erica Ghesla, Rigon Riccardo, Andrea Cozzini, Silvano Pisoni</blockquote>

<blockquote>Contacts: <a href='http://www.hydrologis.com'>http://www.hydrologis.com</a>, <a href='http://www.ing.unitn.it/dica/hp/?user=rigon'>http://www.ing.unitn.it/dica/hp/?user=rigon</a></blockquote>

<blockquote>License: General Public License Version 3 (GPLv3)</blockquote>

<blockquote>Keywords: Geomorphology, Tca, Curvatures, DrainDir, FlowDirections</blockquote>


<h2>Parameters</h2>

<h3>Input parameters</h3>
<table cellpadding='10' width='70%' border='1'>
<tr>
<td width='50%'> <b>inTca</b> </td><td width='50%'> The map of the total contributing area. </td>
</tr>
<tr>
<td width='50%'> <b>inPlan</b> </td><td width='50%'> The map of the planar curvatures. </td>
</tr>
</table>

<h3>Output parameters</h3>
<table cellpadding='10' width='70%' border='1'>
<tr>
<td width='50%'> <b>outAb</b> </td><td width='50%'> The map of area per length. </td>
</tr>
<tr>
<td width='50%'> <b>outB</b> </td><td width='50%'> The map of contour line. </td>
</tr>
</table>

<h2>Example result</h2>

<img src='http://wiki.jgrasstools.googlecode.com/git/images/hortonmachine/ab.png' alt='Ab' />
<br>
<h2>Developer example</h2>

An example usage of the algorithm can be found in the testcases suite:<br>
<a href='http://code.google.com/p/jgrasstools/source/browse/hortonmachine/src/test/java/org/jgrasstools/hortonmachine/models/hm/TestAb.java'>Ab</a>