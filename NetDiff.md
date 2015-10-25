<h2>Description</h2>

<p>Calculates the difference between the value of a quantity in one point and the value of the<br>
same quantity in another point across a basin.<br>
</p>
<br>
<br>
<h3>Inputs</h3>
<ol>
<li> The GridCoverage of the drainage directions, obtained with <a href='Markoutlets.md'>Markoutlets</a>);</li>
<li> The !Gridcoverage containing the date on which estimating the difference;</li>
<li> The !Gridcoverage containing the quantity of which calculating the difference;</li>
</ol>
<br>
<br>
<h3>Output</h3>
<ol>
<li> The GridCoverage with the differences;</li>
</ol>
<br>
<br>
<h3>Notes</h3>
<p>
The points in which calculating the difference are<br>
individuated by an opportune matrix. Typically this matrix could contain the values of the Strahler<br>
numbers of a net, i.e. the network pixels are labeled by the stream number and the same stream<br>
contains a group of subsequent pixel. The points chosen for the calculation of the difference are<br>
the ﬁrst and the last of any stream, i.e. those in which the numeration changes.<br>
<blockquote></p>
<p>
If the matrix of the quantity to calculate is that of elevations, then, again in the case shown, netdiff calculates the elevation<br>
difference along a Strahler branch. If instead of the ﬁle containing the Strahler numeration the matrix<br>
of the magnitude is used, the variation of a quantity in a link is measured.<br>
</p>
<br>
<br>
<h3>References</h3>
<ul>
<li> <a href='Bibliography#8,.md'>8</a> I. Rodriguez-Iturbe, 1997</li>
<li> <a href='Bibliography#9,.md'>9</a> M.J. Woldenborg, 1982</li>
</ul></blockquote>


<h2>General Information</h2>

<blockquote>Module status: CERTIFIED</blockquote>

<blockquote>Name to use in a script: <b>netdiff</b></blockquote>

<blockquote>Authors: Daniele Andreis, Erica Ghesla, Antonello Andrea, Cozzini Andrea, Franceschi Silvia, Pisoni Silvano, Rigon Riccardo</blockquote>

<blockquote>Contacts:</blockquote>

<blockquote>License: GPL3</blockquote>

<blockquote>Keywords: Network, Pitfiller, DrainDir, FlowDirections</blockquote>


<h2>Parameters</h2>

<h3>Input parameters</h3>
<table cellpadding='10' width='70%' border='1'>
<tr>
<td width='50%'> <b>inFlow</b> </td><td width='50%'> The map of flowdirections. </td>
</tr>
<tr>
<td width='50%'> <b>inStream</b> </td><td width='50%'> The map of the stream. </td>
</tr>
<tr>
<td width='50%'> <b>inRaster</b> </td><td width='50%'> The map of to evaluate the difference. </td>
</tr>
</table>

<h3>Output parameters</h3>
<table cellpadding='10' width='70%' border='1'>
<tr>
<td width='50%'> <b>outDiff</b> </td><td width='50%'> The map of difference. </td>
</tr>
</table>

<h2>Example result</h2>

<img src='http://wiki.jgrasstools.googlecode.com/git/images/hortonmachine/netdiff.png' alt='NetDiff' />
<br>