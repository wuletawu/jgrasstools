<h2>Description</h2>


> <p>
<blockquote>Calculates the potential evapotranspiration using the Pristley-Taylor model. Two are the modes:</p>
</blockquote>> <ul>
<blockquote><li>
<blockquote>with hourly time-step</li>
</blockquote><li>
<blockquote>with daily time-step</li>
</blockquote></blockquote><blockquote></ul>
<p>
<blockquote>In the first case the model uses the ground heat flux (G) computed as function of net radiation. In the second case G is neglected.<br />
<br />
</p>
</blockquote><h3>
<blockquote>Input files</h3>
</blockquote><ul></blockquote>

<blockquote><li>
<blockquote>the .csv file (YYYY-MM-DD HH:MI, temperature) containing the temperatures time series. In case of no-values, a standard values of temperature is used (e.g. the mean annual temperature).</li>
</blockquote><li>
<blockquote>the .csv file (YYYY-MM-DD HH:MI, net_radiation) containing the net radiation time series. In case of no-values, a standard values of radiation is used (e.g. the mean annual value)</li>
</blockquote><li>
<blockquote>the .csv file (YYYY-MM-DD HH:MI, atm_pressure) containing the atmospheric pressure time series. In case of not-values, a standard values of atmospheric pressure is used (101.31 kPa)</li>
</blockquote></blockquote><blockquote></ul>
<p>
<blockquote></p>
</blockquote><h3>
<blockquote>Input Parameters</h3>
</blockquote><ul>
<blockquote><li>
<blockquote>The value of the Pristley-Taylor constant</li>
</blockquote><li>
<blockquote>The value of Gm: the morning coefficient multiplying net radiation to estimate G during the morning</li>
</blockquote><li>
<blockquote>The value of Gn: the nigth coefficient multiplying net radiation to estimate G during the nigth</li>
</blockquote></blockquote></ul>
<h3>
<blockquote>Output<span>  </span></h3>
</blockquote><ul>
<blockquote><li>
<blockquote>the .csv file containing the potential evapotranspiration for every points selected for estimation</li>
</blockquote></blockquote></ul>
<h3>
<blockquote>Notes</h3>
</blockquote><p>
<blockquote>If you use the present model, the authors kindly ask to cite:</p>
</blockquote><p>
<blockquote>Formetta,G., Mantilla,R., Franceschi,S., Antonello,A., and Rigon,R.: The JGrass-NewAge system for forecasting and managing the hydrological budgets at the basin scale: models of flow generation and propagation/routing, Geosci. Model Dev., 4, 943-955, doi:10.5194/gmd-4-943-2011, 2011.</p>
</blockquote><p>
<blockquote><a href='http://www.geosci-model-dev.net/4/943/2011/gmd-4-943-2011.html'>http://www.geosci-model-dev.net/4/943/2011/gmd-4-943-2011.html</a></p>
</blockquote><p>
<blockquote></p>
</blockquote><p>
<blockquote>where the model is explained with more detail.</p>
</blockquote><p>
<blockquote></p>
</blockquote><p>
<blockquote></p></blockquote></blockquote>


<h2>General Information</h2>

> Module status: UNKNOWN

> Name to use in a script: <b>ptetp</b>

> Authors: Giuseppe Formetta, Silvia Franceschi, Andrea Antonello

> Contacts: http://www.hydrologis.com

> License: http://www.gnu.org/licenses/gpl-3.0.html

> Keywords: Evapotranspiration, Hydrologic


<h2>Parameters</h2>

<h3>Input parameters</h3>
<table cellpadding='10' width='70%' border='1'>
<tr>
<td width='50%'> <b>inNetradiation</b> </td><td width='50%'> The net Radiation at the grass surface in W/m2 for the current hour. <a href='Watt.md'>m-2 </a> </td>
</tr>
<tr>
<td width='50%'> <b>pDailyDefaultNetradiation</b> </td><td width='50%'> The net Radiation default value in case of missing data. <a href='Watt.md'>m-2</a> </td>
</tr>
<tr>
<td width='50%'> <b>pHourlyDefaultNetradiation</b> </td><td width='50%'> The net Radiation default value in case of missing data. <a href='Watt.md'>m-2</a> </td>
</tr>
<tr>
<td width='50%'> <b>doHourly</b> </td><td width='50%'> Switch that defines if it is hourly. <a href='.md'>.md</a> </td>
</tr>
<tr>
<td width='50%'> <b>inTemp</b> </td><td width='50%'> The mean hourly air temperature. <a href='C.md'>C</a> </td>
</tr>
<tr>
<td width='50%'> <b>pAlpha</b> </td><td width='50%'> The alpha. <a href='m.md'>m</a> </td>
</tr>
<tr>
<td width='50%'> <b>pGmorn</b> </td><td width='50%'> The g morning. <a href='.md'>.md</a> </td>
</tr>
<tr>
<td width='50%'> <b>pGnight</b> </td><td width='50%'> The g nigth. <a href='.md'>.md</a> </td>
</tr>
<tr>
<td width='50%'> <b>defaultTemp</b> </td><td width='50%'> The temperature default value in case of missing data. <a href='C.md'>C</a> </td>
</tr>
<tr>
<td width='50%'> <b>inPressure</b> </td><td width='50%'> The atmospheric pressure in KPa. <a href='KPa.md'>KPa</a> </td>
</tr>
<tr>
<td width='50%'> <b>defaultPressure</b> </td><td width='50%'> The pressure default value in case of missing data. <a href='KPa.md'>KPa</a> </td>
</tr>
<tr>
<td width='50%'> <b>time</b> </td><td width='50%'> The current time. <a href='C.md'>C</a> </td>
</tr>
<tr>
<td width='50%'> <b>fId</b> </td><td width='50%'> Station id field. </td>
</tr>
</table>

<h3>Output parameters</h3>
<table cellpadding='10' width='70%' border='1'>
<tr>
<td width='50%'> <b>outPTEtp</b> </td><td width='50%'> The reference evapotranspiration. <a href='mm.md'>hour-1</a> </td>
</tr>
</table>

<h2>Example result</h2>

<img src='http://wiki.jgrasstools.googlecode.com/git/images/hortonmachine/presteytayloretpmodel.png' alt='PresteyTaylorEtpModel' />
<br>