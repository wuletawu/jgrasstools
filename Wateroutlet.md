<h2>Description</h2>

Generates a watershed basin from a drainage direction map and a set of coordinates representing the outlet point of watershed.
<br>
<br>
<h3>Inputs</h3>
<ul>
<li>the map containing the drainage directions (obtained with Markoutlets, DrainDir, FlowDirections)</li>
<li>the coordinates of the water outlet (east and north)</li>
<li>the map containing the channel network (obtained with ExtractNetwork)</li>
</ul>
<br>
<br>
<h3>Output</h3>
<ul>
<li>the basin extracted mask (basin)</li>
</ul>
<br>
<br>
<h3>Notes</h3>
The most important thing in this module is to choose a good water outlet. If the coordinates are unknown click with the mouse on the network map ensuring to select a pixel on the extracted network (value 2 in the network map).<br>
<br>
<br>
<h2>General Information</h2>

<blockquote>Module status: CERTIFIED</blockquote>

<blockquote>Name to use in a script: <b>wateroutlet</b></blockquote>

<blockquote>Authors: Andrea Antonello, US Army Construction Engineering Research Laboratory</blockquote>

<blockquote>Contacts: <a href='http://www.hydrologis.com'>http://www.hydrologis.com</a></blockquote>

<blockquote>License: General Public License Version 3 (GPLv3)</blockquote>

<blockquote>Keywords: Dem manipulation, Geomorphology, FlowDirections</blockquote>


<h2>Parameters</h2>

<h3>Input parameters</h3>
<table cellpadding='10' width='70%' border='1'>
<tr>
<td width='50%'> <b>pNorth</b> </td><td width='50%'> The northern coordinate of the watershed outlet. </td>
</tr>
<tr>
<td width='50%'> <b>pEast</b> </td><td width='50%'> The eastern coordinate of the watershed outlet. </td>
</tr>
<tr>
<td width='50%'> <b>inFlow</b> </td><td width='50%'> The map of flowdirections. </td>
</tr>
</table>

<h3>Output parameters</h3>
<table cellpadding='10' width='70%' border='1'>
<tr>
<td width='50%'> <b>outBasin</b> </td><td width='50%'> The extracted basin mask. </td>
</tr>
<tr>
<td width='50%'> <b>outArea</b> </td><td width='50%'> The area of the extracted basin. </td>
</tr>
</table>

<h2>Example result</h2>

<img src='http://wiki.jgrasstools.googlecode.com/git/images/hortonmachine/wateroutlet.png' alt='Wateroutlet' />
<br>
<h2>Developer example</h2>

An example usage of the algorithm can be found in the testcases suite:<br>
<a href='http://code.google.com/p/jgrasstools/source/browse/hortonmachine/src/test/java/org/jgrasstools/hortonmachine/models/hm/TestWateroutlet.java'>Wateroutlet</a>