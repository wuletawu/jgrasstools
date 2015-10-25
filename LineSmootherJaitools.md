<h2>Description</h2>

The line smoother from the Jaitools project that uses the Bezier curve to smooth. More info on the algorithm are available in <a href='http://en.wikipedia.org/wiki/B%C3%A9zier_curve'> Wikipedia </a>
<br>
<br>
<h3>Inputs</h3>
<ul>
<li>the vector containing the lines to be smoothed</li>
<li>a value between 0 and 1 (inclusive) specifying the tightness of fit of the smoothed boundary (0 is loose - default)</li>
</ul>
<br>
<br>
<h3>Output</h3>
<ul>
<li>the vector with smoothed features</li>
</ul>


<h2>General Information</h2>

<blockquote>Module status: CERTIFIED</blockquote>

<blockquote>Name to use in a script: <b>linesmootherjai</b></blockquote>

<blockquote>Authors: Andrea Antonello</blockquote>

<blockquote>Contacts: <a href='http://www.hydrologis.com'>http://www.hydrologis.com</a></blockquote>

<blockquote>License: General Public License Version 3 (GPLv3)</blockquote>

<blockquote>Keywords: Smoothing, Vector</blockquote>


<h2>Parameters</h2>

<h3>Input parameters</h3>
<table cellpadding='10' width='70%' border='1'>
<tr>
<td width='50%'> <b>inVector</b> </td><td width='50%'> The vector containing the lines to be smoothed. </td>
</tr>
<tr>
<td width='50%'> <b>pAlpha</b> </td><td width='50%'> A value between 0 and 1 (inclusive) specifying the tightness of fit of the smoothed boundary (0 is loose). </td>
</tr>
</table>

<h3>Output parameters</h3>
<table cellpadding='10' width='70%' border='1'>
<tr>
<td width='50%'> <b>outVector</b> </td><td width='50%'> The smoothed features. </td>
</tr>
</table>

<h2>Developer example</h2>

An example usage of the algorithm can be found in the testcases suite:<br>
<a href='http://code.google.com/p/jgrasstools/source/browse/jgrassgears/src/test/java/org/jgrasstools/gears/modules/TestLineSmootherJaitools.java'>LineSmootherJaitools</a>