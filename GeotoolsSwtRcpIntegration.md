This page hase been [moved to the geotools wiki](http://docs.geotools.org/latest/userguide/unsupported/swt/index.html), where it belongs.

<a href='Hidden comment: 
<wiki:toc max_depth="2" />

= Introduction =

After some discussion in the geotools mailinglist about the possibility of a [http://www.eclipse.org/swt/ SWT] port of the [http://svn.osgeo.org/geotools/trunk/modules/unsupported/swing/ geotools swing] module, [http://planetmayo.com/ Ian Mayo from the Debrief] project funded the port. He also wanted the resulting port and documentation to be Open Sourced (thanks!).

The port now lives in the unsupported space of the geotools repo and is called [http://svn.osgeo.org/geotools/trunk/modules/unsupported/gt-swt/ gt-swt]. During the port whatever possible from the swing module has been kept the same in order to help in a future extraction of common interfaces for gui modules.

The following is a tutorial that explains how to use the gt-swt module in standalone mode and inside an rcp environment. The tutorial assumes the user is already confident with geotools development/build and already an basic RCP developer.

One might ask how this all fits in the jgrasstools wiki. It kind of does, since we will probably switch to the swt module for the MapViewer utility in jgrasstools. This tutorial will probably land on the geotools wiki, where it really belongs.

= Standalone example =

Using the standalone gt-swt module is fairly easy, it is best explained with a code snippet:

```
public class Main {

    public static void main( String[] args ) throws Exception {
        // create a default mapcontext
        MapContext context = new DefaultMapContext();
        // set the title
        context.setTitle("The SWT Map is in the game");
        // add a shapefile if you like
        File shapeFile = new File("/home/moovida/data/world_adm0/countries.shp");
        ShapefileDataStore store = new ShapefileDataStore(shapeFile.toURI().toURL());
        SimpleFeatureSource featureSource = store.getFeatureSource();
        SimpleFeatureCollection shapefile = featureSource.getFeatures();
        context.addLayer(shapefile, null);

        // and show the map viewer
        SwtMapFrame.showMap(context);
    }

}
```

which results in:
<p align="center"><img src="http://wiki.jgrasstools.googlecode.com/hg/images/gt_swt/gtswt_standalone_01.png" />

Unknown end tag for &lt;/p&gt;



It is possible to tweak some of the window settings, like statusbar, layers panel and toolbars/menus. In that case just calling the helper method
```
SwtMapFrame.showMap(context);
```
isn"t enough, even if equally easy. Again a code snippet is the best way. In the following case we decide that we want to get rid of the layers panel:

```
        boolean showMenu = true;
        boolean showToolBar = true;
        boolean showStatusBar = true;
        boolean showLayerTable = false;
        final SwtMapFrame frame = new SwtMapFrame(showMenu, showToolBar, showStatusBar, showLayerTable, context);
        frame.setBlockOnOpen(true);
        frame.open();
```

which results in:
<p align="center"><img src="http://wiki.jgrasstools.googlecode.com/hg/images/gt_swt/gtswt_standalone_02.png" />

Unknown end tag for &lt;/p&gt;





= RCP example =

Well , the reason for having an SWT module is to be able to exploit a lightweight map viewer inside an RCP application, whenever the "weight" of the RCP GIS application [http://udig.refractions.net uDig] is too much.

== The Hello World RCP application ==

To integrate the gt-swt map panel inside an rcp application, we will start with an existing simple rcp hello world application that contains a view. To explain how to achieve that is beyond the aim of this tutorial, if you need help, there are a ton of tutorials out there that will guide you in that (one example is the really good [http://www.vogella.de/articles/EclipseRCP/article.html rcp tutorial by Vogella]).


== Put the map panel inside the rcp application ==

Putting the gt-swt map panel inside the view of your application, is as easy as implementing the *createPartControl* method of the view like the following:

```
    public void createPartControl( Composite parent ) {
        // handle icons, will be explained later
        handleImages();

        // create the default mapcontext
        MapContext context = new DefaultMapContext();
        context.layers();

        // create the main composite, with or without layer panel
        Composite mainComposite = null;
        if (showLayerTable) {
            SashForm sashForm = new SashForm(parent, SWT.HORIZONTAL | SWT.NULL);
            mainComposite = sashForm;
            MapLayerComposite mapLayerTable = new MapLayerComposite(mainComposite, SWT.BORDER);
            mapPane = new SwtMapPane(mainComposite, SWT.BORDER | SWT.NO_BACKGROUND);
            mapPane.setMapContext(context);
            mapLayerTable.setMapPane(mapPane);
            sashForm.setWeights(new int[]{1, 3});
        } else {
            mainComposite = parent;
            mapPane = new SwtMapPane(mainComposite, SWT.BORDER | SWT.NO_BACKGROUND);
            mapPane.setMapContext(context);
        }

        mapPane.setBackground(Display.getCurrent().getSystemColor(SWT.COLOR_WHITE));
        // set the renderer
        StreamingRenderer renderer = new StreamingRenderer();
        mapPane.setRenderer(renderer);
    }
```

One method that has to be explained is the *handleImages*. Since the handling of file paths inside a java project and an rcp plugin project are quite different, the *ImageCache* isn"t able to retrieve the necessary icons fro the gui from the gt-swt module. Therefore it is necessary to supply the needed images to the cache before starting. This can be done as follows based on the rcp file path handling:

```
    private void handleImages() {
        // get the image cache
        ImageCache imageCache = ImageCache.getInstance();
        // get all the relative paths needed by the cache
        List<String> relativePaths = imageCache.getRelativePaths();
        /*
         * Create all the needed images. The images have to reside in the plugin root 
         * in the same folder structure as in the gt-swt resources folder. 
         * 
         * The icons of the gt-swt module are currently located in /icons/
         */
        for( String path : relativePaths ) {
            Image image = AbstractUIPlugin.imageDescriptorFromPlugin(GtSwtPlugin.PLUGIN_ID, path).createImage();
            // feed the image into the cache for further use
            imageCache.addImage(path, image);
        }
    }
```

For the exact same reason it is also necessary to have the language file of the gt-swt module insid the plugin root as

```
/resources/Text.properties
```

in order to be properly picked by the plugin.

== Adding the map tools as view actions ==

Right now we have only the map view. The best place to put the tools like pan and zoom is probably the toolbar of the map view. To do so, we can add a *viewActions* extention point to our view, then add a *viewContribution* to the *viewActions* and finally all the actions we need there.

For example to add the Info Tool action, you add:

```
         <action
               class="org.geotools.swt.actions.InfoAction"
               icon="icons/info_mode.gif"
               id="rcp-gt-swt.info"
               label="Info Action"
               style="push"
               toolbarPath="gtswt">
         </action>
```

Then we have to implement the action itself. That is fairly easy, since we can delegate the activation of the tools to the gt-swt map panel:

```
public class InfoAction implements IViewActionDelegate {

    private IViewPart view;

    public void init( IViewPart view ) {
        this.view = view;
    }

    public void run( IAction action ) {
        SwtMapPane mapPane = ((MapView) view).getMapPane();
        mapPane.setCursorTool(new InfoTool());
    }

    public void selectionChanged( IAction action, ISelection selection ) {
    }

}
```

The same applies to all other actions.

== Adding the layer addition as menu commands ==

One last thing we will add is a command to load shapefiles from the filesystem. This just to show how to retrieve the map panel in case the view is not directly accessible.

First you create a command through the proper extension point. It should look like this:

```
   <extension
         point="org.eclipse.ui.commands">
      <command
            defaultHandler="org.geotools.swt.actions.OpenShapefileCommand"
            id="rcp-gt-swt.openshp"
            name="Open Shapefile">
      </command>
   </extension>
```

then that command can be added to the already existing *File* menu:

```
   <extension
         point="org.eclipse.ui.menus">
      <menuContribution
            locationURI="menu:org.eclipse.ui.main.menu">
         <menu
               label="File">
            <command
                  commandId="org.eclipse.ui.file.exit"
                  label="Exit">
            </command>
            <!-- add the commadn to the menu -->  
            <command
                  commandId="rcp-gt-swt.openshp"
                  icon="icons/open.gif"
                  label="Open Shapefile"
                  style="push"
                  tooltip="Opens a shapefile from the filesystem">
            </command>
         </menu>
      </menuContribution>
   </extension>
```

Last thing is to implement the *org.geotools.swt.actions.OpenShapefileCommand*, that we supplied in the above command as the one that would handle the command.

There is not that much behind that. We open a file browser, gather the selected file and add it to the mapcontext of the map pane, that we as usual retrieve from the map view:

```
public class OpenShapefileCommand extends AbstractHandler {

    @Override
    public Object execute( ExecutionEvent event ) throws ExecutionException {
        IWorkbenchPage activePage = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
        MapView mapView = (MapView) activePage.findView(MapView.ID);

        SwtMapPane mapPane = mapView.getMapPane();

        Display display = Display.getCurrent();
        Shell shell = new Shell(display);
        File openFile = JFileDataStoreChooser.showOpenFile(new String[]{"*.shp"}, shell); 

        try {
            if (openFile != null && openFile.exists()) {
                MapContext mapContext = mapPane.getMapContext();
                FileDataStore store = FileDataStoreFinder.getDataStore(openFile);
                SimpleFeatureSource featureSource = store.getFeatureSource();
                Style style = Utils.createStyle(openFile, featureSource);
                mapContext.addLayer(featureSource, style);
                mapPane.redraw();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
```

== The resulting rcp ==

If everything went smooth, you should be able to run the application and see something like:

<p align="center"><img src="http://wiki.jgrasstools.googlecode.com/hg/images/gt_swt/gtswt_rcp_01.png" />

Unknown end tag for &lt;/p&gt;



and with some layers loaded:

<p align="center"><img src="http://wiki.jgrasstools.googlecode.com/hg/images/gt_swt/gtswt_rcp_02.png" />

Unknown end tag for &lt;/p&gt;



= The source code for this tutorial =

The gt-swt module source code is in the [http://svn.osgeo.org/geotools/trunk/modules/unsupported/gt-swt/ geotools svn repo].

The source of the rcp application has been bundeled together with all the needed geotools libs and [http://jgrasstools.googlecode.com/files/rcp-gt-swt.tar.gz uploaded here]. Simply import the project into eclipse and you are ready to go.

'></a>