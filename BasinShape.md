<h2>Description</h2>

Creates a vector map of the subbasins created with the Netnumbering module.
<br>
<br>
<h3>Inputs</h3>
<ul>
<li>the file containing the elevations (obtained with Pitfiller)</li>
<li>the file containing the extracted numbered subbasins for an area (obtained with Netnumbering)</li>
</ul>
<br>
<br>
<h3>Output</h3>
<ul>
<li>the file containing the extracted basins vector map</li>
</ul>
<br>
<br>
<h3>Notes</h3>
The program will add the number ID of each basin obtained in Netnumbering as an attribute in the vector map. Other calculated attributes are:<br>
<ul>
<li>area in m<sup>2</sup></li>
<li>perimeter in m</li>
<li>max elevation in m over the sea level</li>
<li>min elevation in m over the sea level</li>
<li>average elevation in m over the sea level</li>
<li>elevation of the centroid of the basin in m over the sea level</li>
</ul>


<h2>General Information</h2>

<blockquote>Module status: CERTIFIED</blockquote>

<blockquote>Name to use in a script: <b>basinshape</b></blockquote>

<blockquote>Authors: Erica Ghesla, Andrea Antonello</blockquote>

<blockquote>Contacts: <a href='http://www.hydrologis.com'>http://www.hydrologis.com</a></blockquote>

<blockquote>License: General Public License Version 3 (GPLv3)</blockquote>

<blockquote>Keywords: Basin, Geomorphology</blockquote>


<h2>Parameters</h2>

<h3>Input parameters</h3>
<table cellpadding='10' width='70%' border='1'>
<tr>
<td width='50%'> <b>inElev</b> </td><td width='50%'> The elevation map. </td>
</tr>
<tr>
<td width='50%'> <b>inBasins</b> </td><td width='50%'> The map of the numbered basins. </td>
</tr>
</table>

<h3>Output parameters</h3>
<table cellpadding='10' width='70%' border='1'>
<tr>
<td width='50%'> <b>outBasins</b> </td><td width='50%'> The extracted basins vector map. </td>
</tr>
</table>

<h2>Example result</h2>

<img src='http://wiki.jgrasstools.googlecode.com/git/images/hortonmachine/basinshape.png' alt='BasinShape' />
<br>
<h2>Developer example</h2>

An example usage of the algorithm can be found in the testcases suite:<br>
<a href='http://code.google.com/p/jgrasstools/source/browse/hortonmachine/src/test/java/org/jgrasstools/hortonmachine/models/hm/TestBasinShape.java'>BasinShape</a>