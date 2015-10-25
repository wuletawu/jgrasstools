<h2>Description</h2>

Transforms the network shape to a raster net map and an additional raster flow map along the network.
<br>
The input network vector should follow these guidelines:<br>
<ul>
<li>links have to be drawn from upstream to downstream</li>
<li>confluence should be of maximum 2 elements</li>
<li>links between a junction and the next have to be a single geometry</li>
</ul>
<br>
It can be used as an input for the drain map to force drainage directions, there is the possibility to create a shapefile of problem points to be used for<br>
a revision of the original vector network.<br>
<br>
<br>
<h3>Inputs</h3>
<ul>
<li>the network vector map</li>
<li>the field of the attribute table of the network vector that defines the ACTIVE links, non active links will be not considered for rasterization;<br>
the attribute field has to have the type of a String with Yes or No as active or non active</li>
<li>the field of the attribute table of the network vector that defines the progressive ID for the features</li>
</ul>
<br>
<br>
<h3>Output</h3>
<ul>
<li>the file containing the flow map on the net</li>
<li>the file containing the raster network map</li>
<li>if requested, the problem point vector file</li>
</ul>
<br>
<br>


<h2>General Information</h2>

<blockquote>Module status: UNKNOWN</blockquote>

<blockquote>Name to use in a script: <b>net2flow</b></blockquote>

<blockquote>Authors: Silvia Franceschi, Andrea Antonello</blockquote>

<blockquote>Contacts: <a href='http://www.hydrologis.com'>http://www.hydrologis.com</a></blockquote>

<blockquote>License: General Public License Version 3 (GPLv3)</blockquote>

<blockquote>Keywords: Network, Flowdirections</blockquote>


<h2>Parameters</h2>

<h3>Input parameters</h3>
<table cellpadding='10' width='70%' border='1'>
<tr>
<td width='50%'> <b>inNet</b> </td><td width='50%'> The network features. </td>
</tr>
<tr>
<td width='50%'> <b>inGrid</b> </td><td width='50%'> The grid geometry of the region on which to create the output rasters. </td>
</tr>
<tr>
<td width='50%'> <b>fActive</b> </td><td width='50%'> The field of the attributes table of the network flagging the feature as active. </td>
</tr>
<tr>
<td width='50%'> <b>fId</b> </td><td width='50%'> The field of the attributes table of the network defining the id of the feature. </td>
</tr>
</table>

<h3>Output parameters</h3>
<table cellpadding='10' width='70%' border='1'>
<tr>
<td width='50%'> <b>outFlownet</b> </td><td width='50%'> The output flow map on the network pixels. </td>
</tr>
<tr>
<td width='50%'> <b>outNet</b> </td><td width='50%'> The output network map. </td>
</tr>
<tr>
<td width='50%'> <b>outProblems</b> </td><td width='50%'> The problems features points. </td>
</tr>
</table>

<h2>Example result</h2>

<img src='http://wiki.jgrasstools.googlecode.com/git/images/hortonmachine/netshape2flow.png' alt='Netshape2Flow' />
<br>