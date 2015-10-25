<h2>Description</h2>

Module to reshape vectors. The reshape operation includes the
possibility to:
<ul>
<blockquote><li>add one or more new columns to the vector table attribute</li>
<li>convert the geometry into a derived geometry (from polygons to<br>
points or to lines)</li>
<li>delete from the vector table attribute</li>
</ul>
<br>
The reshape uses the <i>ECQL</i> language, please refer to the <a href='http://udig.refractions.net/confluence/display/EN/Common+Query+Language'>
uDig user manual </a> or the <a href='http://docs.geotools.org/latest/userguide/library/cql/cql.html'>
GeoTools documentation </a> for more informations about the syntax and<br>
usability of the language.<br>
<br>
<br>
<b>Geometry changing examples:</b>
<br>
To create a centroid layer from a polygon layer use:<br>
<br>
</blockquote><blockquote>the_geom=centroid(the_geom)<br>
<br>
To create a buffer of 20 meters from a points layer use:<br>
<br>
the_geom=buffer(the_geom, 20.0)<br>
<br>
To create a convex hull from a points layer use:<br>
<br>
the_geom=convexHull(the_geom)<br>
<br>
<b>Other examples:</b>
<br>
To create a two new field containing the perimeter and area of the<br>
polygons in a layer:<br>
<br>
area=area(the_geom)<br>
length=geomLength(the_geom)<br>
<br>
This is also the perfect way to create a new column in a shapefile<br>
layer and assign it a new default value:<br>
<br>
newfield=-1<br>
<br>
<br>
<h3>Inputs</h3>
<ul>
<blockquote><li>the vector to reshape</li>
<li>the ECQL reshape function</li>
<li>the list of fields to remove, comma separated</li>
</ul>
<br>
<br>
<h3>Output</h3>
<ul>
<li>the new derived vector</li>
</ul></blockquote></blockquote>


<h2>General Information</h2>

<blockquote>Module status: CERTIFIED</blockquote>

<blockquote>Name to use in a script: <b>reshape</b></blockquote>

<blockquote>Authors: Andrea Antonello, Jody Garnett</blockquote>

<blockquote>Contacts: <a href='http://www.hydrologis.com'>http://www.hydrologis.com</a></blockquote>

<blockquote>License: General Public License Version 3 (GPLv3)</blockquote>

<blockquote>Keywords: Reshape, Vector, VectorFilter</blockquote>


<h2>Parameters</h2>

<h3>Input parameters</h3>
<table cellpadding='10' width='70%' border='1'>
<tr>
<td width='50%'> <b>inVector</b> </td><td width='50%'> The vector to reshape. </td>
</tr>
<tr>
<td width='50%'> <b>pCql</b> </td><td width='50%'> The ECQL reshape function. </td>
</tr>
<tr>
<td width='50%'> <b>pRemove</b> </td><td width='50%'> The list of fields to remove, comma separated. </td>
</tr>
</table>

<h3>Output parameters</h3>
<table cellpadding='10' width='70%' border='1'>
<tr>
<td width='50%'> <b>outVector</b> </td><td width='50%'> The new reshaped vector. </td>
</tr>
</table>

<h2>Developer example</h2>

An example usage of the algorithm can be found in the testcases suite:<br>
<a href='http://code.google.com/p/jgrasstools/source/browse/jgrassgears/src/test/java/org/jgrasstools/gears/modules/TestVectorReshaper.java'>VectorReshaper</a>