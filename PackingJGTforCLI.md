

# Introduction #

The procedure to build and package a JGrassTools sub-module into a JAR, described in [JGTExporting](JGTExporting.md), does not deliver an environment suitable for easy command line usage but just .jars that can be adopted, for example, in the uDige Spatial Toolbox.
In this page we will show how to pack it JGrassTools and its dependencies for CLI usage.


# Details #

The key element that allows the procedure is the Groovy script:
`<jgt-root>/extras/deploy/deploylibs.groovy`

This script uses the dependencies of the Maven JGT project to copy from your local Maven repository, usually located in <user.home>/.m2/repository/ , all required .jars and bundle them with the most recently compiled JGT .jars into a single .zip file, for usage as described in [JGrassTools4CLI](JGrassTools4CLI.md).

This means that first, the project has to be built, as described in [JARExporting](JARExporting.md) since the script will seek in sub-modules `target` dirs for most recent JGT .jars.

|Please note that the current version of the script expects **you are using Maven 3.x**. In the case you are still on Maven 2, you have to edit it and switch the active code blocks: a Maven 2 code is there for you!|
|:--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|

Secondly, the most recent [Groovy](http://groovy.codehaus.org/Download) environment must be installed and configured locally.

Once the `groovy` executable is available in the system path, the packaging gets as simple as:
  1. fixing in the `./extras/deploy/deploylibs.groovy` file the VERSION variable so to match the actual packaged version;
  1. opening a prompt in the JGrassTools ROOT folder (not in the extras/deploy/ folder!);
  1. launching the Groovy script with:
```
groovy ./extras/deploy/deploylibs.groovy```

The `lib` and `modules` folders will be created beside the Groovy script. JGT .jars will be copied in `modules` while .jar dependencies in `lib` then everything will be zipped.

This will take some time but, at the end, a new `jgrasstools-<VERSION>.zip` will be created in the same folder of the Groovy script.
This file can be used as described in [JGrassTools4CLI](JGrassTools4CLI.md).