<h2>Description</h2>

It calculates the drainage directions with the method of the
maximal steepest descent slope, choosing it among 8 possible directions around the selected pixel.
<br>
<br>
<h3>Inputs</h3>
<ul>
<li>the file containing the matrix of elevations (obtained with pitfiller)</li>
</ul>
<br>
<br>
<h3>Output</h3>
<ul>
<li>the file containing the matrix of the drainage directions</li>
</ul>
<br>
<br>
<h3>Notes</h3>
The maximal slope direction is chosen among the 8 possible directions<br>
and codified with numbers ranging from 0 to 8. Such method derives from the one originarily used by D. Tarboton in his Phd thesis. However the outlets are marked with value 10 (beware: many other programs assume it).<br>
<br>
<br>
<h2>General Information</h2>

<blockquote>Module status: CERTIFIED</blockquote>

<blockquote>Name to use in a script: <b>flow</b></blockquote>

<blockquote>Authors: David Tarboton, Andrea Antonello</blockquote>

<blockquote>Contacts: <a href='http://www.neng.usu.edu/cee/faculty/dtarb/tardem.html#programs'>http://www.neng.usu.edu/cee/faculty/dtarb/tardem.html#programs</a>, <a href='http://www.hydrologis.com'>http://www.hydrologis.com</a>, <a href='http://www.ing.unitn.it/dica/hp/?user=rigon'>http://www.ing.unitn.it/dica/hp/?user=rigon</a></blockquote>

<blockquote>License: General Public License Version 3 (GPLv3)</blockquote>

<blockquote>Keywords: Geomorphology, Aspect</blockquote>


<h2>Parameters</h2>

<h3>Input parameters</h3>
<table cellpadding='10' width='70%' border='1'>
<tr>
<td width='50%'> <b>inPit</b> </td><td width='50%'> The depitted elevation map. </td>
</tr>
</table>

<h3>Output parameters</h3>
<table cellpadding='10' width='70%' border='1'>
<tr>
<td width='50%'> <b>outFlow</b> </td><td width='50%'> The map of flowdirections. </td>
</tr>
</table>

<h2>Example result</h2>

<img src='http://wiki.jgrasstools.googlecode.com/git/images/hortonmachine/flowdirections.png' alt='FlowDirections' />
<br>
<h2>Developer example</h2>

An example usage of the algorithm can be found in the testcases suite:<br>
<a href='http://code.google.com/p/jgrasstools/source/browse/hortonmachine/src/test/java/org/jgrasstools/hortonmachine/models/hm/TestFlowDirections.java'>FlowDirections</a>