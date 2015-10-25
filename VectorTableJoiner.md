<h2>Description</h2>

Module that joins attributes from one vector into another based on a common field. The second attribute table can be a <i>dbf</i> related to a shapefile or just a <i>dbf</i> data file.
<br>
The program will create a new vector file with the original and the new attributes fields.<br>
<br>
<br>
<h3>Inputs</h3>
<ul>
<li>the vector to extend</li>
<li>the dbf tabledata to merge in</li>
<li>the common field used for joining the tables. If the name is different in the two sources, then write the two commaseparated, first the one of the shapefile, then the dbf field name</li>
<li>the commaseparated list of fields to merge in: it is possible to merge all the dbf table or just a selected set of them</li>
</ul>
<br>
<br>
<h3>Output</h3>
<ul>
<li>the modified joined vector</li>
</ul>


<h2>General Information</h2>

<blockquote>Module status: CERTIFIED</blockquote>

<blockquote>Name to use in a script: <b>vjoin</b></blockquote>

<blockquote>Authors: Andrea Antonello</blockquote>

<blockquote>Contacts: <a href='http://www.hydrologis.com'>http://www.hydrologis.com</a></blockquote>

<blockquote>License: General Public License Version 3 (GPLv3)</blockquote>

<blockquote>Keywords: Join, VectorFieldRounder</blockquote>


<h2>Parameters</h2>

<h3>Input parameters</h3>
<table cellpadding='10' width='70%' border='1'>
<tr>
<td width='50%'> <b>inVector</b> </td><td width='50%'> The vector to extend. </td>
</tr>
<tr>
<td width='50%'> <b>tabledata</b> </td><td width='50%'> The dbf tabledata to merge in. </td>
</tr>
<tr>
<td width='50%'> <b>fCommon</b> </td><td width='50%'> The common field (if different in the two sources, commaseparated, first shapefile, then dbf. </td>
</tr>
<tr>
<td width='50%'> <b>pFields</b> </td><td width='50%'> The commaseparated list of fields to merge in. </td>
</tr>
</table>

<h3>Output parameters</h3>
<table cellpadding='10' width='70%' border='1'>
<tr>
<td width='50%'> <b>outVector</b> </td><td width='50%'> The joined vector. </td>
</tr>
</table>

<h2>Developer example</h2>

An example usage of the algorithm can be found in the testcases suite:<br>
<a href='http://code.google.com/p/jgrasstools/source/browse/jgrassgears/src/test/java/org/jgrasstools/gears/modules/TestVectorTableJoiner.java'>VectorTableJoiner</a>