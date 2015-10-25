

# Introduction #

Since the Horton Machine has to obey the laws of geotools, OMS3 and some other projects, some coding conventions are necessary to make usage in scripting environments easier and more intuitive.
Also the way of defining field names aims to help environments that are able to supply syntax coloring or command completion, as JGrass for example does.

# Packaging conventions #

## Horton Machine ##

The [Horton Machine](HortonMachine.md) project has quite simple convention. Apart of the bases namespace **eu.hydrologis.jgrass.hortonmachine**, all the modules are the held inside the **modules** package.

The modules are split into logical subsections, as for example:
  * geomorphology
  * network
  * basin
  * ..etc.

and then inside that every module has a package named after the module. This is done to better contain complex modules that are made up of several files

## JGrassgears ##

In this case the modules can be more generic than the Horton Machine ones and serve small contained purposes. The only logical subdivision that is done here is by the return type of the modules, **raster (coverage)** or **vector (feature)**.
Therefore in the base package **eu.hydrologis.jgrass.jgrassgears** we have a package **modules** which contains two further packages, **r** and **v**, for raster and vector modules.

# Components Fields in modules #

## Fields have to be public ##

Due to restrictions given by OMS3 compatibility (which heavily relies on reflection techniques), we are forced to keep the fields of the Classes **public**. That isn't a big issue, but it has to be known: if you want to be able to connect your module through OMS3, all the connecting fields have to be defined public.

For further descriptions about OMS3 coding techniques, we will soon link to the OMS3 manual from here.

## Input and output fields ##

Fields defining an **input** should all start with the prefix **in** and then have a short name attached. It is assumed that the full description of the field is held in the module documentation, so the field name is really a recall to that.

The construct is therefore: _**in**_Name

Example Pitfiller:

```
    @Description("The digital elevation model (DEM) on which to perform pitfilling.")
    @In
    public GridCoverage2D inDem;
```

Likewise fields defining an **output** should start with **out** and a name attached.

The construct is therefore: _**out**_Name

Example from Pitfiller:

```
    @Description("The depitted digital elevation model.")
    @Out
    public GridCoverage2D outPit = null;
```

Were possible the same names should be used. One good example are the FlowDirection and DrainDir modules, which both produce a map of flowdirections.
In that case both modules have:

```
    @Description("The map of flowdirections.")
    @Out
    public GridCoverage2D outFlow = null;
```

In those cases in which the input and output do not have a particular purpose, as it might be for example when reprojecting a raster or a vector file, the proposed name for rasters (gridcoverages) are:

```
    @Description("The raster to be processed (you description goes here).")
    @In
    public GridCoverage2D inRaster = null;

    @Description("The processed output raster (you description goes here).")
    @Out
    public GridCoverage2D outRaster = null;
```

and for vectors (features) are:

```
    @Description("The vector to be processed (you description goes here).")
    @In
    public SimpleFeatureCollection inVector = null;

    @Description("The processed output vector (you description goes here).")
    @Out
    public SimpleFeatureCollection outVector = null;
```


## Parameters ##

In order to make parameter fields distinguish from input and output fields, they start with a **p**, which results in a construct like: _**p**_Name

Example from DrainDir:

```
    @Description("The direction correction factor.")
    @In
    public double pLambda = 1.0;
```

## Switches ##

Switches are thought a bit differently then parameters and have their own construct: _**do**_Name

Being boolean statements, they define whether to do somthing or do not.

Example from Aspect:

```
    @Description("Switch to define whether create the output map in degrees (default) or radiants.")
    @In
    public boolean doRadiants = false;
```

## Field Attributes ##

Field names of a feature attribute table have their own construct: _**f**_Name

They are used to defined parameters that describe the name of a field of an attribute table of a feature collection.

Example from Jami:

```
    @Description("The field name of the attribute table that holds the station id.")
    @In
    public String fStationid;

    @Description("The field name of the attribute table that holds the station elevation.")
    @In
    public String fStationelev;
```


## Time ##

Temporal parameters should have the name following the construct: _**t**_Name
and should be defined as strings in the **yyyy-mm-dd hh:mm** format.
The timestep is usually defined as in **int** and meant to be in minutes.

Example from Jami:

```
    @Description("The current time variable.")
    @In
    public String tCurrent = null;
```


Example from Energybalance:

```
    @Description("The timestep in minutes.")
    @In
    public int tTimestep;

    @Description("The end date.")
    @In
    public String tEnd = null;
```


In the case of internal timesteps different from the main time cycle, time variables are handled like parameters.

Example from Energybalance:

```
    @Description("Internal timestep in minutes for the model.")
    @In
    public double pInternaltimestep = 1;
```

## Use Unit and Range annotations where possible ##

Were appropriate always supply information about the Unit of the parameter and the Range of the parameter. This will supply more info in the documentationand guis, but also enable runtime checks. It's a win-win.

Example:

```
    @Description("Minimum discharge in a pipe")
    @Unit("m3/s")
    @Range(min = 0)
    @In
    public double pMinDischarge = DEFAULT_MIN_DISCHARGE;
```


# Renderedimages, Iterators, Gridcoverages and Writablerasters #

The raster handling of the Horton Machine is based on geotools **GridCoverage2D** which builds on the Jai/imageio library and results in using RenderedImages, RandomIterators and Writablerasters. These happens very often for modules that do raster processing and often this brings to duplication of names, and use of temporary names with no sense.

A small rule can be of help here. We never (should) use raster, map or similar generic names for the variables, which do not describe the content of the variable.

Also we use for a map called **name**:

  * name_**RI**_: for the RenderedImage
  * name_**Iter**_: for the iterator on that image
  * name_**WR**_: for a writable raster
  * name_**GC**_: for a grid coverage
  * name_**FC**_: for a featurecollection

Example from Aspect:
```
        RenderedImage elevationRI = inDem.getRenderedImage();
        RandomIter elevationIter = RandomIterFactory.create(elevationRI, null);

        WritableRaster aspectWR = CoverageUtilities.createDoubleWritableRaster(cols, rows, null, null, null);
        WritableRandomIter aspectIter = RandomIterFactory.createWritable(aspectWR, null);
```

# Floating point comparison #

Since floating point comparison depends from too many factors, and we want it to be consistent on every machine, OS and compiler, we have our own double and float comparison methods.

So please, don't do things like:
```
double a = 1.000000001;
double b = 1.0;

if(a == b){
...
}
```

instead use the class [NumericsUtilities](http://code.google.com/p/jgrasstools/source/browse/jgrassgears/src/main/java/org/jgrasstools/gears/utils/math/NumericsUtilities.java).

For example for the above doubles you would have

```
if(dEq(a, b)){
    // this would happen
}
if(dE(a, b, 1E-10)){
    // this would NOT happen
}
```

# Eclipse users #

## Formatting ##

If you are used to use automatic formatting through your IDE, please use the right formatting for this project. We use [this file](http://www.hydrologis.com/devel/eclipse_formatter.xml) for eclipse.