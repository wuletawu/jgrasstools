<h2>Description</h2>

Subdivides the sites of a basin in 11 topographic classes, nine of which are deﬁned according to the program TC.
<p>
Such classes are the nine classes based  obtained with<br>
<a href='Tc.md'>Tc</a> ; the points belonging to the channel networks constitute a tenth class (derived from the use of<br>
ExtractNetwork), the points with high slope (higher than a critical angle) the eleventh class.<br>
</p>
<br>
<br>
<h3>Inputs</h3>
<ol>
<li>The GridCoverage containing the slopes, obtained with <a href='Slope.md'>Slope</a> or <a href='Gradient.md'>Gradient</a>;</li>
<li>The GridCoverage containing the channel network, obtained with <a href='ExtractNetwork.md'>ExtractNetwork</a>;</li>
<li>The GridCoverage containing the subdivisions in curvature classes, obtained with <a href='Tc.md'>Tc</a>;</li>
</ol>
<br>
<br>
<h3>Outputs</h3>
<ol>
<li>The GridCoverage containing the subdivision in the 11 predeﬁned classes;</li>
<li>The GridCoverage  of the aggregated classes (hillslope, valleys and net);</li>
</ol>
<br>
<br>
<h3>Notes</h3>
<p>
Differently from the program TC, the program GC considers also the existence of the channel net,<br>
which is extracted from the DEM. The channel net is thought as a topologically connected network,<br>
even though it is known that this cannot be the real case.<br>
</p>
<p> The cases are identiﬁed as in TC plus:<br>
<ul>
<li> 100 → channel sites (individuated by extract network)</li>
<li> 110 → unconditionally unstable sites (slope > critic value)</li>
</ul>
</p>
<p>
The second output ﬁle contains an aggregation of these classes in the four fundamentals, indexed as<br>
follows:<br>
<ol>
<li> 15 → non-channeled valley sites (classi 70, 90, 30 )</li>
<li> 25 → planar sites (classi 10)</li>
<li> 35 → channel sites (classe 100)</li>
<li> 45 → hillslope sites (classi 20, 40, 50, 60, 80)</li>
</ol>
</p>
<br>
<br>
<h3>References</h3>
<ul>
<li><a href='Bibliography#17,.md'>17</a> A. Parsons, 1988</li>
<li><a href='Bibliography#18,.md'>18</a> R. Suzuki, 1977</li>
</ul>


<h2>General Information</h2>

<blockquote>Module status: CERTIFIED</blockquote>

<blockquote>Name to use in a script: <b>gc</b></blockquote>

<blockquote>Authors: Daniele Andreis,Erica Ghesla, Cozzini Andrea, Rigon Riccardo</blockquote>

<blockquote>Contacts:</blockquote>

<blockquote>License: General Public License Version 3 (GPLv3)</blockquote>

<blockquote>Keywords: Geomorphology, Tc, Slope, ExtractNetwork</blockquote>


<h2>Parameters</h2>

<h3>Input parameters</h3>
<table cellpadding='10' width='70%' border='1'>
<tr>
<td width='50%'> <b>inSlope</b> </td><td width='50%'> The map of the slope </td>
</tr>
<tr>
<td width='50%'> <b>inNetwork</b> </td><td width='50%'> The map with the network </td>
</tr>
<tr>
<td width='50%'> <b>inCp9</b> </td><td width='50%'> The map with the Thopological classes cp9 </td>
</tr>
<tr>
<td width='50%'> <b>pTh</b> </td><td width='50%'> The gradient formula mode (0 = finite differences, 1 = horn, 2 = evans). </td>
</tr>
</table>

<h3>Output parameters</h3>
<table cellpadding='10' width='70%' border='1'>
<tr>
<td width='50%'> <b>outClasses</b> </td><td width='50%'> The map with the geomorphological classes </td>
</tr>
<tr>
<td width='50%'> <b>outAggregateClasses</b> </td><td width='50%'> The map with the geomorphological classes </td>
</tr>
</table>

<h2>Example result</h2>

<img src='http://wiki.jgrasstools.googlecode.com/git/images/hortonmachine/gc.png' alt='Gc' />
<br>
<h2>Developer example</h2>

An example usage of the algorithm can be found in the testcases suite:<br>
<a href='http://code.google.com/p/jgrasstools/source/browse/hortonmachine/src/test/java/org/jgrasstools/hortonmachine/models/hm/TestGc.java'>Gc</a>