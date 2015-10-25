<h2>Description</h2>

An utility to create the input for trentoP.

<p>
The aim of this class is to create the input FeatureCollection for the TrentoP models.<br>
</p>
<p>
It can generate several Feature: the input for TrentoP for the project mode (empty feature) or calibration mode<br>
(empty or create from another output simulation featureCollection), and a Polygon FeatureCollection which can contains the areas to associate to the input file.<br>
</p>


<h2>General Information</h2>

> Module status: DRAFT

> Authors: Daniele Andreis

> Contacts:

> License: http://www.gnu.org/licenses/gpl-3.0.html

> Keywords: TrentoP


<h2>Parameters</h2>

<h3>Input parameters</h3>
<table cellpadding='10' width='70%' border='1'>
<tr>
<td width='50%'> <b>inFolder</b> </td><td width='50%'> The folder into which to create the base files. </td>
</tr>
<tr>
<td width='50%'> <b>pMode</b> </td><td width='50%'> If it is 0 then create a project file (default mode), if 1 create the calibration shp. </td>
</tr>
<tr>
<td width='50%'> <b>doFromold</b> </td><td width='50%'> If it is true then generate it from an old output file. </td>
</tr>
<tr>
<td width='50%'> <b>pCode</b> </td><td width='50%'> The code defining the coordinate reference system, composed by authority and code number (ex. EPSG:4328). </td>
</tr>
<tr>
<td width='50%'> <b>pNetname</b> </td><td width='50%'> The optional name of the shapefile. </td>
</tr>
<tr>
<td width='50%'> <b>pOldVector</b> </td><td width='50%'> The output vector of TrentoP. It's a geosewer network. </td>
</tr>
<tr>
<td width='50%'> <b>pShapeAreeName</b> </td><td width='50%'> The optional name of the shapefile. By default it is aree.shp </td>
</tr>
</table>


<h2>Example result</h2>

<img src='http://wiki.jgrasstools.googlecode.com/git/images/hortonmachine/trentopprojectfilesgenerator.png' alt='TrentoPProjectFilesGenerator' />
<br>