

# Introduction #

To use JGrasstools as a commandline application, it is necessary to get the hands dirty in scripting. The supported scripting languages are the following:
  * Groovy
  * Geoscript
  * OMS3 simulations scripting

This page will focus on the OMS3 related scripting, since for groovy and geoscript lot's of documentation is already available.

  * [Groovy homepage](http://groovy.codehaus.org/)
  * [Geoscript examples page](http://geoscript.org/examples/)

# Get the software #

The JGrasstools package can be found on the [download page](http://code.google.com/p/jgrasstools/downloads/list) as a zipped file named like: `jgrasstools-VERSION.zip`.

Once downloaded and unzipped in a folder of choice, the following files will be present:
  * libs
  * modules
  * jgrasstools.bat
  * jgrasstools.sh
  * README

The only files of interest to a user are the jgrasstools _bat_ and _sh_ files, which are used to execute scripts on Linux and Macosx (_sh_) and on Windows (_bat_).

Once the user knows which one of the two to choose, he is ready to get rumble.

Please note that SNAPSHOT versions may not exhibit the above structure as they do not come with all required libs. Also `jgrasstools.bat` / `jgrasstools.sh` may not be included in SNAPSHOTS.

# Setting memory (all scripting languages) #

The amount of memory you make available to the JVM for running your scripts is, currently, hard coded in `jgrasstools.bat` / `jgrasstools.sh` files.

Check in those files for the lines `set MEM="-Xmx1g"` (windows) or `MEM="-Xmx2g"` (linux) and change them according to your needs.

Valid values can be espressed also in megabytes as in `"-Xmx1536m"` or `"-Xmx2560m"`.

# Scripting in JGrasstools #

## Groovy ##

To get started and also test how the downloaded software works, we will begin with a small groovy script.

Let's place the following content in a file and name the file **test.jgt** (any name will do and also any extension):
```
def here = new File(".");
here.listFiles().each{ file ->
  if(file.isDirectory()){
    println file.name + " is a folder";
  } else {
    println file.name + " is a file";
  }
}
```

try to run the script by running:
```
.\jgrasstools.bat .\test.jgt
```

the result should be the list of files in the folder:
```
jgrasstools.bat is a file
jgrasstools.sh is a file
libs is a folder
modules is a folder
README is a file
test.jgt is a file
```

That is all we will cover about groovy here, for further documentation about this incredibly powerful language, please refer [to its homepage](http://groovy.codehaus.org/).

## Geoscript ##

Geoscript is a great effort to get to a common geographic scripting language. Since there is a groovy version available, it can naturally run inside the JGrasstools scripts engine. I won't focus on this, since there are a lot of examples available on the geoscript website, but just to give an idea, paste the following into the same file **test.jgt**:

```
import geoscript.geom.*
import geoscript.proj.Projection

pLatLong = new Point(11.0, 46.0)
pUtmZone32N = Projection.transform(pLatLong, 'epsg:4326', 'epsg:32632')

println """
    Reprojected lat/long point: ${pLatLong}
    to UTM zone 32 north: ${pUtmZone32N}
"""
```

and run the script:
```
.\jgrasstools.bat .\test.jgt
```

The script reprojects a coordinate and prints the result:
```
    Reprojected lat/long point: POINT (11 46)
    to UTM zone 32 north: POINT (4830425.064145468 1514647.8173726583)
```

The [geoscript example page](http://geoscript.org/examples/index.html) has a lot of fancy examples: you should check it out.

## OMS3 scripting ##

OMS3 and the JGrasstools relate to each other in the sense that every single JGrasstools module is annotated the OMS3 way. As such it is possible to script and run it the OMS3 way.

I probably should not say it, but this is also a way to use the jgrasstools library for doing heavy multithreaded serverside processing.

OMS3 scripting can be used for complex linking of modules and environmental models. The power of being able to chain environmental models comes with the price of a syntax that needs to be learned.

Let's see how that works.

### Running Pitfiller the OMS3 way ###

To show how things work, we will propose the something very simple to start with and then take it a bit more into advanced. In the first part we will simply execute the pitfiller algorithm to remove sinks from a DTM.

We will proceed step by step, explaining the pieces as they are added.

#### The simulation blueprint ####

All simulations have a given structure:

```
// creation of the simulation object
sim = new oms3.SimBuilder(logging:'OFF').sim(name:'pitfiller') {
   // the model space
   model {
      // space for the definition of the acting components
      components  {

      }
      
      // initialization of the parameters
      parameter  {

      }

      // connection of the different components
      connect  {

      }
   }
}
// start of the simulation
sim.run();
```

As you note, comments can be written by prefixing the line containing it with two slashes.

#### Declaring components ####

To declare components, we can use the documentation of the modules on the site. For example to run pitfiller we will need to do 3 things:
  1. read an elevation model
  1. calculate pit
  1. write the resulting pit map

To find the component names to use we can have a look to the component's page. For example the [Pitfiller](Pitfiller.md) documentation has a line reporting **Name to use in a script: pit** under the chapter **General Information**.

This gives us the information we need to fill in the variable name (for example here we choose _pitfiller_) and the name to use for the module:
```
      components  {
	'pitfiller'	    'pit'
      }
```

Following the same steps for the [raster reader](RasterReader.md) and [writer](RasterWriter.md), we finally get the _components_ part completed:
```
      components  {
	'pitfiller'	    'pit'
	'reader'	    'rasterreader'
	'writer'	    'rasterwriter'
      }
```

#### Defining parameters ####

Each component has parameters that need to be defined, as for example the file path to the raster to read or to write. Readers can also take clipping bounds or particular resolutions to use. In this case we just read the file as it is and leave eveything else as default.

On the documentation page of every module a table with the input and output parameters is found. It is easy to find the names for the file parameter for the raster reader and writer and assign them:
```
      parameter  {
	'reader.file'       'D:\\data\\spearfish60new\\user1\\cell\\dtm'
	'writer.file'       'D:\\data\\spearfish60new\\user1\\cell\\pit'
      }
```


Most of the time you might want to define the path and calculated variables in the header of the script before passing them into the simulation. Since we can write pure java or groovy, that is fairly simple and would look like:

```
      def folder = "D:\\data\\spearfish60new\\user1\\cell\\"
      def dtm = folder + "dtm"
      def pit = folder + "pit"


      parameter  {
	'reader.file'       dtm
	'writer.file'       pit
      }
```

The same way you can make any java object enter the simulation as a parameter:

```
      def data = myDataPreProcessingModule.gatherData()

      parameter  {
	'mymodule.data'       data
      }
```


#### Connecting components ####

Last thing to do is to connect the modules, i.e. make the read raster go into the pit module, and make the processed pit map go into the writer module:
```
      connect  {
	'reader.outRaster'  'pitfiller.inElev'
        'pitfiller.outPit'   'writer.inRaster'
      }
```

### Running the complete script ###

The complete and functional script looks like:

```
sim = new oms3.SimBuilder(logging:'ALL').sim(name:'pitfiller') {
   model {
      components  {
	'pitfiller'	    'pit'
	'reader'	    'rasterreader'
	'writer'	    'rasterwriter'
      }

      parameter  {
	'reader.file'       'D:\\data\\spearfish60new\\user1\\cell\\dtm'
	'writer.file'       'D:\\data\\spearfish60new\\user1\\cell\\pit'
      }

      connect  {
	'reader.outRaster'  'pitfiller.inElev'
        'pitfiller.outPit'   'writer.inRaster'
      }

   }
}
sim.run();
```

save the above script in the usual **test.jgt** file and execute it with:
```
.\jgrasstools.bat .\test.jgt
```


#### Accessing the simulation variables ####

In case it is necessary to access variables produced during the simulation, it is possible to do so through the _**result**_ object returned by the simulation's run method.

```
// execute the sim requesting a retun object
result = sim.run();

// the result object can access simulation objects (in this case the read raster)
result.reader.inRaster
```


### Linking modules together ###

While scripting the OMS3 way might seem verbose and overkill against groovy and geoscript, there is a good reason for it. The OMS3 scripting language was designed mainly to make complex models interact, piping dataflow from one module into the other, being it on a timedependent or not. It therefore finds its moments of glory when that technique is used.

To give an introduction on how this works, we will now link together two modules the OMS3 way, pitfiller and flow, in order to obtain the map of flowdirections directly from the elevation model.

We start from the pitfiller script:
```
sim = new oms3.SimBuilder(logging:'ALL').sim(name:'pitfiller') {
   model {
      components  {
	'pitfiller'	    'pit'
	'reader'	    'rasterreader'
	'writer'	    'rasterwriter'
      }

      parameter  {
	'reader.file'       'D:\\data\\spearfish60new\\user1\\cell\\dtm'
	'writer.file'       'D:\\data\\spearfish60new\\user1\\cell\\pit'
      }

      connect  {
	'reader.outRaster'  'pitfiller.inElev'
        'pitfiller.outPit'   'writer.inRaster'
      }

   }
}
sim.run();
```

Basically what we want to do is to get the depitted map from the pit module and pipe it into flow. Then take the processed map of flowdirections and write it down. Well, the only thing we need to know how the flowdirections module and its input and output parameters named. A quick look at the FlowDirections page tells us what we need:

  * Name to use in a script: flow
  * Input parameters: inPit - The depitted elevation map
  * Output parameters: outFlow - The map of flowdirections

which suggests us to modify the script to be:

```
sim = new oms3.SimBuilder(logging:'ALL').sim(name:'flow') {
   model {
      components  {
	'pitfiller'         'pit'
	'flowdirections'    'flow'
	'reader'            'rasterreader'
	'writer'            'rasterwriter'
      }

      parameter  {
	'reader.file'       'D:\\data\\spearfish60new\\user1\\cell\\dtm'
	'writer.file'       'D:\\data\\spearfish60new\\user1\\cell\\flow'
      }

      connect  {
	'reader.outRaster'         'pitfiller.inElev'
        'pitfiller.outPit'         'flowdirections.inPit'
        'flowdirections.outFlow'   'writer.inRaster'
      }

   }
}
sim.run();
```

This will calculate pit, then feed the output to the flow module. Flow will do its processing and feed the output map into the writer.

This is obviously a very simple example, but the OMS3 scripting gives the possibility to chain together ina very complex manner modules, giving great flexibility over processing.

### Viewing the results ###

To view the results of you processing you should use a GIS. JGrasstools naturally bounds to the [uDig GIS](http://udig.refractions.net/). There is also an effort ongoing to integrate the processing power of jgrasstools into uDig ([have a look here for further info](http://code.google.com/p/jgrass/wiki/jgrass4udig)).

Anyways it can be handy to have a quick look at the result of a calculation. In the above case we would like to see if the created flow map really looks like a flow map. For this we can use the MapsViewer module. We will leave to the user to check the name and component on its docs page.

Anyways the thing to note is that the output of a module can be sent to different other modules:
```
sim = new oms3.SimBuilder(logging:'ALL').sim(name:'flow+viewer') {
   model {
      components  {
	'pitfiller'         'pit'
	'flowdirections'    'flow'
	'reader'            'rasterreader'
	'writer'            'rasterwriter'
        'viewer'            'mapsviewer'
      }

      parameter  {
	'reader.file'       'D:\\data\\spearfish60new\\user1\\cell\\dtm'
	'writer.file'       'D:\\data\\spearfish60new\\user1\\cell\\flow'
      }

      connect  {
	'reader.outRaster'         'pitfiller.inElev'
        'pitfiller.outPit'         'flowdirections.inPit'
        'flowdirections.outFlow'   'writer.inRaster'
        'flowdirections.outFlow'   'viewer.inRaster' 
      }

   }
}
sim.run();
```