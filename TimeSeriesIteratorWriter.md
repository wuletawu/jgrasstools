<h2>Description</h2>

Utility class for writing a id2value map to a OMS formatted csv file. This writer writes a time series data file step by step, so it is time dependent, if you need to write a time series all in one please refer to TimeSeriesWriter.
<br>
<br>
<h3>Parameters</h3>
<ul>
<li>the table name</li>
<li>the map of ids and values to write</li>
<li>the start date, if available time is added as first column</li>
<li>the timestep</li>
<li>the novalue to use in the file (default is -9999.0)</li>
<li>the csv file to write to</li>
</ul>


<h2>General Information</h2>

<blockquote>Module status: CERTIFIED</blockquote>

<blockquote>Name to use in a script: <b>tsitwriter</b></blockquote>

<blockquote>Authors: Andrea Antonello</blockquote>

<blockquote>Contacts: <a href='http://www.hydrologis.com'>http://www.hydrologis.com</a></blockquote>

<blockquote>License: General Public License Version 3 (GPLv3)</blockquote>

<blockquote>Keywords: IO, Writing</blockquote>


<h2>Parameters</h2>

<h3>Input parameters</h3>
<table cellpadding='10' width='70%' border='1'>
<tr>
<td width='50%'> <b>file</b> </td><td width='50%'> The csv file to write to. </td>
</tr>
<tr>
<td width='50%'> <b>inTablename</b> </td><td width='50%'> The table name. </td>
</tr>
<tr>
<td width='50%'> <b>inData</b> </td><td width='50%'> The hashmap of ids and values to write. </td>
</tr>
<tr>
<td width='50%'> <b>tStart</b> </td><td width='50%'> The start date. If available time is added as first column. </td>
</tr>
<tr>
<td width='50%'> <b>tTimestep</b> </td><td width='50%'> The timestep. If available time is added as first column. </td>
</tr>
<tr>
<td width='50%'> <b>fileNovalue</b> </td><td width='50%'> The novalue to use in the file (default is -9999.0). </td>
</tr>
</table>


<h2>Developer example</h2>

An example usage of the algorithm can be found in the testcases suite:<br>
<a href='http://code.google.com/p/jgrasstools/source/browse/jgrassgears/src/test/java/org/jgrasstools/gears/modules/TestTimeSeriesIteratorWriter.java'>TimeSeriesIteratorWriter</a>