<h2>Description</h2>

Utility class for reading data from a OMS formatted csv file. The file needs a metadata line containing the id of the station. The table is supposed to have a first column of timestamp and all other columns of data related to the ids defined. This reader reads a time series data file step by step, so it is time dependent, if you need to read a time series all in one please refer to TimeSeriesReader.
<br>
This model allow the user to aggregate data for working with different timesteps. This means that if you will work with a different timestep respect to the data original one, you simply need to specify the number of timesteps to aggregate (number of rows) as an integer value and the operation that you would do with the aggregated data, sum or average.<br>
<br>
<br>
<h3>Parameters</h3>
<ul>
<li>the csv file to read from</li>
<li>the id metadata field</li>
<li>the file novalue to be translated into the internal novalue (defaults to -9999.0); it can be also a string.</li>
<li>the internal novalue to use (defaults to NaN, usually not changed)</li>
<li>the number of rows to aggregate (default is 1, i.e. no aggregation)</li>
<li>the aggregation type to use (0 = sum, 1 = avg)</li>
<li>the time at which start to read (format: yyyy-MM-dd HH:mm)</li>
<li>the time at which end to read (format: yyyy-MM-dd HH:mm)</li>
<li>the reading timestep in minutes</li>
<li>the current time read (format: yyyy-MM-dd HH:mm)</li>
<li>the previous time read (format: yyyy-MM-dd HH:mm)</li>
<li>the read map of ids and values</li>
</ul>


<h2>General Information</h2>

<blockquote>Module status: CERTIFIED</blockquote>

<blockquote>Name to use in a script: <b>tsitreader</b></blockquote>

<blockquote>Authors: Andrea Antonello</blockquote>

<blockquote>Contacts: <a href='http://www.hydrologis.com'>http://www.hydrologis.com</a></blockquote>

<blockquote>License: General Public License Version 3 (GPLv3)</blockquote>

<blockquote>Keywords: IO, Reading</blockquote>


<h2>Parameters</h2>

<h3>Input parameters</h3>
<table cellpadding='10' width='70%' border='1'>
<tr>
<td width='50%'> <b>file</b> </td><td width='50%'> The csv file to read from. </td>
</tr>
<tr>
<td width='50%'> <b>idfield</b> </td><td width='50%'> The id metadata field. </td>
</tr>
<tr>
<td width='50%'> <b>fileNovalue</b> </td><td width='50%'> The file novalue to be translated into the internal novalue. Can be a string also </td>
</tr>
<tr>
<td width='50%'> <b>novalue</b> </td><td width='50%'> The internal novalue to use (usually not changed). </td>
</tr>
<tr>
<td width='50%'> <b>pNum</b> </td><td width='50%'> The number of rows to aggregate (default is 1, i.e. no aggregation). </td>
</tr>
<tr>
<td width='50%'> <b>pAggregation</b> </td><td width='50%'> The aggregation type to use (0 = sum, 1 = avg). </td>
</tr>
<tr>
<td width='50%'> <b>tStart</b> </td><td width='50%'> The time at which start to read (format: yyyy-MM-dd HH:mm ). </td>
</tr>
<tr>
<td width='50%'> <b>tEnd</b> </td><td width='50%'> The time at which end to read (format: yyyy-MM-dd HH:mm ). </td>
</tr>
<tr>
<td width='50%'> <b>tTimestep</b> </td><td width='50%'> The reading timestep in minutes. </td>
</tr>
</table>

<h3>Output parameters</h3>
<table cellpadding='10' width='70%' border='1'>
<tr>
<td width='50%'> <b>tStart</b> </td><td width='50%'> The time at which start to read (format: yyyy-MM-dd HH:mm ). </td>
</tr>
<tr>
<td width='50%'> <b>tEnd</b> </td><td width='50%'> The time at which end to read (format: yyyy-MM-dd HH:mm ). </td>
</tr>
<tr>
<td width='50%'> <b>tTimestep</b> </td><td width='50%'> The reading timestep in minutes. </td>
</tr>
<tr>
<td width='50%'> <b>tCurrent</b> </td><td width='50%'> The current time read (format: yyyy-MM-dd HH:mm ). </td>
</tr>
<tr>
<td width='50%'> <b>tPrevious</b> </td><td width='50%'> The previous time read (format: yyyy-MM-dd HH:mm ). </td>
</tr>
<tr>
<td width='50%'> <b>outData</b> </td><td width='50%'> The read map of ids and values. </td>
</tr>
</table>

<h2>Developer example</h2>

An example usage of the algorithm can be found in the testcases suite:<br>
<a href='http://code.google.com/p/jgrasstools/source/browse/jgrassgears/src/test/java/org/jgrasstools/gears/modules/TestTimeSeriesIteratorReader.java'>TimeSeriesIteratorReader</a>