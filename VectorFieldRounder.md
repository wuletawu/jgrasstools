<h2>Description</h2>

Module that rounds a defined field attribute. The rounding pattern has to be provided with the standard Java convention. More information about how to use the patterns are available in the <a href='http://www.exampledepot.com/egs/java.text/FormatNum.html'> Java Almanac </a>.
<br>
For example if you want to round values in a double field to have only two decimals you can use the following pattern <i>#.##</i> or <i>#.00</i>
if you decide that the numbers have to have always two decimals, in case of just one a zero will be added at the end.<br>
<br>
<br>
<h3>Inputs</h3>
<ul>
<li>the vector of which to round values of a numeric field</li>
<li>the double attribute field of the values to round</li>
<li>the rounding pattern</li>
</ul>
<br>
<br>
<h3>Output</h3>
<ul>
<li>the modified vector file</li>
</ul>


<h2>General Information</h2>

<blockquote>Module status: CERTIFIED</blockquote>

<blockquote>Name to use in a script: <b>vround</b></blockquote>

<blockquote>Authors: Andrea Antonello</blockquote>

<blockquote>Contacts: <a href='http://www.hydrologis.com'>http://www.hydrologis.com</a></blockquote>

<blockquote>License: General Public License Version 3 (GPLv3)</blockquote>

<blockquote>Keywords: Round, VectorFieldJoiner</blockquote>


<h2>Parameters</h2>

<h3>Input parameters</h3>
<table cellpadding='10' width='70%' border='1'>
<tr>
<td width='50%'> <b>inVector</b> </td><td width='50%'> The vector of which to round a numeric value. </td>
</tr>
<tr>
<td width='50%'> <b>fRound</b> </td><td width='50%'> The double field of the number to round. </td>
</tr>
<tr>
<td width='50%'> <b>pPattern</b> </td><td width='50%'> The rounding pattern. </td>
</tr>
</table>

<h3>Output parameters</h3>
<table cellpadding='10' width='70%' border='1'>
<tr>
<td width='50%'> <b>outVector</b> </td><td width='50%'> The modified vector. </td>
</tr>
</table>

<h2>Developer example</h2>

An example usage of the algorithm can be found in the testcases suite:<br>
<a href='http://code.google.com/p/jgrasstools/source/browse/jgrassgears/src/test/java/org/jgrasstools/gears/modules/TestVectorFieldRounder.java'>VectorFieldRounder</a>