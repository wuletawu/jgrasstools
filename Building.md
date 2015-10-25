
## Get the source code ##

Get the source code from [the checkout page](http://code.google.com/p/jgrasstools/source/checkout).
You should end up having a jgrasstools folder containing the folders of the 3 subprojects:
  * hortonmachine
  * jgrassgears
  * oms

+ an extra folder which contains deployment utilities.

## Maven version ##

I have made my tests with:

```
Maven version: 2.0.9
Java version: 1.6.0_14
OS name: "linux" version: "2.6.32-24-generic" arch: "amd64" Family: "unix"
```

and

```
Apache Maven 2.2.1 (r801777; 2009-08-06 21:16:01+0200)
Java version: 1.6.0_23
Java home: C:\Program Files\Java\jdk1.6.0_23\jre
Default locale: it_IT, platform encoding: Cp1252
OS name: "windows 7" version: "6.1" arch: "amd64" Family: "windows"
```

## How to build ##

The best way to build jgrasstools is from the root folder, in order to make maven take care about the build order of the various projects.

So enter the root folder and issue the command:
```
mvn install
```

That will build the project, execute the tests and install the resulting jar into the local repository of the user (usually **~/.m2**).

If the release is not stable, tests may fail to pass, so blocking the process. In this case you might want to build without running the tests with:
```
mvn install -Dmaven.test.skip=true
```



Should there be some strange error in building from the root folder, then try by running first:
```
mvn install -N
```

and only then the build as explained before.


## How to build the projects for development in your ide ##

### Eclipse ###

If you are an [eclipse](http://www.eclipse.org) user, just run:

```
mvn eclipse:eclipse
```

from the root folder of jgrasstools. This will create the eclipse projects that can then be imported into eclipse through:

```
File  -> Import -> General -> Existing Projects into Workspace
```

#### The M2\_REPO system variable ####

As soon as you open the project you will realize Eclipse is complaining about missing dependencies: this happens since Eclipse cannot track the position of your local Maven repository containing all jars you project is dependent on.
Hence you must create, in Eclipse, a _classpath variable_ called exactly **M2\_REPO** that must point to your local Maven repository. This can be done selecting “Window/Preferences” and searching for “Classpath Variables”. The folder containing your local Maven repository is usually under the user folder and is called .m2 .
Under Unix system is /home/myUserName/.m2/repository
Unde Windows 7 is C:\Users\myUserName\.m2\repository

#### Dependencies Javadoc (and Source) in Eclipse ####

Many times it can be useful to have dependencies Javadocs or even Source code at hand in Eclipse while coding. Maven makes this as simple as building the Eclipse project with a couple of flags:

```
mvn eclipse:eclipse -DdownloadSources=true -DdownloadJavadocs=true
```

Each flag can also be used alone.
Beware of consequences on project disk size: source code can be huge!

### Netbeans ###

Netbeans should by default be able to recognize the maven project structure, so you should be able to import the project easily.

(If a netbeans user would be so kind to send me instructions, I will be glad to add them here)


## Maven quickstart ##

To get started with maven you could visit the [maven quickstart guide](http://maven.apache.org/guides/getting-started/maven-in-five-minutes.html).