<h2>Description</h2>

This is a version of the Shalstab stability model for the evaluation of the proneness to instability of each pixel based on an infinite slope model with steady hydrological conditions.
<br>
The output is composed of two maps: the map of the potentially unstable pixels and the map of the minimum steady state rainfall to cause instability.<br>
<br>
The parameters used for the evaluation of the stability conditions are:<br>
<ul>
<li>the contributing area draining across</li>
<li>the contour length of the lower bound</li>
<li>the soil transmissivity when saturated</li>
<li>the local slope</li>
<li>the ratio between soil bulk density and water density</li>
<li>the net rainfall rate</li>
<li>the gravitational acceleration</li>
<li>the soil thickness</li>
<li>the effective soil cohesion</li>
</ul>
For some of these parameters it is possible to insert as input either a map with the spatial distribution or a single constant value that will be used over all the basin (trasmissivity, tgphi, cohesion, hs, q, rho). There is the possibility to run a simulation where some parameters are maps and others are constant values.<br>
<br>
The output is a map of values with the following meaning:<br>
<ul>
<li>1 : unconditionally unstable</li>
<li>2 : unconditionally stable</li>
<li>3 : stable</li>
<li>4 : unstable</li>
<li>8888 : pixel characterized by rock (if soil thickness < 0.01)</li>
</ul>

It will be evaluated also the minimum rainfall to instability, and the output is a map of values with the following meaning:<br>
<ul>
<li>0 : unconditionally stable</li>
<li>1 : 0 <= qcrit < 50</li>
<li>2 : 50 <= qcrit < 100</li>
<li>3 : 100 <= qcrit < 200</li>
<li>4 : qcrit >= 200</li>
<li>5 : unconditionally unstable</li>
</ul>
<br>
<br>
<h3>Inputs</h3>
<ul>
<li>the map of slope</li>
<li>the map of a/b</li>
<li>a constant value or the map of trasmissivity</li>
<li>a constant value or the map of the tangent of the friction angle</li>
<li>a constant value or the map of cohesion</li>
<li>a constant value or the map of soil thickness</li>
<li>a constant value or the map of effective precipitations (net rainfall)</li>
<li>a constant value or the map of the ratio between soil bulk density and water density</li>
</ul>
<br>
<br>
<h3>Output</h3>
<ul>
<li>the map of the minimum rainfall to instability</li>
<li>the map of stability classes</li>
</ul>


<h2>General Information</h2>

<blockquote>Module status: CERTIFIED</blockquote>

<blockquote>Name to use in a script: <b>shalstab</b></blockquote>

<blockquote>Authors: Daniele Andreis, Antonello Andrea, Erica Ghesla, Cozzini Andrea, Franceschi Silvia, Pisoni Silvano, Rigon Riccardo</blockquote>

<blockquote>Contacts: <a href='http://www.hydrologis.com'>http://www.hydrologis.com</a>, <a href='http://www.ing.unitn.it/dica/hp/?user=rigon'>http://www.ing.unitn.it/dica/hp/?user=rigon</a></blockquote>

<blockquote>License: General Public License Version 3 (GPLv3)</blockquote>

<blockquote>Keywords: Shalstab, Hydrology, Trasmissivity</blockquote>


<h2>Parameters</h2>

<h3>Input parameters</h3>
<table cellpadding='10' width='70%' border='1'>
<tr>
<td width='50%'> <b>inSlope</b> </td><td width='50%'> The map of slope. </td>
</tr>
<tr>
<td width='50%'> <b>inTca</b> </td><td width='50%'> The map of contributing area. </td>
</tr>
<tr>
<td width='50%'> <b>inTrasmissivity</b> </td><td width='50%'> The map of trasmissivity. [m^2/day] </td>
</tr>
<tr>
<td width='50%'> <b>pTrasmissivity</b> </td><td width='50%'> A constant of trasmissivity to use instead of the map. [m^2/day] </td>
</tr>
<tr>
<td width='50%'> <b>inTgphi</b> </td><td width='50%'> The map of the tangent of the friction tangent angle. </td>
</tr>
<tr>
<td width='50%'> <b>pTgphi</b> </td><td width='50%'> A constant of tangent of the friction angle to use instead of the map. </td>
</tr>
<tr>
<td width='50%'> <b>inCohesion</b> </td><td width='50%'> The map of cohesion. <a href='Pa.md'>Pa</a> </td>
</tr>
<tr>
<td width='50%'> <b>pCohesion</b> </td><td width='50%'> A constant of cohesion to use instead of the map. <a href='Pa.md'>Pa</a> </td>
</tr>
<tr>
<td width='50%'> <b>inSdepth</b> </td><td width='50%'> The map of soil depth. <a href='m.md'>m</a> </td>
</tr>
<tr>
<td width='50%'> <b>pSdepth</b> </td><td width='50%'> A constant of soil depth to use instead of the map. <a href='m.md'>m</a> </td>
</tr>
<tr>
<td width='50%'> <b>inQ</b> </td><td width='50%'> The map of effective precipitation. [mm/day] </td>
</tr>
<tr>
<td width='50%'> <b>pQ</b> </td><td width='50%'> A constant of effective precipitation to use instead of the map. [mm/day] </td>
</tr>
<tr>
<td width='50%'> <b>inRho</b> </td><td width='50%'> The map of rho. </td>
</tr>
<tr>
<td width='50%'> <b>pRho</b> </td><td width='50%'> A constant of rho to use instead of the map. </td>
</tr>
<tr>
<td width='50%'> <b>pRock</b> </td><td width='50%'> A value for the slope for rock. </td>
</tr>
</table>

<h3>Output parameters</h3>
<table cellpadding='10' width='70%' border='1'>
<tr>
<td width='50%'> <b>outQcrit</b> </td><td width='50%'> The map of qcrit. </td>
</tr>
<tr>
<td width='50%'> <b>outShalstab</b> </td><td width='50%'> The map of classi. </td>
</tr>
</table>

<h2>Example result</h2>

<img src='http://wiki.jgrasstools.googlecode.com/git/images/hortonmachine/shalstab.png' alt='Shalstab' />
<br>
<h2>Developer example</h2>

An example usage of the algorithm can be found in the testcases suite:<br>
<a href='http://code.google.com/p/jgrasstools/source/browse/hortonmachine/src/test/java/org/jgrasstools/hortonmachine/models/hm/TestShalstab.java'>Shalstab</a>