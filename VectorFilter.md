<h2>Description</h2>

Module that creates a subset of a vector based on a filtered vector.
<br>
The filter uses the <i>ECQL</i> or <i>CQL</i> language, please refer to the <a href='http://udig.refractions.net/confluence/display/EN/Common+Query+Language'> uDig user manual </a> or the <a href='http://docs.codehaus.org/display/GEOTDOC/03+ECQL+Examples#03ECQLExamples-Expression'> GeoTools documentation </a> for more informations about the syntax and usability of the language.<br>
<br>
<br>
<h3>Inputs</h3>
<ul>
<li>the vector to filter</li>
<li>the <i>ECQL</i> filter function</li>
</ul>
<br>
<br>
<h3>Output</h3>
<ul>
<li>the filtered vector</li>
</ul>


<h2>General Information</h2>

<blockquote>Module status: CERTIFIED</blockquote>

<blockquote>Name to use in a script: <b>vfilter</b></blockquote>

<blockquote>Authors: Andrea Antonello</blockquote>

<blockquote>Contacts: <a href='http://www.hydrologis.com'>http://www.hydrologis.com</a></blockquote>

<blockquote>License: General Public License Version 3 (GPLv3)</blockquote>

<blockquote>Keywords: Filter, Vector, VectorReshaper</blockquote>


<h2>Parameters</h2>

<h3>Input parameters</h3>
<table cellpadding='10' width='70%' border='1'>
<tr>
<td width='50%'> <b>inVector</b> </td><td width='50%'> The vector to filter. </td>
</tr>
<tr>
<td width='50%'> <b>pCql</b> </td><td width='50%'> The ECQL filter function. </td>
</tr>
</table>

<h3>Output parameters</h3>
<table cellpadding='10' width='70%' border='1'>
<tr>
<td width='50%'> <b>outVector</b> </td><td width='50%'> The filtered vector. </td>
</tr>
</table>

<h2>Developer example</h2>

An example usage of the algorithm can be found in the testcases suite:<br>
<a href='http://code.google.com/p/jgrasstools/source/browse/jgrassgears/src/test/java/org/jgrasstools/gears/modules/TestVectorFilter.java'>VectorFilter</a>