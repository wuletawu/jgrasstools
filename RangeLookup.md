<h2>Description</h2>

Module for raster rangelookup usually used for raster reclassification.
<br>
The ranges has to be defined using brackets, and the lower and upper bounds of the range may be open or closed. If closed they may include their defining value or exclude it. For example:  in the form<br>
<font face='Symbol'>[</font>r1l<br>
r1h),<br>
<font face='Symbol'>[</font>r2l<br>
r2h<font face='Symbol'>]</font>.<br>
<br>
<br>
<h3>Inputs</h3>
<ul>
<li>the raster that has to be processed</li>
<li>the ranges in the form specified above</li>
<li>The classes to substitute in the same order of the ranges (in the form 1,2)</li>
</ul>
<br>
<br>
<h3>Output</h3>
<ul>
<li>the processed raster</li>
</ul>


<h2>General Information</h2>

<blockquote>Module status: CERTIFIED</blockquote>

<blockquote>Name to use in a script: <b>rrangelookup</b></blockquote>

<blockquote>Authors: Andrea Antonello</blockquote>

<blockquote>Contacts: <a href='http://www.hydrologis.com'>http://www.hydrologis.com</a></blockquote>

<blockquote>License: General Public License Version 3 (GPLv3)</blockquote>

<blockquote>Keywords: Raster, Rangelookup</blockquote>


<h2>Parameters</h2>

<h3>Input parameters</h3>
<table cellpadding='10' width='70%' border='1'>
<tr>
<td width='50%'> <b>inRaster</b> </td><td width='50%'> The raster that has to be processed. </td>
</tr>
<tr>
<td width='50%'> <b>pRanges</b> </td><td width='50%'> The ranges in the form <a href='r1l.md'>r1h),[r2l r2h</a> </td>
</tr>
<tr>
<td width='50%'> <b>pClasses</b> </td><td width='50%'> The classes to substitute in the same order of the ranges (in the form 1,2) </td>
</tr>
</table>

<h3>Output parameters</h3>
<table cellpadding='10' width='70%' border='1'>
<tr>
<td width='50%'> <b>outRaster</b> </td><td width='50%'> The processed raster. </td>
</tr>
</table>

<h2>Developer example</h2>

An example usage of the algorithm can be found in the testcases suite:<br>
<a href='http://code.google.com/p/jgrasstools/source/browse/jgrassgears/src/test/java/org/jgrasstools/gears/modules/TestRangeLookup.java'>RangeLookup</a>