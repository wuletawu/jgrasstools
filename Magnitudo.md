<h2>Description</h2>

<p>Calculates the magnitude of a basin, deﬁned as the number of sources upriver with respect<br>
to every point.</p>
<br>
<br>
<h3>Inputs</h3>
<ol>
<li>The GridCoverage with the drainage directions, obtained with <a href='Markoutlets.md'>Markoutlets</a></li>
</ol>
<br>
<br>
<h3>Output</h3>
<ol>
<li>The GridCoverage containing the matrix of the basin magnitude</li>
</ol>
<br>
<br>
<h3>Notes</h3>
<p> If the river net is a trifurcated tree (a node in which three channels enter and one exits),<br>
then between number of springs and channels there exists a bijective correspondence hc = 2ns − 1<br>
where <i>hc</i> is the number of channels and <i>ns</i> the number of sources; the magnitude is then also an<br>
indicator of the contributing area.</p>
<br>
<br>
<h3>References</h3>
<ul>
<li><a href='Bibliography#9,.md'>9</a> M.J. Woldenborg,1982</li>
<li><a href='Bibliography#8,.md'>8</a> I. Rodriguez-Iturbe, 1997</li>
<li> <a href='Bibliography#10,.md'>10</a> J.S. Smart, 1976</li>
<li> <a href='Bibliography#11,.md'>11</a> J.S. Smart, 1976</li>
<li> <a href='Bibliography#12,.md'>12</a> R.L. Shreve, 1966</li>
<li> <a href='Bibliography#13,.md'>13</a> R.L. Shreve, 1967</li>
<li> <a href='Bibliography#14,.md'>14</a> W.R. James, 1969</li>
</ul>


<h2>General Information</h2>

<blockquote>Module status: CERTIFIED</blockquote>

<blockquote>Name to use in a script: <b>magnitudo</b></blockquote>

<blockquote>Authors: Erica Ghesla - erica.ghesla@ing.unitn.it, Antonello Andrea, Cozzini Andrea, Franceschi Silvia, Pisoni Silvano, Rigon Riccardo</blockquote>

<blockquote>Contacts:</blockquote>

<blockquote>License: GPL3</blockquote>


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
<td width='50%'> <b>outMag</b> </td><td width='50%'> The map of magnitudo. </td>
</tr>
</table>

<h2>Example result</h2>

<img src='http://wiki.jgrasstools.googlecode.com/git/images/hortonmachine/magnitudo.png' alt='Magnitudo' />
<br>
<h2>Developer example</h2>

An example usage of the algorithm can be found in the testcases suite:<br>
<a href='http://code.google.com/p/jgrasstools/source/browse/hortonmachine/src/test/java/org/jgrasstools/hortonmachine/models/hm/TestMagnitudo.java'>Magnitudo</a>