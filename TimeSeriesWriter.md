<h2>Description</h2>

Utility class for writing a set of timestamps and an array of values to an OMS formatted csv file. This writer writes a time series data file all in one, so it is not time dependent, for this you should look into TimeSeriesIteratorWriter.
<br>
<br>
<h3>Parameters</h3>
<ul>
<li>the csv file to write to</li>
<li>the table name</li>
<li>the hashmap of data to write</li>
<li>a switch that defines whether to write the timestamps as dates or as intervals of seconds if a date doesn't make sense</li>
<li>the comma separated list of column names</li>
<li>a map of lists of metadata that can be attached to the column of the csv file</li>
</ul>
<br>
<br>
<h3>Notes</h3>
<ul>
This model can be use for example to write output data from Peakflow.<br>
<br>
<br>
<h2>General Information</h2>

<blockquote>Module status: CERTIFIED</blockquote>

<blockquote>Name to use in a script: <b>tswriter</b></blockquote>

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
<td width='50%'> <b>tablename</b> </td><td width='50%'> The table name. </td>
</tr>
<tr>
<td width='50%'> <b>inData</b> </td><td width='50%'> The hashmap of data to write. IMPORTANT: The hashmap is assumed to be sorted. </td>
</tr>
<tr>
<td width='50%'> <b>doDates</b> </td><td width='50%'> A switch that defines whether to write the timestamps as dates or as intervals of seconds if a date doesn't make sense. </td>
</tr>
<tr>
<td width='50%'> <b>columns</b> </td><td width='50%'> The comma separated list of column names. </td>
</tr>
<tr>
<td width='50%'> <b>inMetadata</b> </td><td width='50%'> A list of lists of metadata that can be attached to the column of the csv file. </td>
</tr>
</table>


<h2>Developer example</h2>

An example usage of the algorithm can be found in the testcases suite:<br>
<a href='http://code.google.com/p/jgrasstools/source/browse/jgrassgears/src/test/java/org/jgrasstools/gears/modules/TestTimeSeriesWriter.java'>TimeSeriesWriter</a>