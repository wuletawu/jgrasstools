<h2>Description</h2>

An implementation of the ordinary kriging algorithm. This is a time dependent model, it runs over all the timesteps in the input data file.
<br>
The <i>Kriging</i> is a group of <b>geostatistical</b> techniques to interpolate the value of a random field (e.g., the elevation, z, of the landscape as a function of the geographic location) at an unobserved location from observations of its value at nearby locations. (for more details see <a href='http://en.wikipedia.org/wiki/Kriging'>kriging</a>.<br>
<br>
<br>
The interpolation algorithm used for Kriging can be one of the following two:<br>
<ul>
<li>integral scale</li>
<li>gaussian variogram model</li>
</ul>
When selecting the interpolation function the user should provide the specific requested data.<br>
<br>
<br>
It is possible run the model in 4 modes:<br>
<ul>
<li>mode = 0: output values on a non-regular grid, it should be provided the vector of points where to interpolate <i>pointsToInterpolate</i>. This is a 2-D interpolation, so the z coordinates are not considered.</li>
<li>mode = 1: output values on a non-regular grid, it should be provided the vector of points where to interpolate <i>pointsToInterpolate</i>. This is a 3-D interpolation.</li>
<li>mode = 2: output values on a regular grid, it should be provided the raster <i>gridToInterpolate</i> where to interpolate. This is a 2-D interpolation so the z coordinates are not considered. <b>NOT YET IMPLEMENTED</b></li>
<li>mode = 3: output values on a regular grid, it should be provided the raster <i>gridToInterpolate</i> where to interpolate. This is a 3-D interpolation, so the provided raster data have to contain a elevations.<b>NOT YET IMPLEMENTED</b></li>
</ul>
<br>
<br>
<h3>Inputs</h3>
<ul>
<li>the vector of the measurement point, containing the position of the stations where data are measured</li>
<li>the name of the attribute of the vector of the measurement points defining the <i>STATION ID</i></li>
<li>the name of the attribute of the vector of the measurement points defining the <i>STATION ELEVATION</i></li>
<li>the text file with the measured data in each station to be interpolated</li>
<li>the vector of the points in which the data have to be interpolated</li>
<li>the field of the interpolated vector points, defining the <i>POINT ID</i></li>
<li>the field of the interpolated vector points, defining the <i>POINT ELEVATION</i></li>
</ul>
<br>
<br>
<h3>Output</h3>
<ul>
<li>the file containing the interpolated data</li>
</ul>


<h2>General Information</h2>

<blockquote>Module status: UNKNOWN</blockquote>

<blockquote>Name to use in a script: <b>kriging</b></blockquote>

<blockquote>Authors: Giuseppe Formetta, Daniele Andreis, Silvia Franceschi, Andrea Antonello</blockquote>

<blockquote>Contacts: <a href='http://www.hydrologis.com'>http://www.hydrologis.com</a>,  <a href='http://www.ing.unitn.it/dica/hp/?user=rigon'>http://www.ing.unitn.it/dica/hp/?user=rigon</a></blockquote>

<blockquote>License: General Public License Version 3 (GPLv3)</blockquote>

<blockquote>Keywords: Kriging, Hydrology</blockquote>


<h2>Parameters</h2>

<h3>Input parameters</h3>
<table cellpadding='10' width='70%' border='1'>
<tr>
<td width='50%'> <b>inStations</b> </td><td width='50%'> The vector of the measurement point, containing the position of the stations. </td>
</tr>
<tr>
<td width='50%'> <b>fStationsid</b> </td><td width='50%'> The field of the vector of stations, defining the id. </td>
</tr>
<tr>
<td width='50%'> <b>fStationsZ</b> </td><td width='50%'> The field of the vector of stations, defining the elevation. </td>
</tr>
<tr>
<td width='50%'> <b>inData</b> </td><td width='50%'> The file with the measured data, to be interpolated. </td>
</tr>
<tr>
<td width='50%'> <b>inInterpolate</b> </td><td width='50%'> The vector of the points in which the data have to be interpolated. </td>
</tr>
<tr>
<td width='50%'> <b>fInterpolateid</b> </td><td width='50%'> The field of the interpolated vector points, defining the id. </td>
</tr>
<tr>
<td width='50%'> <b>fPointZ</b> </td><td width='50%'> The field of the interpolated vector points, defining the elevation. </td>
</tr>
<tr>
<td width='50%'> <b>pMode</b> </td><td width='50%'> The interpolation mode (0 = interpolate on irregular grid, 1 = interpolate on regular grid). </td>
</tr>
<tr>
<td width='50%'> <b>pIntegralscale</b> </td><td width='50%'> The integral scale. </td>
</tr>
<tr>
<td width='50%'> <b>pVariance</b> </td><td width='50%'> The variance. </td>
</tr>
<tr>
<td width='50%'> <b>doLogarithmic</b> </td><td width='50%'> Switch for logaritmic run selection. </td>
</tr>
<tr>
<td width='50%'> <b>inInterpolationGrid</b> </td><td width='50%'> The collection of the points in which the data needs to be interpolated. </td>
</tr>
<tr>
<td width='50%'> <b>pSemivariogramType</b> </td><td width='50%'> The type of theoretical semivariogram: 0 = Gaussian; 1 = Exponential. </td>
</tr>
<tr>
<td width='50%'> <b>doIncludezero</b> </td><td width='50%'> Include zeros in computations (default is true). </td>
</tr>
<tr>
<td width='50%'> <b>pA</b> </td><td width='50%'> The range if the models runs with the gaussian variogram. </td>
</tr>
<tr>
<td width='50%'> <b>pS</b> </td><td width='50%'> The sill if the models runs with the gaussian variogram. </td>
</tr>
<tr>
<td width='50%'> <b>pNug</b> </td><td width='50%'> Is the nugget if the models runs with the gaussian variogram. </td>
</tr>
</table>

<h3>Output parameters</h3>
<table cellpadding='10' width='70%' border='1'>
<tr>
<td width='50%'> <b>outGrid</b> </td><td width='50%'> The interpolated gridded data (for mode 2 and 3. </td>
</tr>
<tr>
<td width='50%'> <b>outData</b> </td><td width='50%'> The interpolated data (for mode 0 and 1). </td>
</tr>
</table>

<h2>Example result</h2>

<img src='http://wiki.jgrasstools.googlecode.com/git/images/hortonmachine/kriging.png' alt='Kriging' />
<br>