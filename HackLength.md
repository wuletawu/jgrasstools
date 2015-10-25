<h2>Description</h2>

Calculates the Hack quantities, namely, assigned a point in a basin, the projection on the plane of the distance, or the 3d distance, from the watershed measured along the network (until it exists) and then, proceeding again from valley upriver, along the maximal slope lines.
<br>
<br>
<h3>Inputs</h3>
<ul>
<li>the GridCoverage containing the drainage directions (obtained with Markoutlets, DrainDir)</li>
<li>the GridCoverage containing the total contributing areas (obtained<br>
with <a href='DrainDir.md'>DrainDir</a>, <a href='Tca.md'>Tca</a> or <a href='Multitca.md'>Multitca</a>)</li>
<li>the GridCoverage containing the elevation (obtained with <a href='Pitfiller.md'>Pitfiller</a>). It can be null.</li>
</ul>
<br>
<br>
<h3>Output</h3>
<ul>
<li>the GridCoverage containing the matrix of the Hack distances</li>
</ul>
<br>
<br>
<h3>Notes</h3>
<p>
If the elevation GridCoverage is null then the models run in 2d mode, othervise it runs in 3d mode.<br>
</p>
<p>
For each network confluence, the direction of the tributary with maximal contributing area is chosen. If the tributaries have the same area, one of the two directions is chosen at random.<br>
</p>
<br>
<br>
<h3>References</h3>
<ul>
<li><a href='Bibliography#6,.md'>6</a> J.T.Hack,1947</li>
<li><a href='Bibliography#7,.md'>7</a> Rigon R.,1996</li>
<li><a href='Bibliography#8,.md'>8</a> I. Rodriguez-Iturbe, 1997</li>
</ul>
<br>
<br>


<h2>General Information</h2>

<blockquote>Module status: CERTIFIED</blockquote>

<blockquote>Name to use in a script: <b>hacklength</b></blockquote>

<blockquote>Authors: Daniele Andreis, Antonello Andrea, Erica Ghesla, Cozzini Andrea, Franceschi Silvia, Pisoni Silvano, Rigon Riccardo</blockquote>

<blockquote>Contacts: <a href='http://www.hydrologis.com'>http://www.hydrologis.com</a>, <a href='http://www.ing.unitn.it/dica/hp/?user=rigon'>http://www.ing.unitn.it/dica/hp/?user=rigon</a></blockquote>

<blockquote>License: General Public License Version 3 (GPLv3)</blockquote>

<blockquote>Keywords: Network, HackLength3D, HackStream</blockquote>


<h2>Parameters</h2>

<h3>Input parameters</h3>
<table cellpadding='10' width='70%' border='1'>
<tr>
<td width='50%'> <b>inElevation</b> </td><td width='50%'> The map of the depitted elevation. It's null if it work in 2d. </td>
</tr>
<tr>
<td width='50%'> <b>inFlow</b> </td><td width='50%'> The map of flowdirections. </td>
</tr>
<tr>
<td width='50%'> <b>inTca</b> </td><td width='50%'> The map of tca. </td>
</tr>
</table>

<h3>Output parameters</h3>
<table cellpadding='10' width='70%' border='1'>
<tr>
<td width='50%'> <b>outHacklength</b> </td><td width='50%'> The map of hack lengths. </td>
</tr>
</table>

<h2>Example result</h2>

<img src='http://wiki.jgrasstools.googlecode.com/git/images/hortonmachine/hacklength.png' alt='HackLength' />
<br>
<h2>Developer example</h2>

An example usage of the algorithm can be found in the testcases suite:<br>
<a href='http://code.google.com/p/jgrasstools/source/browse/hortonmachine/src/test/java/org/jgrasstools/hortonmachine/models/hm/TestHackLength.java'>HackLength</a>