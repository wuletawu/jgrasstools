<h2>Description</h2>

The upslope catchment (or simply contributing) areas represent the planar projection of the areas afferent to a point in the basin. Once the drainage directions have been defined, it is possible to calculate, for each site, the total drainage area afferent to it, indicated as TCA (Total Contributing Area).
<br>
<br>
<h3>Inputs</h3>
<ul>
<li>the file containing the matrix of drainage directions (obtained with Markoutlets or DrainDir, mflow})</li>
</ul>
<br>
<br>
<h3>Output</h3>
<ul>
<li>the file containing the matrix of the contributing areas (tca)</li>
</ul>
<br>
<br>
<h3>Notes</h3>
The values in the TCA output map are in number of pixels upstream, so they should be multiplied by the area of the pixels to have the area in km<sup>2</sup>.<br>
<br>
<br>
<h2>General Information</h2>

<blockquote>Module status: CERTIFIED</blockquote>

<blockquote>Name to use in a script: <b>tca</b></blockquote>

<blockquote>Authors: Antonello Andrea, Rigon Riccardo</blockquote>

<blockquote>Contacts: <a href='http://www.hydrologis.com'>http://www.hydrologis.com</a>, <a href='http://www.ing.unitn.it/dica/hp/?user=rigon'>http://www.ing.unitn.it/dica/hp/?user=rigon</a></blockquote>

<blockquote>License: General Public License Version 3 (GPLv3)</blockquote>

<blockquote>Keywords: Geomorphology, DrainDir, Tca3D, Ab, Multitca</blockquote>


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
<td width='50%'> <b>outTca</b> </td><td width='50%'> The map of total contributing areas. </td>
</tr>
<tr>
<td width='50%'> <b>outLoop</b> </td><td width='50%'> The vector containing loops, if there are any. </td>
</tr>
</table>

<h2>Example result</h2>

<img src='http://wiki.jgrasstools.googlecode.com/git/images/hortonmachine/tca.png' alt='Tca' />
<br>
<h2>Developer example</h2>

An example usage of the algorithm can be found in the testcases suite:<br>
<a href='http://code.google.com/p/jgrasstools/source/browse/hortonmachine/src/test/java/org/jgrasstools/hortonmachine/models/hm/TestTca.java'>Tca</a>