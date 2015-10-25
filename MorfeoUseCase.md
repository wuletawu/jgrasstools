

# Introduction #

Morfeo is a project of the [University of Trento, Faculty of Engineering](http://www.ing.unitn.it), and the Italian Space Agency, in which JGrass was used to do simulations for landslide risk through the [geotop](http://www.geotop.org) model. JGrass itself was used for a whole pile of tasks, but interesting in this page is the use of the edc library. In fact JGrass uses the edc library for the production of the model's input data, retrieving them from centralized sources.

# Some details about the edc tables #

The edc database design contains three schemas:
  * edc: here all the general tables reside
  * edcseries: place for temporal data tables
  * edcgeometries: place for geographic data tables

## Points of interest ##

The POI table contains all the elements on the territory that can supply any type of environmental relevant information.
For example those can be:
  * meteo data monitoring stations
  * hydrometers
  * dams
  * offtakes
  * tributary nodes

To every poi the information of its location is connected as well as the technical specs of the present sensors and the registered data.

![http://wiki.jgrasstools.googlecode.com/hg/images/edc/monitoringpoints.png](http://wiki.jgrasstools.googlecode.com/hg/images/edc/monitoringpoints.png)

### Offtakes ###

![http://wiki.jgrasstools.googlecode.com/hg/images/edc/offtakes.png](http://wiki.jgrasstools.googlecode.com/hg/images/edc/offtakes.png)

### Reservoirs ###

![http://wiki.jgrasstools.googlecode.com/hg/images/edc/reservoirs.png](http://wiki.jgrasstools.googlecode.com/hg/images/edc/reservoirs.png)

### Hydrometers ###

![http://wiki.jgrasstools.googlecode.com/hg/images/edc/hydrometers.png](http://wiki.jgrasstools.googlecode.com/hg/images/edc/hydrometers.png)


## Gridded datasets and Ramadda ##

In order to be able to centralize gridded datasets, a joined effort of postgres (or H2) and Ramadda was used.

[Ramadda, as its homepage states](http://www.unidata.ucar.edu/software/ramadda/), is _a comprehensive content repository, publishing platform and collaboration environment for the Earth Sciences. Features include:_

  * _Data file ingest, organization, meta-data creation and access control._
  * _Search and browse capabilities._
  * _Catalog and RSS feeds._
  * _Data services including OpenDAP, subsetting and point data access._
  * _Wiki facilities_

One important feature of Ramadda is the possibility to have an API to upload and download as well as organize datasets and having them served via opendap protocol.

I'll never thank enough Jeff McWhirter from the Ramadda team first of all for having created Ramadda and definitely also for the kind support and the enhancements done to the client api to help JGrass to get connected to Ramadda. Let's see how these two projects now are able to connect.

In edc the gridded datasets are described with a minimum set of metadata in the database map tables, but the really stored in the Ramadda repository. Since the project uses netcdf as its base format, using Ramadda has been really straightforward.

The db tables are the following:

![http://wiki.jgrasstools.googlecode.com/hg/images/edc/eo.png](http://wiki.jgrasstools.googlecode.com/hg/images/edc/eo.png)

## Interacting with Ramadda from JGrass ##

JGrass has some generic wizards to up- and download or just view datasets from Ramadda.

### Download data from Ramadda through Edc ###

From JGrass you can select the import wizard and you find the edc entry:

![http://wiki.jgrasstools.googlecode.com/hg/images/edc/edc_jgrass_import.png](http://wiki.jgrasstools.googlecode.com/hg/images/edc/edc_jgrass_import.png)

Selecting that, you are presented the option to view or download from the edc gridded datasets tables, as mentioned in the above section.

![http://wiki.jgrasstools.googlecode.com/hg/images/edc/edc_jgrass_import_2.png](http://wiki.jgrasstools.googlecode.com/hg/images/edc/edc_jgrass_import_2.png)

You then can decide to view it through opendap connection or to download the dataset in local and again view or use it.

![http://wiki.jgrasstools.googlecode.com/hg/images/edc/edc_jgrass_import_3.png](http://wiki.jgrasstools.googlecode.com/hg/images/edc/edc_jgrass_import_3.png)


### Upload data to Ramadda through Edc ###

The same way as for downloading, it is also possible to upload datasets to Ramadda, obviously following the predefined structure of premitted maps.

By selecting the Export wizard, you find the edc entry;

![http://wiki.jgrasstools.googlecode.com/hg/images/edc/edc_jgrass_export.png](http://wiki.jgrasstools.googlecode.com/hg/images/edc/edc_jgrass_export.png)

After that, to upload data, a minimum of metadata have to be supplied.

![http://wiki.jgrasstools.googlecode.com/hg/images/edc/edc_jgrass_export_2.png](http://wiki.jgrasstools.googlecode.com/hg/images/edc/edc_jgrass_export_2.png)

Ramadda extracts other metadata from the dataset, and they can be browsed through the great web interface:

![http://wiki.jgrasstools.googlecode.com/hg/images/edc/ramadda_metadata.png](http://wiki.jgrasstools.googlecode.com/hg/images/edc/ramadda_metadata.png)