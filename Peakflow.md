<h2>Description</h2>

Calculates the maximum peak discharge using the approach of the width function.
The model can work in two different modes:
<ul>
<li>statistical mode: giving as input the IDF curves parameters for the estimation of the rainfall</li>
<li>real event mode: providing a file with a measured rainfall event</li>
</ul>
In the first case the model will estimate the maximum discharge and also the maximum duration of the statistical rainfall that produces the maximum discharge. The statistical rainfall is calculated considering the IDF curves parameters and a constant rainfall for the whole duration.
<br>
In case of real rainfall event the input file with the measured rainfall should follow the format:<br>
<br>
<br>
<div> YYYY-MM-DD HH:MI rainvalue</div>
<br>
<br>
<br>
<h3>Inputs</h3>
<ul>
<li>the file containing the map of topindex (obtained with TopIndex)</li>
<li>the file containing the map of the rescaled distance for the saturated sites (obtained with RescaledDistance)</li>
<li>the file containing the map of the rescaled distance for the unsaturated sites (obtained with RescaledDistance)</li>
<li>if we choose to run the model with a real event,the file containing the measured rainfall event</li>
</ul>
<br>
<br>
<h3>Output</h3>
<ul>
<li>the file containing the calculated discharge at basin outlet</li>
</ul>
<br>
<br>
<h3>Notes</h3>
To run the model other parameters are required:<br>
<ul>
<li>the average (time and space) velocity of the flow in the channels</li>
<li>the saturation percentage of the basin</li>
<li>the hydraulic diffusion parameter</li>
</ul>


<h2>General Information</h2>

<blockquote>Module status: CERTIFIED</blockquote>

<blockquote>Name to use in a script: <b>peakflow</b></blockquote>

<blockquote>Authors: Silvia Franceschi, Andrea Antonello, Riccardo Rigon</blockquote>

<blockquote>Contacts: <a href='http://www.hydrologis.com'>http://www.hydrologis.com</a>, <a href='http://www.ing.unitn.it/dica/hp/?user=rigon'>http://www.ing.unitn.it/dica/hp/?user=rigon</a></blockquote>

<blockquote>License: General Public License Version 3 (GPLv3)</blockquote>

<blockquote>Keywords: Peakflow, Discharge, Hydrologic, Cb, RescaledDistance</blockquote>


<h2>Parameters</h2>

<h3>Input parameters</h3>
<table cellpadding='10' width='70%' border='1'>
<tr>
<td width='50%'> <b>pA</b> </td><td width='50%'> The a parameter for statistic rain calculations. [mm/h^m] </td>
</tr>
<tr>
<td width='50%'> <b>pN</b> </td><td width='50%'> The n parameter for statistic rain calculations. </td>
</tr>
<tr>
<td width='50%'> <b>pCelerity</b> </td><td width='50%'> The channel celerity parameter. [m/s] </td>
</tr>
<tr>
<td width='50%'> <b>pDiffusion</b> </td><td width='50%'> The diffusion parameter. [m2/s] </td>
</tr>
<tr>
<td width='50%'> <b>pSat</b> </td><td width='50%'> The saturation percentage. [%] </td>
</tr>
<tr>
<td width='50%'> <b>inTopindex</b> </td><td width='50%'> The map of Topindex. </td>
</tr>
<tr>
<td width='50%'> <b>inSat</b> </td><td width='50%'> Optional map of saturation. </td>
</tr>
<tr>
<td width='50%'> <b>inRescaledsup</b> </td><td width='50%'> The map of superficial rescaled distance. </td>
</tr>
<tr>
<td width='50%'> <b>inRescaledsub</b> </td><td width='50%'> The map of sub-superficial rescaled distance. </td>
</tr>
<tr>
<td width='50%'> <b>inRainfall</b> </td><td width='50%'> The sorted hasmap of rainfall data per timestep. </td>
</tr>
</table>

<h3>Output parameters</h3>
<table cellpadding='10' width='70%' border='1'>
<tr>
<td width='50%'> <b>outDischarge</b> </td><td width='50%'> The sorted hashmap of peakflow output per timestep. </td>
</tr>
</table>

<h2>Example result</h2>

<img src='http://wiki.jgrasstools.googlecode.com/git/images/hortonmachine/peakflow.png' alt='Peakflow' />
<br>