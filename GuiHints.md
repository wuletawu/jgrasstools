

# Introduction #

The OMS3 annotations can be used to generate graphical user interfaces.
Obviously a string field in a gui can be presented in many ways: a textfield, textarea, a list...
To be able to give better control over the type of field, gui hints have been introduced.

A description of the various used annotations is presented, with examples on how in the case of the [OmsBox](http://code.google.com/p/jgrass/wiki/jgrass4udig), this is used.

# The @Label annotation #

The label annotation can be used to label the module to foster aggregation in a gui environment. For example omsbox uses it to create categories.

Input/output modules. These are used in the omsbox to access data for the other modules. They are usually placed behind buttons (for example to browse for a file). Currently omsbox recognises and handles the following I/O categories:

  * "Raster Processing"
  * "Vector Processing"
  * "Generic Reader"
  * "Generic Writer"
  * "HashMap Data Reader"
  * "HashMap Data Writer"
  * "List Data Reader"
  * "List Data Writer"
  * "Raster Reader"
  * "Raster Writer"
  * "Vector Reader"
  * "Vector Writer"

Categories for the modules. This can be anything, as for example:

  * "Vector Processing"
  * "Raster Processing"

which might result in:

<p align='center'><img src='http://wiki.jgrasstools.googlecode.com/git/images/uiannotations/categories.png' alt='categories' /></p>

You can also define subcategories through the use of a slash (/), as for example:

  * "HortonMachine/Basin"
  * "HortonMachine/Dem Manipulation"
  * "HortonMachine/Geomorphology"
  * "HortonMachine/Hydro-Geomorphology"
  * "HortonMachine/Hillslope"
  * "HortonMachine/Network"
  * "HortonMachine/Statistics"


which might result in:

<p align='center'><img src='http://wiki.jgrasstools.googlecode.com/git/images/uiannotations/subcategories.png' alt='subcategories' /></p>


Whatever is left without category, is placed into the others category:

  * "Others"

# The @UI annotation #

The @UI annotation can give additional information about what the widget will contain, giving the gui application the possibility to tweak it to its needs.

## on classes ##
### @UI("hide") ###
Identifies a module that should not be presented in the gui. This might for example be due to the fact that the module is experimental.

### @UI("iterator") ###
Identifies a module that iterates over time.


## on fields ##
### @UI("infile") ###
Identifies a field that will contain an input (has to exist) file. The textfield should present a button to browse the filesystem in open mode.

<p align='center'><img src='http://wiki.jgrasstools.googlecode.com/git/images/uiannotations/infile.png' /></p>

### @UI("outfile") ###
Identifies a field that will contain an output (parent folder has to exist) file. The textfield should present a button to browse the filesystem in save mode.

<p align='center'><img src='http://wiki.jgrasstools.googlecode.com/git/images/uiannotations/outfile.png' /></p>

### @UI("infolder") ###
Identifies a field that will contain an input (has to exist) folder. The textfield should present a button to browse the filesystem in open mode.

### @UI("outfolder") ###
Identifies a field that will contain an output (parent folder has to exist) folder. The textfield should present a button to browse the filesystem in save mode.

### @UI("crs") ###
Identifies a fields that contains a coordinate reference system (CRS) definition. The textfield should present a button to browse available CRS definitions.

<p align='center'><img src='http://wiki.jgrasstools.googlecode.com/git/images/uiannotations/crs.png' /></p>


### @UI("process\_XXXXX") ###
A set of annotations that identify processing region fields. Gui applications can make use of these to autocompile the properties of a processing region.

Available properties are:
  * @UI("process\_north")
  * @UI("process\_south")
  * @UI("process\_west")
  * @UI("process\_east")
  * @UI("process\_xres")
  * @UI("process\_yres")
  * @UI("process\_rows")
  * @UI("process\_cols")

<p align='center'><img src='http://wiki.jgrasstools.googlecode.com/git/images/uiannotations/process.png' /></p>


### @UI("multilineX") ###
Identifies a textarea. The X value represents the lines to use. Ex "multiline5" should create a textarea with 5 lines.

<p align='center'><img src='http://wiki.jgrasstools.googlecode.com/git/images/uiannotations/multiline.png' /></p>


### @UI("filespathlist") ###
Identifies a widget that can handle a list of files paths.

### @UI("northing") ###
Identifies a textfield that can autocompile an northing position. Gui applications might be using this to listen to mouse click poitions on a map.

<p align='center'><img src='http://wiki.jgrasstools.googlecode.com/git/images/uiannotations/coords.png' /></p>

### @UI("easting") ###
Identifies a textfield that can autocompile an easting position. Gui applications might be using this to listen to mouse click poitions on a map.

# The @Status annotation #

The status annotation give a way to define the current status of the module, which can be helpfull in production environment to present things with filters.

The available states are:
  * EXPERIMENTAL
  * DRAFT
  * TESTED
  * VALIDATED
  * CERTIFIED

<p align='center'><img src='http://wiki.jgrasstools.googlecode.com/git/images/uiannotations/experimental.png' /></p>