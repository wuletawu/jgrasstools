<h2>Description</h2>



<h2>General Information</h2>

> Module status: UNKNOWN

> Name to use in a script: <b></b>

> Authors:

> Contacts:

> Keywords:


<h2>Parameters</h2>

<h3>Input parameters</h3>
<table cellpadding='10' width='70%' border='1'>
<tr>
<td width='50%'> <b>inCalibrationParamfile</b> </td><td width='50%'> The file containing the model name (first line) and the ranges of the parameters to calibrate (in form: varname = vmin; vmax). </td>
</tr>
<tr>
<td width='50%'> <b>inParamfile</b> </td><td width='50%'> The file containing the input parameters for the model. </td>
</tr>
<tr>
<td width='50%'> <b>inMeasuredfile</b> </td><td width='50%'> The measured values. </td>
</tr>
<tr>
<td width='50%'> <b>pVariable</b> </td><td width='50%'> The variable of the model that will point to the output file. </td>
</tr>
<tr>
<td width='50%'> <b>pParticles</b> </td><td width='50%'> Number of particles to use. </td>
</tr>
<tr>
<td width='50%'> <b>pMaxiter</b> </td><td width='50%'> Maximum iterations number. </td>
</tr>
</table>

<h3>Output parameters</h3>
<table cellpadding='10' width='70%' border='1'>
<tr>
<td width='50%'> <b>pOptimal</b> </td><td width='50%'> Optimal value of the objective function. </td>
</tr>
<tr>
<td width='50%'> <b>outCalibrated</b> </td><td width='50%'> Calibrated parameters, in the same order as found in the input file. </td>
</tr>
</table>

<h2>Example result</h2>

<img src='http://wiki.jgrasstools.googlecode.com/git/images/hortonmachine/particleswarming.png' alt='ParticleSwarming' />
<br>