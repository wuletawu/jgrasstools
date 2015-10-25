<h2>Description</h2>

Estimates the slope in every site by employing the drainage directions. Differently from the gradients, slope calculates the drop between each pixel and the adjacent points placed underneath and it divides the result by the pixel length or by the length of the pixel diagonal, according to the cases. The greatest value is the one chosen as slope.
Output values are in tangent of the angle.
<br>
<br>
<h3>Inputs</h3>
<ul>
<li>the file containing the matrix of elevations (the map obtained with pitfiller)</li>
<li>the files containing the matrix of the drainage directions (obtained with Markoutlets or DrainDir}</li>
</ul>
<br>
<br>
<h3>Output</h3>
<ul>
<li>file containing the matrix of the slopes</li>
</ul>
<br>
<br>
<h3>Notes</h3>
To estimate slopes, this program considers the drainage directions, estimating the slope of every pixel in the direction of the less high, near pixel (steepestdescent). For many purposes, this slope is used as an extimation of the gradient. The patterns are in fact very similar. However, it is apparent that the two definition do not coincide at al.<br>
<br>
As a rule, the program places on the catchment boundary the slope equal to zero.<br>
<br>
<br>
<h2>General Information</h2>

<blockquote>Module status: TESTED</blockquote>

<blockquote>Name to use in a script: <b>slope</b></blockquote>

<blockquote>Authors: Antonello Andrea, Erica Ghesla, Cozzini Andrea, Franceschi Silvia, Pisoni Silvano, Rigon Riccardo</blockquote>

<blockquote>Contacts: <a href='http://www.hydrologis.com'>http://www.hydrologis.com</a>, <a href='http://www.ing.unitn.it/dica/hp/?user=rigon'>http://www.ing.unitn.it/dica/hp/?user=rigon</a></blockquote>

<blockquote>License: General Public License Version 3 (GPLv3)</blockquote>

<blockquote>Keywords: Geomorphology, Gradient</blockquote>


<h2>Parameters</h2>

<h3>Input parameters</h3>
<table cellpadding='10' width='70%' border='1'>
<tr>
<td width='50%'> <b>inPit</b> </td><td width='50%'> The depitted elevation map. </td>
</tr>
<tr>
<td width='50%'> <b>inFlow</b> </td><td width='50%'> The map of flowdirection. </td>
</tr>
</table>

<h3>Output parameters</h3>
<table cellpadding='10' width='70%' border='1'>
<tr>
<td width='50%'> <b>outSlope</b> </td><td width='50%'> The map of gradient. </td>
</tr>
</table>

<h2>Example result</h2>

<img src='http://wiki.jgrasstools.googlecode.com/git/images/hortonmachine/slope.png' alt='Slope' />
<br>
<h2>Developer example</h2>

An example usage of the algorithm can be found in the testcases suite:<br>
<a href='http://code.google.com/p/jgrasstools/source/browse/hortonmachine/src/test/java/org/jgrasstools/hortonmachine/models/hm/TestSlope.java'>Slope</a>