<h2>Description</h2>

Estimates the  amount of power due to the incident radiation in a specific period.
<br>
The output insolation is in Mega Joule (MJ) and the period of time is defined from the starting day (e.g. 2010-01-01) and the last day of the simulation (e.g. 2010-12-31).<br>
<br>
<br>
<h3>Inputs</h3>
<ul>
<li>the file containing the matrix of the elevations, usually the DEM or the output of pitfiller </li>
<li>the first day of simulation</li>
<li>the last day of simulation</li>
</ul>
<br>
<br>
<h3>Output</h3>
<ul>
<li>the file containing the power matrix</li>
</ul>
<br>
<br>
<h3>Notes</h3>
Please take care to insert the date in the format YYYY-MM-DD<br>
<br>
<br>
<h2>General Information</h2>

<blockquote>Module status: CERTIFIED</blockquote>

<blockquote>Name to use in a script: <b>insolation</b></blockquote>

<blockquote>Authors: Daniele Andreis and Riccardo Rigon</blockquote>

<blockquote>Contacts: <a href='http://www.ing.unitn.it/dica/hp/?user=rigon'>http://www.ing.unitn.it/dica/hp/?user=rigon</a></blockquote>

<blockquote>License: General Public License Version 3 (GPLv3)</blockquote>

<blockquote>Keywords: Hydrology, Radiation, SkyviewFactor, Hillshade</blockquote>


<h2>Parameters</h2>

<h3>Input parameters</h3>
<table cellpadding='10' width='70%' border='1'>
<tr>
<td width='50%'> <b>inElev</b> </td><td width='50%'> The map of the elevation. </td>
</tr>
<tr>
<td width='50%'> <b>tStartDate</b> </td><td width='50%'> The first day of the simulation. </td>
</tr>
<tr>
<td width='50%'> <b>tEndDate</b> </td><td width='50%'> The last day of the simulation. </td>
</tr>
</table>

<h3>Output parameters</h3>
<table cellpadding='10' width='70%' border='1'>
<tr>
<td width='50%'> <b>outIns</b> </td><td width='50%'> The map of total insolation. </td>
</tr>
</table>

<h2>Example result</h2>

<img src='http://wiki.jgrasstools.googlecode.com/git/images/hortonmachine/insolation.png' alt='Insolation' />
<br>
<h2>Developer example</h2>

An example usage of the algorithm can be found in the testcases suite:<br>
<a href='http://code.google.com/p/jgrasstools/source/browse/hortonmachine/src/test/java/org/jgrasstools/hortonmachine/models/hm/TestInsolation.java'>Insolation</a>