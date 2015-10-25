<h2>Description</h2>

Estimates the longitudinal (or profile), normal and planar curvatures for each site through a finite difference schema.
<br>
The curvatures represent the deviations of the gradient vector for unit length (in radiants) along particular curves plotted on the surface under consideration. In particular, the presence of non-zero curvatures has relevant effects on the representation of the properties of the surfaces discretized. For example, if the surface has a negative normal curvature, then the gradients have diverging directions at the extremes of the pixel, <i>P</i>, and the contributing area in <i>P</i> is spread over several adjacent pixels: in this case topography is called locally divergent. Vice versa, the surface is locally converging (negative curvature) and the contributing area in <i>P</i> tends to be spread over a limited set of adjacent pixels and almost certainly on a single pixel.<br>
<br>
Roughly speaking, the convex zones are hillslope zones, the concave zones are valleys. As it is known, the latter contain the channel network. Then, the curvature tends to discriminate the points across the basin with greater humidity content (the concave ones). This fact has relevant consequences on the overall hydrologic behavior of basins and, in particular, on the production of runoff and on the evapotranspiration distribution.<br>
<br>
The <i>longitudinal curvature</i> represent the deviation of the gradient along<br>
the the flow (it is negative if the gradient increase), the <i>normal</i>
and <i>planar curvatures</i> are locally proportional and measure the<br>
convergence/divergence of the flow (the curvature is positive for<br>
convergent flow).<br>
<br>
<br>
<h3>Inputs</h3>
<ul>
<li>the file containing the matrix of elevations (the DEM or the map obtained with pitfiller)</li>
</ul>
<br>
<br>
<h3>Output</h3>
<ul>
<li>the file containing the matrix of longitudinal curvatures</li>
<li>the file containing the matrix of normal (or tangent)<br>
curvatures</li>
<li>the file containing the matrix of planar curvatures</li>
</ul>
<br>
<br>
<h3>Notes</h3>
The planar and normal (or tangent) curvatures are proportional to each other.<br>
<br>
As a rule the model places the curve equal to zero on the catchment boundary.<br>
<br>
<br>
<h2>General Information</h2>

<blockquote>Module status: CERTIFIED</blockquote>

<blockquote>Name to use in a script: <b>curvatures</b></blockquote>

<blockquote>Authors: Daniele Andreis, Antonello Andrea, Erica Ghesla, Cozzini Andrea, Franceschi Silvia, Pisoni Silvano, Rigon Riccardo</blockquote>

<blockquote>Contacts: <a href='http://www.hydrologis.com'>http://www.hydrologis.com</a>, <a href='http://www.ing.unitn.it/dica/hp/?user=rigon'>http://www.ing.unitn.it/dica/hp/?user=rigon</a></blockquote>

<blockquote>License: General Public License Version 3 (GPLv3)</blockquote>

<blockquote>Keywords: Geomorphology</blockquote>


<h2>Parameters</h2>

<h3>Input parameters</h3>
<table cellpadding='10' width='70%' border='1'>
<tr>
<td width='50%'> <b>inElev</b> </td><td width='50%'> The map of the digital elevation model (DEM or pit). </td>
</tr>
</table>

<h3>Output parameters</h3>
<table cellpadding='10' width='70%' border='1'>
<tr>
<td width='50%'> <b>outProf</b> </td><td width='50%'> The map of profile curvatures. </td>
</tr>
<tr>
<td width='50%'> <b>outPlan</b> </td><td width='50%'> The map of planar curvatures. </td>
</tr>
<tr>
<td width='50%'> <b>outTang</b> </td><td width='50%'> The map of tangential curvatures. </td>
</tr>
</table>

<h2>Example result</h2>

<img src='http://wiki.jgrasstools.googlecode.com/git/images/hortonmachine/curvatures.png' alt='Curvatures' />
<br>
<h2>Developer example</h2>

An example usage of the algorithm can be found in the testcases suite:<br>
<a href='http://code.google.com/p/jgrasstools/source/browse/hortonmachine/src/test/java/org/jgrasstools/hortonmachine/models/hm/TestCurvatures.java'>Curvatures</a>