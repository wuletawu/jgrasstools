<h2>Description</h2>

Calculates the topographic index of a basin defined as:
<table>
<tr>
<td>
<blockquote>log (A/s) - mu<br>
</td>
</tr>
</table>
where:<br>
<ul>
<li>A is the contributing area in one point</li>
<li>s the slope</li>
<li>mu = 1/N sum<sub>i</sub> log(A<sub>i</sub>/s<sub>i</sub>) is the mean value of the logarithm over the whole basin (N is the number of pixels belonging to the basin)</li>
</ul>
<br>
It is an index which is necessary to recognize the sites generating<br>
dunnian surface flow in a similar way. Sites with higher topographic<br>
index become saturated before than sites with lower topographic<br>
index.<br>
<br>
<br>
<h3>Inputs</h3>
<ul>
<li>the file containing the matrix of the contributing areas (obtained with DrainDir or Tca)</li>
<li>the file containing the matrix of the slope (obtained with Gradient or Slope)</li>
</ul>
<br>
<br>
<h3>Output</h3>
<ul>
<li>the file containing the matrix of the topographic indexes</li>
</ul></blockquote>


<h2>General Information</h2>

<blockquote>Module status: CERTIFIED</blockquote>

<blockquote>Name to use in a script: <b>topindex</b></blockquote>

<blockquote>Authors: Daniele Andreis, Antonello Andrea, Erica Ghesla, Cozzini Andrea, Franceschi Silvia, Pisoni Silvano, Rigon Riccardo</blockquote>

<blockquote>Contacts: <a href='http://www.hydrologis.com'>http://www.hydrologis.com</a>, <a href='http://www.ing.unitn.it/dica/hp/?user=rigon'>http://www.ing.unitn.it/dica/hp/?user=rigon</a></blockquote>

<blockquote>License: General Public License Version 3 (GPLv3)</blockquote>

<blockquote>Keywords: Hydrology</blockquote>


<h2>Parameters</h2>

<h3>Input parameters</h3>
<table cellpadding='10' width='70%' border='1'>
<tr>
<td width='50%'> <b>inTca</b> </td><td width='50%'> The map of the contributing area. </td>
</tr>
<tr>
<td width='50%'> <b>inSlope</b> </td><td width='50%'> The map of slope. </td>
</tr>
</table>

<h3>Output parameters</h3>
<table cellpadding='10' width='70%' border='1'>
<tr>
<td width='50%'> <b>outTopindex</b> </td><td width='50%'> The map of the topographic index. </td>
</tr>
</table>

<h2>Example result</h2>

<img src='http://wiki.jgrasstools.googlecode.com/git/images/hortonmachine/topindex.png' alt='TopIndex' />
<br>
<h2>Developer example</h2>

An example usage of the algorithm can be found in the testcases suite:<br>
<a href='http://code.google.com/p/jgrasstools/source/browse/hortonmachine/src/test/java/org/jgrasstools/hortonmachine/models/hm/TestTopIndex.java'>TopIndex</a>