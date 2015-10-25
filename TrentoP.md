<h2>Description</h2>

A java implementation of the <b>trento_p</b> program (written by <i>Riccardo<br>
Rigon and David Tamanini</i> in c).

<p>
The aim of this class is to project and verify sewer pipes (not under<br>
pressure). This class is designed to work in two modality:<br>
<ol>
<li><b>Project</b>, which calculate the pipes diameter, and depth, of a point<br>
network.<br>
<li><b>Verify</b>, which calculate the discharge of a pipes network.<br>
<br>
<br>
Unknown end tag for </ol><br>
<br>
<br>
<br>
<br>
<br>
Unknown end tag for </p><br>
<br>
<br>
<p>

</p>
<p>
For more details about the computational method see <a href="http<br>
://www.ing.unitn.it/dica/hp/?user=rigon/"> trento_p manual<br>
<br>
Unknown end tag for </a><br>
<br>
<br>
</p>
<h3>Parameters</h3>
<p>
The model needs several parameter, the <b>necessary</b> parameters are:<br>
<ol>
<li> pAccuracy,<br>
<li> pTest, which indicate if the program runs in verify or project mode.<br>
<br>
<br>
Unknown end tag for </ol><br>
<br>
<br>
And also, only for the project mode:<br>
<ol>
<li>pA<br>
<li>pN<br>
<li>pTau<br>
<li>pAlign<br>
<br>
<br>
Unknown end tag for </ol><br>
<br>
<br>
<br>
The other parameters can be not set because they have a default value.<br>
<br>
<br>
Unknown end tag for </p><br>
<br>
<br>
<br>
<br>
<h3>Inputs</h3>
<p>
As input the module needs a <b><i>FeatureCollection</i></b>,inPipesFC, with<br>
<i>LineString</i> as geometry, and with several fields that characterize the<br>
pipe.<br>
<p>
Usually The input network is obtained from a <i>shp file</i>. It's necessary that the<br>
geometries of the shape are LineString and each line (which is a<br>
pipe) must have the following fields:<br>
<ol>
<li>ID, is the identifier name of the pipe .<br>
<li>Drain Area, which is the amount of area which drain in this pipe and<br>
is in ha = 10<sup>{-2} km</sup>2 .<br>
<li>initial Elevation of the terrain (at the first extreme), is in meter<br>
over the see level.<br>
<li>Final Elevation of the terrain(at the second extreme), is in meter<br>
over the see level.<br>
<li>The Runoff coefficient.<br>
<li>The average residence time,per unit area.<br>
<li>Ks, Gauckler-Strickler coefficient.<br>
<li>Minimum pipe slope (%).<br>
<li>Pipe section type: 1=circular, 2=rectangular, 3=trapezoidal.<br>
<li>Average state slope computed as the weighted mean of the state<br>
elevation; the weights are the areas at the same height within the state.<br>
<li>Diameter to verify (in verify mode).<br>
<li>Slope to verify (in verify mode).<br>
<br>
<br>
Unknown end tag for </ol><br>
<br>
<br>
<br>
<br>
Unknown end tag for </p><br>
<br>
<br>
<p>
All of this value are caractherized a pipe so are stored in a<br>
Pipe object.<br>
</p>
<p>
If the mode is project there is also the <b>inDiameters</b> array, which contains a set of commercial pipes diameter.<br>
If the mode is verify there is another input fields: <b>inRain</b>, which contains the rain data.<br>
</p>
<h3>Outputs</h3>
If the mode is project the output is a network stored in a FeatureCollection.<br>
<p>
The geometries are LineString and are obtained from<br>
<b>inPipesFC<b>. In each feature are stored from a Pipe :<br>
<ol>
<li>ID, is the identifier name of the pipe.<br>
<li>ID pipe where drain, which is the ID of the pipe where the current<br>
pipe drains.<br>
<li>Drain Area, which is the amount of area which drain in this pipe and<br>
is in ha = 10<sup>{-2} km</sup>2.<br>
<li>initial Elevation of the terrain (at the first extreme), is in meter<br>
over the see level.<br>
<li>Final Elevation of the terrain(at the second extreme), is in meter<br>
over the see level.<br>
<li>The Runoff coefficient.<br>
<li>The average residence time,per unit area.<br>
<li>Ks, Gauckler-Strickler coefficient.<br>
<li>Minimum pipe slope (%).<br>
<li>Pipe section type: 1=circular, 2=rectangular, 3=trapezoidal.<br>
<li>Average state slope computed as the weighted mean of the state<br>
elevation; the weights are the areas at the same height within the state.<br>
<li>Diameter to verify (in verify mode).<br>
<li>Slope to verify (in verify mode),.<br>
<li>Discharge in Q[l/s].<br>
<li>Udometric coefficient [l/s ha].<br>
<li>Residence time <a href='min.md'>min</a>.<br>
<li>tP<a href='min.md'>min</a>.<br>
<li>Time at the maximum discharge <a href='min.md'>min</a>.<br>
<li>Mean of the speed in the pipe,[m/s] .<br>
<li>Pipe slope,{field of the property.<br>
<li>Diameter in cm,{field of the property.<br>
<li>Empthy degree,{field of the property.<br>
<li>Initial pipe depth, is the depth of the dig.<br>
<li>Final pipe depth, is the depth of the dig.<br>
<li>Initial free surface depth.<br>
<li>Final free surface depth.<br>
<li> The area of the sub basin with the current pipe as outlet.<br>
<li> The tiotal length of thr subnetwork.<br>
<li> The mean length of the sub network pipes.<br>
<li> The variance of the subnetwork pipes.<br>
<br>
<br>
Unknown end tag for </ol><br>
<br>
<br>
<br>
<br>
Unknown end tag for </p><br>
<br>
<br>
<br>
<ol>
<li><b>Project</b>: A fetureCollection ({@link #outPipesFC}) with the net (as<br>
in the {@link #inPipesFC}) and with the result as a field of features.<br>
<li><b>Verify</b>: A matrix which contains the discharg at each time for each<br>
pipe.<br>
<br>
<br>
Unknown end tag for </ol><br>
<br>
<br>
<br>
<br>
<h2>General Information</h2>

<blockquote>Module status: DRAFT</blockquote>

<blockquote>Authors: Daniele Andreis,Rigon Riccardo,David tamanini</blockquote>

<blockquote>Contacts:</blockquote>

<blockquote>License: <a href='http://www.gnu.org/licenses/gpl-3.0.html'>http://www.gnu.org/licenses/gpl-3.0.html</a></blockquote>

<blockquote>Keywords: Sewer network</blockquote>


<h2>Parameters</h2>

<h3>Input parameters</h3>
<table cellpadding='10' width='70%' border='1'>
<tr>
<td width='50%'> <b>pMode</b> </td><td width='50%'> Processing mode, 0=project, 1=verification. </td>
</tr>
<tr>
<td width='50%'> <b>pMinimumDepth</b> </td><td width='50%'> Minimum excavation depth <a href='m.md'>m</a> </td>
</tr>
<tr>
<td width='50%'> <b>pMaxJunction</b> </td><td width='50%'> Max number of pipes that can converge in a junction. [-] </td>
</tr>
<tr>
<td width='50%'> <b>pJMax</b> </td><td width='50%'> Max number of bisection to do (default is 40)to search a solution of a transcendently equation. [-] </td>
</tr>
<tr>
<td width='50%'> <b>pAccuracy</b> </td><td width='50%'> Accuracy to use to calculate a solution with bisection method. [-] </td>
</tr>
<tr>
<td width='50%'> <b>pEpsilon</b> </td><td width='50%'> Accuracy to use to calculate the discharge. [-] </td>
</tr>
<tr>
<td width='50%'> <b>pMinG</b> </td><td width='50%'> Minimum Fill degree [-] </td>
</tr>
<tr>
<td width='50%'> <b>pMinDischarge</b> </td><td width='50%'> Minimum discharge in a pipe [m3/s] </td>
</tr>
<tr>
<td width='50%'> <b>pMaxTheta</b> </td><td width='50%'> Maximum Fill degree [-] </td>
</tr>
<tr>
<td width='50%'> <b>pCelerityFactor</b> </td><td width='50%'> Celerity factor, value used to obtain the celerity of the discharge wave. [-] </td>
</tr>
<tr>
<td width='50%'> <b>pExponent</b> </td><td width='50%'> Exponent of the basin extension. Used to calculate the average acces time to the network. [-] </td>
</tr>
<tr>
<td width='50%'> <b>pTolerance</b> </td><td width='50%'> tollerance, used to obtain the radius [-] </td>
</tr>
<tr>
<td width='50%'> <b>pC</b> </td><td width='50%'> Division base to height in the rectangular or trapezium section. [-] </td>
</tr>
<tr>
<td width='50%'> <b>pGamma</b> </td><td width='50%'> Exponent of the average ponderal slope of a basin to calculate the average access time to the network  for area units. [-] </td>
</tr>
<tr>
<td width='50%'> <b>pEspInflux</b> </td><td width='50%'> Exponent of the influx coefficent to calculate the average residence time in the network . [-] </td>
</tr>
<tr>
<td width='50%'> <b>pFranco</b> </td><td width='50%'> Minimum dig depth, for rectangular or trapezium pipe. <a href='m.md'>m</a> </td>
</tr>
<tr>
<td width='50%'> <b>pA</b> </td><td width='50%'>  Coefficient of the pluviometric curve of possibility. [-] </td>
</tr>
<tr>
<td width='50%'> <b>pN</b> </td><td width='50%'> Exponent of the pluviometric curve of possibility.  [-] </td>
</tr>
<tr>
<td width='50%'> <b>pTau</b> </td><td width='50%'> Tangential bottom stress, which ensure the self-cleaning of the network. [N/m2] </td>
</tr>
<tr>
<td width='50%'> <b>pG</b> </td><td width='50%'> Fill degree to use during the project. [-] </td>
</tr>
<tr>
<td width='50%'> <b>pAlign</b> </td><td width='50%'> Align mode, it can be 0 (so the free surface is aligned through a change in the depth of the pipes) or 1 (aligned with bottom step). </td>
</tr>
<tr>
<td width='50%'> <b>inDiameters</b> </td><td width='50%'> Matrix which contains the commercial diameters of the pipes. </td>
</tr>
<tr>
<td width='50%'> <b>pOutPipe</b> </td><td width='50%'> The outlet, the last pipe of the network,. [-] </td>
</tr>
<tr>
<td width='50%'> <b>tDTp</b> </td><td width='50%'> Time step to calculate the discharge in project mode. [-] </td>
</tr>
<tr>
<td width='50%'> <b>tpMin</b> </td><td width='50%'> Minimum Rain Time step to calculate the discharge. [-] </td>
</tr>
<tr>
<td width='50%'> <b>tpMax</b> </td><td width='50%'> Maximum Rain Time step to calculate the discharge. <a href='minutes.md'>minutes</a> </td>
</tr>
<tr>
<td width='50%'> <b>tMax</b> </td><td width='50%'> Max number of time step. [-] </td>
</tr>
<tr>
<td width='50%'> <b>tpMaxCalibration</b> </td><td width='50%'> Maximum Rain Time step to evaluate the Rain in calibration mode. <a href='minutes.md'>minutes</a> </td>
</tr>
<tr>
<td width='50%'> <b>dt</b> </td><td width='50%'> Time step, if pMode=1, in minutes. Is the step used to calculate the discharge. If it's not setted then it's equal to the rain time step. <a href='minutes.md'>minutes</a> </td>
</tr>
<tr>
<td width='50%'> <b>inRain</b> </td><td width='50%'> rain data. </td>
</tr>
<tr>
<td width='50%'> <b>inPipes</b> </td><td width='50%'> The read feature collection. </td>
</tr>
</table>

<h3>Output parameters</h3>
<table cellpadding='10' width='70%' border='1'>
<tr>
<td width='50%'> <b>outPipes</b> </td><td width='50%'> The output feature collection which contains the net with all hydraulics value. </td>
</tr>
<tr>
<td width='50%'> <b>outDischarge</b> </td><td width='50%'> The output if pTest=1, contains the discharge for each pipes at several time. </td>
</tr>
<tr>
<td width='50%'> <b>outFillDegree</b> </td><td width='50%'> The output if pTest=1, contains the fill degree for each pipes at several time. </td>
</tr>
<tr>
<td width='50%'> <b>outTpMax</b> </td><td width='50%'> The time which give the maximum discharge. <a href='minutes.md'>minutes</a> </td>
</tr>
</table>

<h2>Example result</h2>

<img src='http://wiki.jgrasstools.googlecode.com/git/images/hortonmachine/trentop.png' alt='TrentoP' />
<br>
<h2>Developer example</h2>

An example usage of the algorithm can be found in the testcases suite:<br>
<a href='http://code.google.com/p/jgrasstools/source/browse/hortonmachine/src/test/java/org/jgrasstools/hortonmachine/models/hm/TestTrentoP.java'>TrentoP</a>