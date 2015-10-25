<h2>Description</h2>

It calculates the drainage directions minimizing the deviation from the real flow. The deviation is calculated using a triangular construction
and it could be given in degrees (D8 LAD method) or as (trasversal distance (D8 LTD method). The deviation could be cumulated
along the path using the <i>lambda</i> parameter, and when it assumes a
limit value the flux is redirected towards the real gradient direction. If
the drainage network is known and marked in a raster matrix with the corresponding drainage directions, its flow directions can be kept fixed.
It is possible to run the model in two different ways, the standard and the one in which the drainage directions will be kept fixed on real data.
<br>
<br>
<h3>Inputs</h3>
<ul>
<li>the file containing the matrix of elevations (obtained with pitfiller)</li>
<li>the file containing the old drainage direction matrix (obtained with<br>
flowdirections)</li>
<li>if we choose to fix the network, the map containing the drainage<br>
directions along the network</li>
</ul>
<br>
<br>
<h3>Output</h3>
<ul>
<li>the file containing the new drainage directions</li>
<li>the file containing the total contributing areas calculated with the new drainage directions</li>
</ul>
<br>
<br>
<h3>Notes</h3>
The parameter <i>lambda</i> changes in the range from 0 (do not consider the upstream cumulated deviation) to 1 (consider all the upstream cumulated deviation).<br>
<br>
The mode with fixed network only works with the LTD method of the program.<br>
<br>
If the fixed network mode is selected the output TCA file is calculated considering the original drainage directions calculated with DrainDir, to have TCA<br>
on the drainage directions considering the fixed network please run Tca separately with this as input flow map.<br>
<br>
<br>
<h2>General Information</h2>

<blockquote>Module status: CERTIFIED</blockquote>

<blockquote>Name to use in a script: <b>draindir</b></blockquote>

<blockquote>Authors: Andrea Antonello, Franceschi Silvia, Erica Ghesla, Rigon Riccardo</blockquote>

<blockquote>Contacts: <a href='http://www.hydrologis.com'>http://www.hydrologis.com</a>, <a href='http://www.ing.unitn.it/dica/hp/?user=rigon'>http://www.ing.unitn.it/dica/hp/?user=rigon</a></blockquote>

<blockquote>License: General Public License Version 3 (GPLv3)</blockquote>

<blockquote>Keywords: Geomorphology, Pitfiller, FlowDirections</blockquote>


<h2>Parameters</h2>

<h3>Input parameters</h3>
<table cellpadding='10' width='70%' border='1'>
<tr>
<td width='50%'> <b>inPit</b> </td><td width='50%'> The depitted elevation model. </td>
</tr>
<tr>
<td width='50%'> <b>inFlow</b> </td><td width='50%'> The map of flowdirections. </td>
</tr>
<tr>
<td width='50%'> <b>inFlownet</b> </td><td width='50%'> The map of flowdirections on the network pixels (considered only in case of LTD method). Remember that in the case of fixed flow calculation the tca has to be recalculated afterwards; the tca output in this case is not corrected. </td>
</tr>
<tr>
<td width='50%'> <b>pLambda</b> </td><td width='50%'> The direction correction factor. </td>
</tr>
<tr>
<td width='50%'> <b>doLad</b> </td><td width='50%'> Switch for the mode to use: true = LAD (default), false = LTD)). </td>
</tr>
</table>

<h3>Output parameters</h3>
<table cellpadding='10' width='70%' border='1'>
<tr>
<td width='50%'> <b>outFlow</b> </td><td width='50%'> The map of drainage directions. </td>
</tr>
<tr>
<td width='50%'> <b>outTca</b> </td><td width='50%'> The map of total contributing areas. </td>
</tr>
</table>

<h2>Example result</h2>

<img src='http://wiki.jgrasstools.googlecode.com/git/images/hortonmachine/draindir.png' alt='DrainDir' />
<br>
<h2>Developer example</h2>

An example usage of the algorithm can be found in the testcases suite:<br>
<a href='http://code.google.com/p/jgrasstools/source/browse/hortonmachine/src/test/java/org/jgrasstools/hortonmachine/models/hm/TestDrainDir.java'>DrainDir</a>