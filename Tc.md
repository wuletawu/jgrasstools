<h2>Description</h2>

The Tc module subdivides the sites of a basin in the 9 topographic classes identified by the
longitudinal and transversal curvatures.
<br>
<br>
<h3>Inputs</h3>
<ul>
<br>
<br>
<LI><br>
<br>
The GridCoverage containing with the longitudinal curvatures;<br>
<br>
</LI><br>
<br>
<br>
<br>
<br>
<LI><br>
<br>
The GridCoverage containing with the normal curvatures;<br>
<br>
</LI><br>
<br>
<br>
<br>
<br>
<LI><br>
<br>
The threshold value for the longitudinal curvatures;<br>
<br>
</LI><br>
<br>
<br>
<br>
<br>
<LI><br>
<br>
The threshold value for the normal curvatures;<br>
<br>
</LI><br>
<br>
<br>
</ul>
<br>
<br>
<h3>Output</h3>
The program produces two different output matrixes, one with the 9 classes schematized conventionally in the following way:<br>
<br>
<br>
<UL><br>
<br>
<br>
<br>
<br>
<LI><br>
<br>
10 planar -planar sites <br>
<br>
</LI><br>
<br>
<br>
<br>
<br>
<LI><br>
<br>
20 convex-planar sites <br>
<br>
</LI><br>
<br>
<br>
<br>
<br>
<LI><br>
<br>
30 concave- planar sites <br>
<br>
</LI><br>
<br>
<br>
<br>
<br>
<LI><br>
<br>
40 planar- convex sites <br>
<br>
</LI><br>
<br>
<br>
<br>
<br>
<LI><br>
<br>
50 convex-convex sites <br>
<br>
</LI><br>
<br>
<br>
<br>
<br>
<LI><br>
<br>
60 concave-convex sites <br>
<br>
</LI><br>
<br>
<br>
<br>
<br>
<LI><br>
<br>
70 planar-concave sites <br>
<br>
</LI><br>
<br>
<br>
<br>
<br>
<LI><br>
<br>
80 convex-concave sites <br>
<br>
</LI><br>
<br>
<br>
<br>
<br>
<LI><br>
<br>
90 concave-concave sites. <br>
<br>
</LI><br>
<br>
<br>
<br>
<br>
</UL><br>
<br>
<br>
The second output file contains an aggregation of these classes in the three fundamentals (concave, convex and planar sites),<br>
indexed as follows:<br>
<br>
<br>
<UL><br>
<br>
<br>
<br>
<br>
<LI><br>
<br>
15 concave sites (classes 30,70, 90) <br>
<br>
</LI><br>
<br>
<br>
<br>
<br>
<LI><br>
<br>
25 planar sites (class 10) <br>
<br>
</LI><br>
<br>
<br>
<br>
<br>
<LI><br>
<br>
35 convex sites (classes 20, 40, 50, 60, 80). <br>
<br>
</LI><br>
<br>
<br>
<br>
<br>
</UL><br>
<br>
<br>
<br>
<br>
<h3>References</h3>
<ul>
<li><a href='Bibliography#17,.md'>17</a>,  A. Parsons, 1988</li>
</ul>
<br>
<br>


<h2>General Information</h2>

<blockquote>Module status: CERTIFIED</blockquote>

<blockquote>Name to use in a script: <b>tc</b></blockquote>

<blockquote>Authors: Erica Ghesla, Antonello Andrea, Cozzini Andrea, Franceschi Silvia, Pisoni Silvano, Rigon Riccardo</blockquote>

<blockquote>Contacts: <a href='http://www.hydrologis.com'>http://www.hydrologis.com</a>, <a href='http://www.ing.unitn.it/dica/hp/?user=rigon'>http://www.ing.unitn.it/dica/hp/?user=rigon</a></blockquote>

<blockquote>License: General Public License Version 3 (GPLv3)</blockquote>

<blockquote>Keywords: Hillslope, Curvatures</blockquote>


<h2>Parameters</h2>

<h3>Input parameters</h3>
<table cellpadding='10' width='70%' border='1'>
<tr>
<td width='50%'> <b>inProf</b> </td><td width='50%'> The longitudinal curvatures raster. </td>
</tr>
<tr>
<td width='50%'> <b>inTan</b> </td><td width='50%'> The normal curvatures raster. </td>
</tr>
<tr>
<td width='50%'> <b>pProfthres</b> </td><td width='50%'> The threshold value for the longitudinal curvatures. </td>
</tr>
<tr>
<td width='50%'> <b>pTanthres</b> </td><td width='50%'> The threshold value for the normal curvaturess. </td>
</tr>
</table>

<h3>Output parameters</h3>
<table cellpadding='10' width='70%' border='1'>
<tr>
<td width='50%'> <b>outTc9</b> </td><td width='50%'> The map of 9 topographic classes. </td>
</tr>
<tr>
<td width='50%'> <b>outTc3</b> </td><td width='50%'> The map of 3 aggregated fundamental topographic classes. </td>
</tr>
</table>

<h2>Example result</h2>

<img src='http://wiki.jgrasstools.googlecode.com/git/images/hortonmachine/tc.png' alt='Tc' />
<br>
<h2>Developer example</h2>

An example usage of the algorithm can be found in the testcases suite:<br>
<a href='http://code.google.com/p/jgrasstools/source/browse/hortonmachine/src/test/java/org/jgrasstools/hortonmachine/models/hm/TestTc.java'>Tc</a>