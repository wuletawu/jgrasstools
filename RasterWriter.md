<h2>Description</h2>

Raster writer module. Supported raster formats are:
<ul>
<li>ESRI asci</li>
<li>GRASS binary format</li>
<li>tiff</li>
</ul>
The model recognize the raster type from the file extension, if you are not using a conventional extension you can force the program to write that format simply specifying the <i>type</i>.
<br>
<br>
<h3>Parameters</h3>
<ul>
<li>the raster map to write</li>
<li>the raster type to write: supported are: asc, tiff, grass</li>
<li>the file to write the raster to</li>
</ul>


<h2>General Information</h2>

<blockquote>Module status: CERTIFIED</blockquote>

<blockquote>Name to use in a script: <b>rasterwriter</b></blockquote>

<blockquote>Authors: Andrea Antonello</blockquote>

<blockquote>Contacts: <a href='http://www.hydrologis.com'>http://www.hydrologis.com</a></blockquote>

<blockquote>License: General Public License Version 3 (GPLv3)</blockquote>

<blockquote>Keywords: IO, Grass, Coverage, Raster, Writing</blockquote>


<h2>Parameters</h2>

<h3>Input parameters</h3>
<table cellpadding='10' width='70%' border='1'>
<tr>
<td width='50%'> <b>inRaster</b> </td><td width='50%'> The raster map to write. </td>
</tr>
<tr>
<td width='50%'> <b>file</b> </td><td width='50%'> The file to write the raster to with extension (supported are: asc, tiff, grass). </td>
</tr>
</table>


<h2>Developer example</h2>

An example usage of the algorithm can be found in the testcases suite:<br>
<a href='http://code.google.com/p/jgrasstools/source/browse/jgrassgears/src/test/java/org/jgrasstools/gears/modules/TestRasterWriter.java'>RasterWriter</a>