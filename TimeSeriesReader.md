<h2>Description</h2>

Utility class for reading data from a OMS formatted csv file. The data is assumed to be first col a date and then al numbers. This reader reads a time series data file all in one, so it is not time dependent, for this you should look into TimeSeriesIteratorReader.
<br>
<br>
<h3>Parameters</h3>
<ul>
<li>the csv file to read from</li>
<li>the file novalue to be translated into the internal novalue (defaults to -9999.0); it can be also a string.</li>
<li>the internal novalue to use (defaults to NaN)</li>
<li>the list of timestamps read</li>
</ul>


<h2>General Information</h2>

<blockquote>Module status: CERTIFIED</blockquote>

<blockquote>Name to use in a script: <b>tsreader</b></blockquote>

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
<td width='50%'> <b>fileNovalue</b> </td><td width='50%'> The file novalue to be translated into the internal novalue (defaults to -9999.0). Can be also a string. </td>
</tr>
<tr>
<td width='50%'> <b>novalue</b> </td><td width='50%'> The internal novalue to use (defaults to NaN). </td>
</tr>
</table>

<h3>Output parameters</h3>
<table cellpadding='10' width='70%' border='1'>
<tr>
<td width='50%'> <b>outData</b> </td><td width='50%'> The sorted hashmap of read data. </td>
</tr>
</table>

<h2>Developer example</h2>

An example usage of the algorithm can be found in the testcases suite:<br>
<a href='http://code.google.com/p/jgrasstools/source/browse/jgrassgears/src/test/java/org/jgrasstools/gears/modules/TestTimeSeriesReader.java'>TimeSeriesReader</a>