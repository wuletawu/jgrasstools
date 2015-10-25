<h2>Description</h2>

Estimates the gradient in each site, defined as the module of the gradient vector.
<br>
It is possible to choose between different formulas to calculate the gradient and to define if the output map values should be in tangent of the angles or in degrees.<br>
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
<li>file containing the matrix of the gradients</li>
</ul>
<br>
<br>
<h3>Notes</h3>
Let's observe that <i>gradients</i>, contrarily to <i>slope</i>, does not use the drainage directions defined by DrainDir or FlowDirections. Moreover, <i>Gradients</i> calculates only the module of the gradient which in reality is a vectorial quantity, oriented in the direction from the minimal to the maximal potential.<br>
<br>
As a rule, the program places on<br>
the catchment boundary the gradient equal to zero.<br>
<br>
<br>
<h2>General Information</h2>

<blockquote>Module status: CERTIFIED</blockquote>

<blockquote>Name to use in a script: <b>gradient</b></blockquote>

<blockquote>Authors: Daniele Andreis, Antonello Andrea, Erica Ghesla, Cozzini Andrea, Franceschi Silvia, Pisoni Silvano, Rigon Riccardo</blockquote>

<blockquote>Contacts: <a href='http://www.hydrologis.com'>http://www.hydrologis.com</a>, <a href='http://www.ing.unitn.it/dica/hp/?user=rigon'>http://www.ing.unitn.it/dica/hp/?user=rigon</a></blockquote>

<blockquote>License: General Public License Version 3 (GPLv3)</blockquote>

<blockquote>Keywords: Geomorphology, DrainDir, FlowDirections, Slope, Curvatures</blockquote>


<h2>Parameters</h2>

<h3>Input parameters</h3>
<table cellpadding='10' width='70%' border='1'>
<tr>
<td width='50%'> <b>inElev</b> </td><td width='50%'> The map of the digital elevation model (DEM or pit). </td>
</tr>
<tr>
<td width='50%'> <b>pMode</b> </td><td width='50%'> The gradient formula mode (0 = finite differences, 1 = horn, 2 = evans). </td>
</tr>
<tr>
<td width='50%'> <b>doDegrees</b> </td><td width='50%'> The output type, if false = tan of the angle (default), if true = degrees </td>
</tr>
</table>

<h3>Output parameters</h3>
<table cellpadding='10' width='70%' border='1'>
<tr>
<td width='50%'> <b>outSlope</b> </td><td width='50%'> The map of gradient. </td>
</tr>
</table>

<h2>Example result</h2>

<img src='http://wiki.jgrasstools.googlecode.com/git/images/hortonmachine/gradient.png' alt='Gradient' />
<br>
<h2>Developer example</h2>

An example usage of the algorithm can be found in the testcases suite:<br>
<a href='http://code.google.com/p/jgrasstools/source/browse/hortonmachine/src/test/java/org/jgrasstools/hortonmachine/models/hm/TestGradient.java'>Gradient</a>