<h2>Description</h2>

Calculates the rescaled distance of each pixel from the outlet. Such distance is so defined:
<table>
<tr>
<td>
<blockquote>x' = x<sub>c</sub> + rx<sub>h</sub>
</td>
</tr>
</table>
where:<br>
<ul>
<li>x<sub>c</sub> is the distance along the channels</li>
<li>r=c/c<sub>h</sub> the ratio between the speed in the channel state<br>
<i>c</i> and the speed in the hillslopes <i>c<sub>h</sub></i> </li>
<li><i>x<sub>h</sub></i> the distance along the hillslopes</li>
<br>
<br>
<h3>Inputs</h3>
<ul>
<li>the file containing the matrix of the drainage directions (obtained with DrainDir)</li>
<li>the file containing the net (obtained with ExtractNetwork)</li>
</ul>
<br>
<br>
<h3>Output</h3>
<ul>
<li>the file containing the matrix of the rescaled distances</li>
</ul>
<br>
<br>
<h3>Notes</h3>
The program requests also the ratio <i>r</i> between speed in the channel and speed in hillslopes. The speed in channels is always greater than that in hillslopes.</blockquote>


<h2>General Information</h2>

<blockquote>Module status: CERTIFIED</blockquote>

<blockquote>Name to use in a script: <b>rescdist</b></blockquote>

<blockquote>Authors: Daniele Andreis, Antonello Andrea, Erica Ghesla, Cozzini Andrea, Franceschi Silvia, Pisoni Silvano, Rigon Riccardo</blockquote>

<blockquote>Contacts: <a href='http://www.hydrologis.com'>http://www.hydrologis.com</a>, <a href='http://www.ing.unitn.it/dica/hp/?user=rigon'>http://www.ing.unitn.it/dica/hp/?user=rigon</a></blockquote>

<blockquote>License: General Public License Version 3 (GPLv3)</blockquote>

<blockquote>Keywords: Basin, Geomorphology, D2O</blockquote>


<h2>Parameters</h2>

<h3>Input parameters</h3>
<table cellpadding='10' width='70%' border='1'>
<tr>
<td width='50%'> <b>inFlow</b> </td><td width='50%'> The map of flowdirections. </td>
</tr>
<tr>
<td width='50%'> <b>inNet</b> </td><td width='50%'> The map of the network. </td>
</tr>
<tr>
<td width='50%'> <b>pRatio</b> </td><td width='50%'> Ratio between the velocity in the channel and in the hillslope. </td>
</tr>
</table>

<h3>Output parameters</h3>
<table cellpadding='10' width='70%' border='1'>
<tr>
<td width='50%'> <b>outRescaled</b> </td><td width='50%'> The map of the rescaled distances. </td>
</tr>
</table>

<h2>Example result</h2>

<img src='http://wiki.jgrasstools.googlecode.com/git/images/hortonmachine/rescaleddistance.png' alt='RescaledDistance' />
<br>
<h2>Developer example</h2>

An example usage of the algorithm can be found in the testcases suite:<br>
<a href='http://code.google.com/p/jgrasstools/source/browse/hortonmachine/src/test/java/org/jgrasstools/hortonmachine/models/hm/TestRescaledDistance.java'>RescaledDistance</a>