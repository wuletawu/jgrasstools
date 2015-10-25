<h2>Description</h2>

Calculates the histogram of a set of data contained in a matrix with respect to the set of data contained in another matrix. In substance, a map of R<sup>2</sup> to R<sup>2</sup>, in which each point of a bidimensional system (identified by the values contained in a matrix) is mapped in a second bidimensional system, is produced. The data of the first set are then grouped in a prefixed number of intervals and the mean value of the independent variable for each interval is calculated.
<br>
To every interval corresponds a certain set of values of the second set, of which the mean value is calculated, and a designate number of moments which can be either centred, if the functioning mode is <i>histogram</i>, or non-centred, if the mode is 'moments'.<br>
<br>
If the number of intervals assigned is lesser than one, the data are subdivided in classes of data having the same abscissa.<br>
<br>
<br>
<h3>Inputs</h3>
<ul>
<li>file containing the data of the independent variable (map1)</li>
<li>file containing the data which will be used as dependent variable (map2)</li>
</ul>
<br>
<br>
<h3>Output</h3>
<ul>
<li>the name of the output file with the elaborations</li>
</ul>
<br>
<br>
<h3>Notes</h3>
The output file is not a map and contains:<br>
<ul>
<li>the number of elements in each interval</li>
<li>the mean value of the data in abscissa</li>
<li>the mean value of the data in ordinate</li>
<li>the n-esimal moment of the data in ordinate</li>
</ul>
The program uses the memory intensely. Therefore if we decide to have so many intervals as the data in abscissa, the program could not function correctly.<br>
<br>
<br>
<h2>General Information</h2>

<blockquote>Module status: CERTIFIED</blockquote>

<blockquote>Name to use in a script: <b>cb</b></blockquote>

<blockquote>Authors: Andrea Antonello, Silvia Franceschi, Rigon Riccardo</blockquote>

<blockquote>Contacts: <a href='http://www.hydrologis.com'>http://www.hydrologis.com</a>, <a href='http://www.ing.unitn.it/dica/hp/?user=rigon'>http://www.ing.unitn.it/dica/hp/?user=rigon</a></blockquote>

<blockquote>License: General Public License Version 3 (GPLv3)</blockquote>

<blockquote>Keywords: Histogram, Geomorphology, Statistic</blockquote>


<h2>Parameters</h2>

<h3>Input parameters</h3>
<table cellpadding='10' width='70%' border='1'>
<tr>
<td width='50%'> <b>inRaster1</b> </td><td width='50%'> The first raster to analyse. </td>
</tr>
<tr>
<td width='50%'> <b>inRaster2</b> </td><td width='50%'> The second raster to analyse. </td>
</tr>
<tr>
<td width='50%'> <b>pBins</b> </td><td width='50%'> The number of bins into which divide the data range. </td>
</tr>
<tr>
<td width='50%'> <b>pFirst</b> </td><td width='50%'> The first moment to calculate. </td>
</tr>
<tr>
<td width='50%'> <b>pLast</b> </td><td width='50%'> The last moment to calculate. </td>
</tr>
</table>

<h3>Output parameters</h3>
<table cellpadding='10' width='70%' border='1'>
<tr>
<td width='50%'> <b>outCb</b> </td><td width='50%'> A matrix containing 1) the mean value of the data in abscissa; 2) the number of elements in each interval; 3) the mean value of the data in ordinate; n+2) the n-esimal moment of the data in ordinate. </td>
</tr>
</table>

<h2>Example result</h2>

<img src='http://wiki.jgrasstools.googlecode.com/git/images/hortonmachine/cb.png' alt='Cb' />
<br>
<h2>Developer example</h2>

An example usage of the algorithm can be found in the testcases suite:<br>
<a href='http://code.google.com/p/jgrasstools/source/browse/hortonmachine/src/test/java/org/jgrasstools/hortonmachine/models/hm/TestCb.java'>Cb</a>