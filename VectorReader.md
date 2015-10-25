<h2>Description</h2>

Vectors features reader module. Supported vector formats are:
<ul>
<li>ESRI shapefile</li>
<li>Properties file</li>
</ul>
<br>
<p>Properties files have a header like:<br>
<br>
<pre><code>_=id:Integer,name:String,geom:LineString<br>
</code></pre>
<br>
and the data in format:<br>
<br>
<pre><code>fid1=1|testname|LINESTRING (0 0, 40 40, 40 0)<br>
</code></pre>
<br>
<h3>Parameters</h3>
<ul>
<li>the file path of the vector that has to be read</li>
<li>the vector <i>type</i> to read</li>
<li>the read collection of features</li>
</ul>


<h2>General Information</h2>

<blockquote>Module status: CERTIFIED</blockquote>

<blockquote>Name to use in a script: <b>vectorreader</b></blockquote>

<blockquote>Authors: Andrea Antonello</blockquote>

<blockquote>Contacts: <a href='http://www.hydrologis.com'>http://www.hydrologis.com</a></blockquote>

<blockquote>License: General Public License Version 3 (GPLv3)</blockquote>

<blockquote>Keywords: IO, Shapefile, Feature, Vector, Reading</blockquote>


<h2>Parameters</h2>

<h3>Input parameters</h3>
<table cellpadding='10' width='70%' border='1'>
<tr>
<td width='50%'> <b>pType</b> </td><td width='50%'> The vector type to read (Supported is: shp, properties). </td>
</tr>
<tr>
<td width='50%'> <b>file</b> </td><td width='50%'> The vector file to read. </td>
</tr>
</table>

<h3>Output parameters</h3>
<table cellpadding='10' width='70%' border='1'>
<tr>
<td width='50%'> <b>outVector</b> </td><td width='50%'> The read feature collection. </td>
</tr>
</table>

<h2>Developer example</h2>

An example usage of the algorithm can be found in the testcases suite:<br>
<a href='http://code.google.com/p/jgrasstools/source/browse/jgrassgears/src/test/java/org/jgrasstools/gears/modules/TestVectorReader.java'>VectorReader</a>