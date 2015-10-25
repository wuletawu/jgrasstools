<h2>Description</h2>

<p>Select a <i>hillslope</i> or some of its property from the <b>DEM</b>. Since hillslope<br>
are identiﬁed by channel links, if a numbering of links is available, it gives to any pixel<br>
draining into a given link the link number.</p>
<br>
<br>
<h3>Inputs</h3>
<ol>
<li>The GridCoverage containing the matrix of the drainage directions, obtained with <a href='Markoutlets.md'>Markoutlets</a>;</li>
<li>The GridCoverage containing the network, obtained with <a href='ExtractNetwork.md'>ExtractNetwork</a>;</li>
<li>The GridCoverage containing the attribute to estimate;</li>
</ol>
<br>
<br>
<h3>Output</h3>
<ol>
<li>The GridCoverage for each hillslope pixel the attribute of the network pixel in which it drains;</li>
</ol>
<br>
<br>
<h3>Notes</h3>
<p> Eventually, one can select all the hillslope points which<br>
share the same link number, i.e. the points which belongs to the same hillslope. Another use of this<br>
application is to associate to any hillslope point its channel path length. In general, it labels<br>
any hillslope pixel with the channel quantity found in the position where the hillslope pixel drains.<br>
</p>
<br>
<br>
<h3>References</h3>
<ul>
<li><a href='Bibliography#15,.md'>15</a> P. D’Odorico, 2003</li>
</ul>


<h2>General Information</h2>

<blockquote>Module status: CERTIFIED</blockquote>

<blockquote>Name to use in a script: <b>H2cA</b></blockquote>

<blockquote>Authors: Andreis Daniele,  Erica Ghesla, Antonello Andrea, CozziniAndrea, Franceschi Silvia, Pisoni Silvano, Rigon Riccardo</blockquote>

<blockquote>Contacts:</blockquote>

<blockquote>License: General Public License Version 3 (GPLv3)</blockquote>

<blockquote>Keywords: Geomorphology, DrainDir</blockquote>


<h2>Parameters</h2>

<h3>Input parameters</h3>
<table cellpadding='10' width='70%' border='1'>
<tr>
<td width='50%'> <b>inFlow</b> </td><td width='50%'> The map of flowdirections. </td>
</tr>
<tr>
<td width='50%'> <b>inNet</b> </td><td width='50%'> The map with the net. </td>
</tr>
<tr>
<td width='50%'> <b>inAttribute</b> </td><td width='50%'> The map of the attribute to estimate. </td>
</tr>
</table>

<h3>Output parameters</h3>
<table cellpadding='10' width='70%' border='1'>
<tr>
<td width='50%'> <b>outAttribute</b> </td><td width='50%'> The output map of the attribute. </td>
</tr>
</table>

<h2>Example result</h2>

<img src='http://wiki.jgrasstools.googlecode.com/git/images/hortonmachine/h2ca.png' alt='H2cA' />
<br>
<h2>Developer example</h2>

An example usage of the algorithm can be found in the testcases suite:<br>
<a href='http://code.google.com/p/jgrasstools/source/browse/hortonmachine/src/test/java/org/jgrasstools/hortonmachine/models/hm/TestH2cA.java'>H2cA</a>