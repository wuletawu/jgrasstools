# Introduction #

Once a new module has been added to the framework and it is the time to check its deployment in uDig's Spatial Toolbox or in any Oms3 compliant environment, the Maven project has to be bundled in a new .JAR.


# Details #

The JGrassTools are a Maven project composed of two main sub-project: the JGrass Gears and the Horton Machine.
Main development currently occurs in the latter as additions of new models, but what reported to follow also applies to the Gears part.

## Notifying the ServiceGenerator ##

First of all you should be aware that just properly adding OMS annotations to a new module is **not enough to have it recognized in the uDig Spatial Toolbox**.
The reason lies in the fact that the Spatial Toolbox uses a service to reduce module loading time.

This means that only modules listed in service file are actually seeked.
There are two of these text files (with the same name): one inside the  JGrassGears sub-project and one inside the Horton Machine tree:


```
/jgt-hortonmachine/src/main/resources/META-INF/services/org.jgrasstools.gears.libs.modules.JGTModel
```
[see the file in source repository](https://code.google.com/p/jgrasstools/source/browse/hortonmachine/src/main/resources/META-INF/services/org.jgrasstools.gears.libs.modules.JGTModel)

```
/jgt-jgrassgears/src/main/resources/META-INF/services/org.jgrasstools.gears.libs.modules.JGTModel
```

Each new module has to be advertised inside one of these files with its fully qualified name in order to be available in the uDig Spatial Toolbox.

As an example, the OmsSlope module is reported in the first of the two files as:
```
org.jgrasstools.hortonmachine.modules.geomorphology.slope.OmsSlope
```

## Exporting the JAR file ##

Please note that the first time you are exporting a new .JAR containing your new module, you will need to first follow instruction to build the full project that is composed by the three sub-projects oms3, jgrassgears and hortonmachine.
This way all dependencies of the hortonmachine sub-project will be compiled and made available in your local Maven repository for further compilations of just the hortonmachine.
Instruction are provided here: https://code.google.com/p/jgrasstools/wiki/Building

In order to 'export' a new Jar containing all old and new modules of the Horton Machine project, open a prompt in the `\hortonmachine\` folder (not in the JGrassTools root, where the whole source was first cloned!), and launch:

```
mvn package
```
or, to skip tests:
```
mvn package -Dmaven.test.skip=true
```

This will create a new jar in the `\hortonmachine\target\` folder whose name will be the one declared in the `\hortonmachine\pom.xml` file, inside the `<version>` node within the following tree branch:

```
	<groupId>org.jgrasstools</groupId>
	<artifactId>jgt-hortonmachine</artifactId>
	<version>0.7.7-SNAPSHOT</version>    
	<packaging>jar</packaging>
	<name>The Horton Machine</name>
```

The result will be a file named `hortonmachine\target\`**0.7.7-SNAPSHOT.jar**

Keep in mind that uDig gains a lock on the file while using it (even when the Spatial Tool box has been closed after use)..

..so packing a new file with uDig open will silently fail and you will end up by using the old version.