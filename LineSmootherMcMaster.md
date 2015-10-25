<h2>Description</h2>

The McMasters Sliding Averaging Algorithm smoothing algorithms. The new position of each point is the average of the pLookahead  points around. Parameter pSlide is used for linear interpolation between old and new position.
<br>
<br>
<h3>Inputs</h3>
<ul>
<li>the vector containing the lines to be smoothed</li>
<li>the number of points to consider in every smoothing step</li>
<li>minimum length for a line to be smoothed</li>
<li>other model parameters like: slide parameter, densifier interval, simplifier tollerance</li>
</ul>
<br>
<br>
<h3>Output</h3>
<ul>
<li>the vector with smoothed features</li>
</ul>


<h2>General Information</h2>

<blockquote>Module status: CERTIFIED</blockquote>

<blockquote>Name to use in a script: <b>linesmoother</b></blockquote>

<blockquote>Authors: Andrea Antonello</blockquote>

<blockquote>Contacts: <a href='http://www.hydrologis.com'>http://www.hydrologis.com</a></blockquote>

<blockquote>License: General Public License Version 3 (GPLv3)</blockquote>

<blockquote>Keywords: Smoothing, Vector, LineSmootherJaitools</blockquote>


<h2>Parameters</h2>

<h3>Input parameters</h3>
<table cellpadding='10' width='70%' border='1'>
<tr>
<td width='50%'> <b>inVector</b> </td><td width='50%'> The vector containing the lines to be smoothed. </td>
</tr>
<tr>
<td width='50%'> <b>pLookahead</b> </td><td width='50%'> The number of points to consider in every smoothing step (default = 7). </td>
</tr>
<tr>
<td width='50%'> <b>pLimit</b> </td><td width='50%'> Minimum length for a line to be smoothed. </td>
</tr>
<tr>
<td width='50%'> <b>pSlide</b> </td><td width='50%'> Slide parameter. </td>
</tr>
<tr>
<td width='50%'> <b>pDensify</b> </td><td width='50%'> Densifier interval. </td>
</tr>
<tr>
<td width='50%'> <b>pSimplify</b> </td><td width='50%'> Simplifier tollerance. </td>
</tr>
</table>

<h3>Output parameters</h3>
<table cellpadding='10' width='70%' border='1'>
<tr>
<td width='50%'> <b>outVector</b> </td><td width='50%'> The vector with smoothed features. </td>
</tr>
</table>

<h2>Developer example</h2>

An example usage of the algorithm can be found in the testcases suite:<br>
<a href='http://code.google.com/p/jgrasstools/source/browse/jgrassgears/src/test/java/org/jgrasstools/gears/modules/TestLineSmootherMcMaster.java'>LineSmootherMcMaster</a>