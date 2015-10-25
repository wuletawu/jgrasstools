<h2>Description</h2>

Collection of vector simplification algorithms. This model works on all kind of feature types (point, line or polygon), obviously the simplification of a point layer is nonsense.
<br>
Simplification is used to reducing the number of points in a geometry that is approximated by a series of points.<br>
<br>
There are two different simplification algorithms integrated in this module:<br>
<ul>
<li> 0 : TopologyPreservingSimplifier: simplifies a geometry, ensuring that the result is a valid geometry having the same dimension and number of components as the input. The simplification uses a maximum distance difference algorithm similar to the one used in the Douglas-Peucker algorithm</li>
<li> 1 : Douglas Peucker: a detailed description of this method is available in <a href='http://en.wikipedia.org/wiki/Ramer%E2%80%93Douglas%E2%80%93Peucker_algorithm'> Wikipedia </a></li>
</ul>
<br>
<br>
<h3>Inputs</h3>
<ul>
<li>the vector to be simplified</li>
<li>the simplification type: TopologyPreservingSimplifier (0), Douglas Peucker (1) (default = 0)</li>
<li>the distance tolerance for the simplification</li>
</ul>
<br>
<br>
<h3>Output</h3>
<ul>
<li>the simplified vector</li>
</ul>


<h2>General Information</h2>

<blockquote>Module status: CERTIFIED</blockquote>

<blockquote>Name to use in a script: <b>vsimplify</b></blockquote>

<blockquote>Authors: Andrea Antonello</blockquote>

<blockquote>Contacts: <a href='http://www.hydrologis.com'>http://www.hydrologis.com</a></blockquote>

<blockquote>License: General Public License Version 3 (GPLv3)</blockquote>

<blockquote>Keywords: Simplify, LineSmootherMcMaster, LineSmootherJaitools</blockquote>


<h2>Parameters</h2>

<h3>Input parameters</h3>
<table cellpadding='10' width='70%' border='1'>
<tr>
<td width='50%'> <b>inVector</b> </td><td width='50%'> The vector to be simplified. </td>
</tr>
<tr>
<td width='50%'> <b>pType</b> </td><td width='50%'> The simplification type: TopologyPreservingSimplifier = 0, Douglas Peucker = 1 (default = 0). </td>
</tr>
<tr>
<td width='50%'> <b>pTolerance</b> </td><td width='50%'> The distance tolerance for the simplification. </td>
</tr>
</table>

<h3>Output parameters</h3>
<table cellpadding='10' width='70%' border='1'>
<tr>
<td width='50%'> <b>outVector</b> </td><td width='50%'> The simplified vector. </td>
</tr>
</table>
