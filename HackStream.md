<h2>Description</h2>

Arranges a channel network enumeration starting from the identification of the branch according to Hack. The main stream is of order 1 and its tributaries of order 2 and so on, the sub-tributaries are of order 3 and so on.
<br>
The model can run in two different modes:<br>
<ul>
<li> 0 : standard mode</li>
<li> 1 : Hack enumeration based on Netnumbering</li>
</ul>
<br>
<br>
<h3>Inputs</h3>
<ul>
<li>the file containing the drainage directions (obtained with Markoutlets, DrainDir, FlowDirections)</li>
<li>the file containing the total contributing areas (obtained<br>
with DrainDir, Tca or Multitca)</li>
<li>the file containing the Hack lengths (obtained with HackLength)</li>
<li>the file containing the channel network (obtained with ExtractNetwork)</li>
<li>only for mode 1: the file containing the channel enumeration (obtained with NetNumbering)</li>
</ul>
<br>
<br>
<h3>Output</h3>
<ul>
<li>the file with the net order according the Hack lengths</li>
</ul>
<br>
<br>
<h3>Notes</h3>
The Hack order corresponds (one to one) to the old Horton's network enumeration.<br>
<br>
To run the model it is necessary that the outlet pixel presents a drainage direction value equal to 10. If there is not such identification, the program will not work correctly.<br>
<br>
<br>
<h2>General Information</h2>

<blockquote>Module status: CERTIFIED</blockquote>

<blockquote>Name to use in a script: <b>hackstream</b></blockquote>

<blockquote>Authors: Daniele Andreis, Antonello Andrea, Erica Ghesla, Cozzini Andrea, Franceschi Silvia, Pisoni Silvano, Rigon Riccardo</blockquote>

<blockquote>Contacts: <a href='http://www.hydrologis.com'>http://www.hydrologis.com</a>, <a href='http://www.ing.unitn.it/dica/hp/?user=rigon'>http://www.ing.unitn.it/dica/hp/?user=rigon</a></blockquote>

<blockquote>License: General Public License Version 3 (GPLv3)</blockquote>

<blockquote>Keywords: Network, Hack</blockquote>


<h2>Parameters</h2>

<h3>Input parameters</h3>
<table cellpadding='10' width='70%' border='1'>
<tr>
<td width='50%'> <b>inFlow</b> </td><td width='50%'> The map of flowdirections. </td>
</tr>
<tr>
<td width='50%'> <b>inTca</b> </td><td width='50%'> The map of tca. </td>
</tr>
<tr>
<td width='50%'> <b>inHacklength</b> </td><td width='50%'> The map of hack lengths. </td>
</tr>
<tr>
<td width='50%'> <b>inNet</b> </td><td width='50%'> The map of the network. </td>
</tr>
<tr>
<td width='50%'> <b>inNetnum</b> </td><td width='50%'> The map of the netnum (in mode 1). </td>
</tr>
<tr>
<td width='50%'> <b>pMode</b> </td><td width='50%'> The processing mode (0=default, 1=with fixed network). </td>
</tr>
</table>

<h3>Output parameters</h3>
<table cellpadding='10' width='70%' border='1'>
<tr>
<td width='50%'> <b>outHackstream</b> </td><td width='50%'> The map of hackstream. </td>
</tr>
</table>

<h2>Example result</h2>

<img src='http://wiki.jgrasstools.googlecode.com/git/images/hortonmachine/hackstream.png' alt='HackStream' />
<br>
<h2>Developer example</h2>

An example usage of the algorithm can be found in the testcases suite:<br>
<a href='http://code.google.com/p/jgrasstools/source/browse/hortonmachine/src/test/java/org/jgrasstools/hortonmachine/models/hm/TestHackStream.java'>HackStream</a>