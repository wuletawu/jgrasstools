<h2>Description</h2>

Sums the values of an assigned quantity from the point till the outlet. The final result is then a matrix of values containing the sum of the quantity in input on all upriver points:
<table>
<tr>
<td>
<blockquote>S=sum<sub>ij</sub> A<sub>j</sub>
</td>
</tr>
</table>
where <i>i</i> is the point examined and the index <i>j</i> varies on all points upriver with respect to the point examined.<br>
<br>
<br>
<h3>Inputs</h3>
<ul>
<li>the file containing the drainage directions (obtained with FlowDirections or DrainDir)</li>
<li>the file containing the quantity to sum</li>
</ul>
<br>
<br>
<h3>Output</h3>
<ul>
<li>the file containing the summed quantities downstream</li>
</ul></blockquote>


<h2>General Information</h2>

<blockquote>Module status: CERTIFIED</blockquote>

<blockquote>Name to use in a script: <b>sumdownstream</b></blockquote>

<blockquote>Authors: Daniele Andreis, Antonello Andrea, Erica Ghesla, Cozzini Andrea, Franceschi Silvia, Pisoni Silvano, Rigon Riccardo</blockquote>

<blockquote>Contacts: <a href='http://www.hydrologis.com'>http://www.hydrologis.com</a>, <a href='http://www.ing.unitn.it/dica/hp/?user=rigon'>http://www.ing.unitn.it/dica/hp/?user=rigon</a></blockquote>

<blockquote>License: General Public License Version 3 (GPLv3)</blockquote>

<blockquote>Keywords: Sumdownstream, Statistic, ExtractNetwork</blockquote>


<h2>Parameters</h2>

<h3>Input parameters</h3>
<table cellpadding='10' width='70%' border='1'>
<tr>
<td width='50%'> <b>inFlow</b> </td><td width='50%'> The map of flowdirections. </td>
</tr>
<tr>
<td width='50%'> <b>inToSum</b> </td><td width='50%'> The map to sum. </td>
</tr>
<tr>
<td width='50%'> <b>pUpperThres</b> </td><td width='50%'> The upper threshold. </td>
</tr>
<tr>
<td width='50%'> <b>pLowerThres</b> </td><td width='50%'> The lower threshold. </td>
</tr>
</table>

<h3>Output parameters</h3>
<table cellpadding='10' width='70%' border='1'>
<tr>
<td width='50%'> <b>outSummed</b> </td><td width='50%'> The map of summed values. </td>
</tr>
</table>

<h2>Example result</h2>

<img src='http://wiki.jgrasstools.googlecode.com/git/images/hortonmachine/sumdownstream.png' alt='SumDownStream' />
<br>
<h2>Developer example</h2>

An example usage of the algorithm can be found in the testcases suite:<br>
<a href='http://code.google.com/p/jgrasstools/source/browse/hortonmachine/src/test/java/org/jgrasstools/hortonmachine/models/hm/TestSumDownStream.java'>SumDownStream</a>