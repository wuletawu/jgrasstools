<h2>Description</h2>

Marks all the outlets of the considered region on the drainage directions map with the conventional value 10. In fact some applications in JGrassTools request that the outlets are specified explicitly.
<br>
<br>
<h3>Inputs</h3>
<ul>
<li>the file containing the matrix of the drainage directions to<br>
modify (obtained with FlowDirections or DrainDir)</li>
</ul>
<br>
<br>
<h3>Output</h3>
<ul>
<li>the file containing the matrix of the flow data assigned in input<br>
with the outlets set equal to 10</li>
</ul>
<br>
<br>
<h3>Notes</h3>
The program works following the drainage directions until it finds a value that is not a drainage direction. Then it marks the point directly upriver as outlet.<br>
<br>
<br>
<h2>General Information</h2>

<blockquote>Module status: TESTED</blockquote>

<blockquote>Name to use in a script: <b>markoutlets</b></blockquote>

<blockquote>Authors: Antonello Andrea, Erica Ghesla, Cozzini Andrea, Franceschi Silvia, Pisoni Silvano, Rigon Riccardo</blockquote>

<blockquote>Contacts: <a href='http://www.hydrologis.com'>http://www.hydrologis.com</a>, <a href='http://www.ing.unitn.it/dica/hp/?user=rigon'>http://www.ing.unitn.it/dica/hp/?user=rigon</a></blockquote>

<blockquote>License: General Public License Version 3 (GPLv3)</blockquote>

<blockquote>Keywords: Outlets, Dem, Raster, FlowDirections, DrainDir</blockquote>


<h2>Parameters</h2>

<h3>Input parameters</h3>
<table cellpadding='10' width='70%' border='1'>
<tr>
<td width='50%'> <b>inFlow</b> </td><td width='50%'> The map of flowdirections. </td>
</tr>
</table>

<h3>Output parameters</h3>
<table cellpadding='10' width='70%' border='1'>
<tr>
<td width='50%'> <b>outFlow</b> </td><td width='50%'> The map of the flowdirections with outlet marked. </td>
</tr>
</table>

<h2>Example result</h2>

<img src='http://wiki.jgrasstools.googlecode.com/git/images/hortonmachine/markoutlets.png' alt='Markoutlets' />
<br>
<h2>Developer example</h2>

An example usage of the algorithm can be found in the testcases suite:<br>
<a href='http://code.google.com/p/jgrasstools/source/browse/hortonmachine/src/test/java/org/jgrasstools/hortonmachine/models/hm/TestMarkoutlets.java'>Markoutlets</a>