<h2>Description</h2>

Module for merging vecotrs into one single.
<br>
The vectors to merge have to have the same attribute table, in this case all the features will be put together into the new vector updating also the attribute table.<br>
<br>
<br>
<h3>Inputs</h3>
<ul>
<li>the input vectors to be merged, a list of vectors comma separated</li>
</ul>
<br>
<br>
<h3>Output</h3>
<ul>
<li>the output merged vector</li>
</ul>


<h2>General Information</h2>

<blockquote>Module status: CERTIFIED</blockquote>

<blockquote>Name to use in a script: <b>vmerge</b></blockquote>

<blockquote>Authors: Andrea Antonello</blockquote>

<blockquote>Contacts: <a href='http://www.hydrologis.com'>http://www.hydrologis.com</a></blockquote>

<blockquote>License: General Public License Version 3 (GPLv3)</blockquote>

<blockquote>Keywords: IO, Feature, Vector, Merge</blockquote>


<h2>Parameters</h2>

<h3>Input parameters</h3>
<table cellpadding='10' width='70%' border='1'>
<tr>
<td width='50%'> <b>inVectors</b> </td><td width='50%'> The input vectors to be merged. </td>
</tr>
</table>

<h3>Output parameters</h3>
<table cellpadding='10' width='70%' border='1'>
<tr>
<td width='50%'> <b>outVector</b> </td><td width='50%'> The output vector. </td>
</tr>
</table>

<h2>Developer example</h2>

An example usage of the algorithm can be found in the testcases suite:<br>
<a href='http://code.google.com/p/jgrasstools/source/browse/jgrassgears/src/test/java/org/jgrasstools/gears/modules/TestVectorMerger.java'>VectorMerger</a>