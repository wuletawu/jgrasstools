<h2>Description</h2>

It extracts the channel network from the drainage directions in five possible ways:
<ol>
<li>by using a threshold value on the contributing areas, then only<br>
the pixels with contributing area greater than the threshold are the<br>
channel heads (mode 0)</li>
<li>by using a threshold value of the estimated stress tangential to the bottom (mode 1)</li>
<li>by using a threshold value on the estimated stress tangential to the bottom only in convergent sites (mode 2)</li>
</ol>
Individuated the beginning of the channel incision, the points upriver
are considered as canalized.
<br>
<br>
<h3>Inputs</h3>
<ul>
<li>the file containing the matrix of the drainage directions (obtained with DrainDir or Markoutlets)</li>
<li>the file containing the matrix of contributing areas (calculated<br>
with DrainDir, Tca or Multitca)</li>
<li>if we choose mode 1, the file containing the matrix of the slopes (calculated with Gradient or Slope)</li>
<li>if we choose mode 2, the file containing the matrix with the classes aggregated by GC</li>
</ul>
<br>
<br>
<h3>Output</h3>
<ul>
<li>the file containing the matrix which individuates the channel<br>
network</li>
<li>the file containing the total contributing areas calculated with the new drainage directions</li>
<li>if we choose to create the vector layer of the extracted network, the vector map with the channel network ("filePath" is the path<br>
plus the file name of the vector layer)</li>
</ul>


<h2>General Information</h2>

<blockquote>Module status: CERTIFIED</blockquote>

<blockquote>Name to use in a script: <b>extractnet</b></blockquote>

<blockquote>Authors: Erica Ghesla, Andrea Antonello, Franceschi Silvia, Andrea Cozzini, Silvano Pisoni</blockquote>

<blockquote>Contacts: <a href='http://www.hydrologis.com'>http://www.hydrologis.com</a>, <a href='http://www.ing.unitn.it/dica/hp/?user=rigon'>http://www.ing.unitn.it/dica/hp/?user=rigon</a></blockquote>

<blockquote>License: General Public License Version 3 (GPLv3)</blockquote>

<blockquote>Keywords: Network, Vector, FlowDirectionsTC, GC, DrainDir, Gradient, Slope</blockquote>


<h2>Parameters</h2>

<h3>Input parameters</h3>
<table cellpadding='10' width='70%' border='1'>
<tr>
<td width='50%'> <b>inFlow</b> </td><td width='50%'> The map of flowdirections. </td>
</tr>
<tr>
<td width='50%'> <b>inTca</b> </td><td width='50%'> The map of total contributing areas. </td>
</tr>
<tr>
<td width='50%'> <b>inSlope</b> </td><td width='50%'> The map of slope. </td>
</tr>
<tr>
<td width='50%'> <b>inTc3</b> </td><td width='50%'> The map of aggregated topographic classes. </td>
</tr>
<tr>
<td width='50%'> <b>pThres</b> </td><td width='50%'> The threshold on the map. </td>
</tr>
<tr>
<td width='50%'> <b>pMode</b> </td><td width='50%'> The processing mode (0 = threshold on tca, 1 = threshold on tca and slope, 2 = threshold on tca in convergent sites). </td>
</tr>
<tr>
<td width='50%'> <b>pExp</b> </td><td width='50%'> Tca exponent for the mode 1 and 2 (default = 0.5). </td>
</tr>
<tr>
<td width='50%'> <b>doNetfc</b> </td><td width='50%'> Switch to create a vector of the network (default = false). </td>
</tr>
</table>

<h3>Output parameters</h3>
<table cellpadding='10' width='70%' border='1'>
<tr>
<td width='50%'> <b>outNet</b> </td><td width='50%'> The extracted network raster. </td>
</tr>
<tr>
<td width='50%'> <b>outVNet</b> </td><td width='50%'> The vector of the network. </td>
</tr>
</table>

<h2>Example result</h2>

<img src='http://wiki.jgrasstools.googlecode.com/git/images/hortonmachine/extractnetwork.png' alt='ExtractNetwork' />
<br>
<h2>Developer example</h2>

An example usage of the algorithm can be found in the testcases suite:<br>
<a href='http://code.google.com/p/jgrasstools/source/browse/hortonmachine/src/test/java/org/jgrasstools/hortonmachine/models/hm/TestExtractNetwork.java'>ExtractNetwork</a>