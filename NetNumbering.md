<h2>Description</h2>

Assigns numbers to the network's links.
<br>
It can be used by Hillslope2ChannelAttribute to label the hillslope flowing into the link with the same number.<br>
This module can run in three different modes:<br>
<ul>
<li>mode 0: normal way</li>
<li>mode 1: inserting a threshold on TCA to split the network</li>
<li>mode 2: splitting the network in a set of defined points</li>
</ul>
<br>
<br>
<h3>Inputs</h3>
<ul>
<li>the file containing the drainage directions (obtained with Markoutlets, DrainDir, FlowDirections)</li>
<li>the file containing the channel network (obtained with ExtractNetwork)</li>
<li>if we choose to define the maximum value of TCA of each subbasin,the file containing the total contributing areas (obtained<br>
with DrainDir, Tca or Multitca)</li>
<li>if we choose to split the network in a set of defined positions, the vector point map containing the monitoring points</li>
</ul>
<br>
<br>
<h3>Output</h3>
<ul>
<li>the file containing the net with the streams numerated</li>
<li>the file containing the sub-basins</li>
</ul>
<br>
<br>
<h3>Notes</h3>
The algorithm start from the channel heads which are numbered first. Then, starting again from each source, the drainage direction are followed till a junction is found. If the link downhill the junction was already numbered, a new source is chosen. Otherwise the network is scanned downstream ad a new number is attributed to the link's pixels.<br>
<br>
<br>
<h2>General Information</h2>

<blockquote>Module status: CERTIFIED</blockquote>

<blockquote>Name to use in a script: <b>netnum</b></blockquote>

<blockquote>Authors: Daniele Andreis, Antonello Andrea, Erica Ghesla, Cozzini Andrea, Franceschi Silvia, Pisoni Silvano, Rigon Riccardo</blockquote>

<blockquote>Contacts: <a href='http://www.hydrologis.com'>http://www.hydrologis.com</a>, <a href='http://www.ing.unitn.it/dica/hp/?user=rigon'>http://www.ing.unitn.it/dica/hp/?user=rigon</a></blockquote>

<blockquote>License: General Public License Version 3 (GPLv3)</blockquote>

<blockquote>Keywords: Network, SplitSubbasins</blockquote>


<h2>Parameters</h2>

<h3>Input parameters</h3>
<table cellpadding='10' width='70%' border='1'>
<tr>
<td width='50%'> <b>inFlow</b> </td><td width='50%'> The map of flowdirections. </td>
</tr>
<tr>
<td width='50%'> <b>inTca</b> </td><td width='50%'> The map of total contributing area. </td>
</tr>
<tr>
<td width='50%'> <b>inNet</b> </td><td width='50%'> The map of the network. </td>
</tr>
<tr>
<td width='50%'> <b>inPoints</b> </td><td width='50%'> The monitoringpoints vector map. </td>
</tr>
<tr>
<td width='50%'> <b>pMode</b> </td><td width='50%'> The running mode: 0: standard way (default); 1: with a threshold on TCA; 2: in a set of defined monitoring points </td>
</tr>
<tr>
<td width='50%'> <b>pThres</b> </td><td width='50%'> Threshold value on tca map. </td>
</tr>
<tr>
<td width='50%'> <b>fPointId</b> </td><td width='50%'> The name of the node id field in mode 2. </td>
</tr>
</table>

<h3>Output parameters</h3>
<table cellpadding='10' width='70%' border='1'>
<tr>
<td width='50%'> <b>outNetnum</b> </td><td width='50%'> The map of netnumbering </td>
</tr>
<tr>
<td width='50%'> <b>outBasins</b> </td><td width='50%'> The map of subbasins </td>
</tr>
</table>

<h2>Example result</h2>

<img src='http://wiki.jgrasstools.googlecode.com/git/images/hortonmachine/netnumbering.png' alt='NetNumbering' />
<br>
<h2>Developer example</h2>

An example usage of the algorithm can be found in the testcases suite:<br>
<a href='http://code.google.com/p/jgrasstools/source/browse/hortonmachine/src/test/java/org/jgrasstools/hortonmachine/models/hm/TestNetNumbering.java'>NetNumbering</a>