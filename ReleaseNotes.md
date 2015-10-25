

# version 0.7.6 (released 2012-10-22) #

This release has bugfixes and improvements for uDig Spatial Toolbox interaction.

# version 0.7.5 (released 2012-04-20) #

This release has some bugfixes, some new modules and it removes the geotools logs that were not wanted.

# version 0.7.4 (released 2012-03-25) #

Bugfix release.

# version 0.7.3 (released 2012-01-03) #

Upgrade of OMS3 to OMS3.1RC8

Several fixes on modules.

New experimental modules.

# version 0.7.2 (released 2011-07-20) #

Several fixes on modules.

New experimental modules.

Best used with the [Spatial Toolbox for uDig](http://code.google.com/p/jgrasstools/wiki/JGrassTools4udig).

# version 0.7.1 #

Compatibility fixes to align with the geotools/uDig/jaitools combo.

# version 0.7.0 (released 2011-05-16) #
## welcome ##

This is the first official release of JGrasstools. We have worked about a year prepare not only the algorithms contained in this release, but also the supporting the evolution of the OMS3 framework to gain the main objective of the JGrasstools library: the possibility to link together models in a most possible flexible way, being it along a timeline or in standalone mode, being it in complex and recursive way or in simple standalone mode.

## quality and testing ##

We put particular attention to learn from the 10 years of [JGrass](http://www.jgrass.org) development, were the worst enemies were updated developer documentation and quality checks on the code. In JGrasstools, for every module that is brought into release in certified status, it is mandatory to have a documentation page (generated from the code. Check out for example the FlowDirections page) and a testcase, which also helps developers to understand the library usage of the module (look for example at the [FlowDirections Testcase](http://code.google.com/p/jgrasstools/source/browse/hortonmachine/src/test/java/org/jgrasstools/hortonmachine/models/hm/TestFlowDirections.java)).

## a GIS implementation based on OMS3 powered by geotools ##

It is out of the scope of this announcement to explain OMS, to get informed and started on OMS3, you best [visit its website](http://www.javaforge.com/project/oms).

It is important to say that OMS3 is a pure Java, object-oriented modeling framework. OMS allows model construction and model application based on components. OMS3 is a collaborative project active among the U.S. Department of Agriculture and partner agencies and organizations involved with agro-environmental modeling.

In OMS3 components are Plain Java Objects enriched with descriptive meta data by means of **language annotations**. This _non-invasive_ approach over a modeling API minimizes dependencies on the framework. Components default to multi-threaded execution If data flows permits, components are executed in parallel, with no explicit parallel programming required. An OMS3 model scales well in current and future multi-core architectures.

Every module of JGrasstools is OMS3 annotated and based on [geotools](http://geotools.org/) raster and vector formats defined in it.

## contained modules ##

This release contains a fraction of the original JGrass modules, which have been reviewed, enhanced and cleaned up. The library is divided in two major parts:
  * the [The Horton Machine](HortonMachine.md)
  * the [JGrassGears](JGrassGears.md)

By selecting the above link, all the available modules get visible on the sidebar. The wiki pages are generated from the annotations in the code and are therefore kept strictly uptodate.

While it doesn't make much sense to list all available modules, it might be useful to link to at least a couple of important ones, like:
  * the [Peakflow](Peakflow.md) module, which calculates the maximum peak discharge using the approach of the width function
  * the [Shalstab](Shalstab.md) hillslope stability model


## usage ##

### as library ###

The JGrasstools library 0.7.0 is released in maven central. To use it in your project, have a look at [this page](http://code.google.com/p/jgrasstools/wiki/MavenRepo).

You can find instructions on how to use JGrasstools as library [on this page](http://code.google.com/p/jgrasstools/wiki/JGrassTools4Apps).

If you want to build the library yourself, [here are the instructions](http://code.google.com/p/jgrasstools/wiki/Building) to do so.

### commandline mode ###

JGrasstools can be used through groovy scripting from commandline. [This page](http://code.google.com/p/jgrasstools/wiki/JGrassTools4CLI) explains how to do so.

### from within a GIS ###

This release is not provided with a graphical user interface yet. Udig will soon support through the OmsBox the loading of not only JGrasstools libs but any kind of module-centric OMS3 annotated module. The proposal submitted  (and accepted) to the uDig community can be reviewed [here](http://code.google.com/p/jgrass/wiki/jgrass4udig).

## downloads ##

The 0.7.0 version of the JGrasstools can be [downloaded here](http://code.google.com/p/jgrasstools/downloads/detail?name=jgrasstools-0.7.0.zip).

## support and mailinglists ##

Voluntary support is supplied on the [main project's mailinglist](https://groups.google.com/group/jgrasstools?pli=1).


## 0.7.0 developers tag ##

The 0.7.0 version has been [tagged here](http://code.google.com/p/jgrasstools/source/browse/?r=jgrasstools-0.7.0).