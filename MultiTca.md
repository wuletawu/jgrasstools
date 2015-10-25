<h2>Description</h2>

MultiTca.html

<h2>General Information</h2>

> Module status: UNKNOWN

> Name to use in a script: <b>multitca</b>

> Authors: Andreis Daniele, Erica Ghesla, Antonello Andrea, Cozzini Andrea, Franceschi Silvia, PisoniSilvano, Rigon Riccardo

> Contacts:

> License: General Public License Version 3 (GPLv3)

> Keywords: Geomorphology, DrainDir, Pitfiller, Ab


<h2>Parameters</h2>

<h3>Input parameters</h3>
<table cellpadding='10' width='70%' border='1'>
<tr>
<td width='50%'> <b>inPit</b> </td><td width='50%'> The map of depitted elevation. </td>
</tr>
<tr>
<td width='50%'> <b>inFlow</b> </td><td width='50%'> The map of flowdirections. </td>
</tr>
<tr>
<td width='50%'> <b>inCp9</b> </td><td width='50%'> The map of depitted elevation. </td>
</tr>
</table>

<h3>Output parameters</h3>
<table cellpadding='10' width='70%' border='1'>
<tr>
<td width='50%'> <b>outMultiTca</b> </td><td width='50%'> The map of total contributing areas. </td>
</tr>
</table>

<h2>Example result</h2>

<img src='http://wiki.jgrasstools.googlecode.com/git/images/hortonmachine/multitca.png' alt='MultiTca' />
<br>
<h2>Developer example</h2>

An example usage of the algorithm can be found in the testcases suite:<br>
<a href='http://code.google.com/p/jgrasstools/source/browse/hortonmachine/src/test/java/org/jgrasstools/hortonmachine/models/hm/TestMultiTca.java'>MultiTca</a>