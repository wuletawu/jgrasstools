<h2>Description</h2>

Module for GRASS raster patching. Patches a set on input rasters into one single GRASS raster.
<br>
<br>
<h3>Inputs</h3>
<ul>
<li>the list of maps that have to be patched (used if inGeodata is null)</li>
<li>the output file resolution in meters</li>
<li>the optional requested boundary coordinates as array of (n, s, w, e)</li>
</ul>
<br>
<br>
<h3>Output</h3>
<ul>
<li>the GRASS file path to which to write to</li>
</ul>
<br>
<br>
<h3>Output</h3>
This module can be used instead of the Mosaic with big maps because it can work also with big data.<br>
<br>
<br>
<h2>General Information</h2>

<blockquote>Module status: UNKNOWN</blockquote>

<blockquote>Name to use in a script: <b>grassmosaic</b></blockquote>

<blockquote>Authors: Andrea Antonello</blockquote>

<blockquote>Contacts: <a href='http://www.hydrologis.com'>http://www.hydrologis.com</a></blockquote>

<blockquote>License: General Public License Version 3 (GPLv3)</blockquote>

<blockquote>Keywords: Mosaic, Raster</blockquote>


<h2>Parameters</h2>

<h3>Input parameters</h3>
<table cellpadding='10' width='70%' border='1'>
<tr>
<td width='50%'> <b>inFiles</b> </td><td width='50%'> The list of files that have to be patched (used if inGeodata is null). </td>
</tr>
<tr>
<td width='50%'> <b>pRes</b> </td><td width='50%'> The output file resolution in meters. </td>
</tr>
<tr>
<td width='50%'> <b>pBounds</b> </td><td width='50%'> The optional requested boundary coordinates as array of [n, s, w, e]. </td>
</tr>
<tr>
<td width='50%'> <b>outGrassFile</b> </td><td width='50%'> The GRASS file path to which to write to. </td>
</tr>
</table>

