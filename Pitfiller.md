<h2>Description</h2>

It fills the depression points present within a DEM so that
the drainage directions are defined in each point.
<br>
<br>
<h3>Inputs</h3>
<ul>
<li>the file containing the elevations</li>
</ul>
<br>
<br>
<h3>Output</h3>
<ul>
<li>the file containing the corrected elevations</li>
</ul>
<br>
<br>
<h3>Notes</h3>
The flooding algorithm (pitfiller) fills all pits present in the DEM.<br>
Obviously these could be real and not a product of gridding the landscape.<br>
In this case we should find a representation of the drainage<br>
directions considering also the possible lakes and ponds, which is not<br>
yet implemented.<br>
<br>
<br>
<h2>General Information</h2>

<blockquote>Module status: CERTIFIED</blockquote>

<blockquote>Name to use in a script: <b>pit</b></blockquote>

<blockquote>Authors: David Tarboton, Andrea Antonello</blockquote>

<blockquote>Contacts: <a href='http://www.neng.usu.edu/cee/faculty/dtarb/tardem.html#programs'>http://www.neng.usu.edu/cee/faculty/dtarb/tardem.html#programs</a>, <a href='http://www.hydrologis.com'>http://www.hydrologis.com</a></blockquote>

<blockquote>License: General Public License Version 3 (GPLv3)</blockquote>

<blockquote>Keywords: Dem manipulation, Geomorphology, DrainDir</blockquote>


<h2>Parameters</h2>

<h3>Input parameters</h3>
<table cellpadding='10' width='70%' border='1'>
<tr>
<td width='50%'> <b>inElev</b> </td><td width='50%'> The map of digital elevation model (DEM). </td>
</tr>
</table>

<h3>Output parameters</h3>
<table cellpadding='10' width='70%' border='1'>
<tr>
<td width='50%'> <b>outPit</b> </td><td width='50%'> The depitted elevation map. </td>
</tr>
</table>

<h2>Example result</h2>

<img src='http://wiki.jgrasstools.googlecode.com/git/images/hortonmachine/pitfiller.png' alt='Pitfiller' />
<br>
<h2>Developer example</h2>

An example usage of the algorithm can be found in the testcases suite:<br>
<a href='http://code.google.com/p/jgrasstools/source/browse/hortonmachine/src/test/java/org/jgrasstools/hortonmachine/models/hm/TestPitfiller.java'>Pitfiller</a>