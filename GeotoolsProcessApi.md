# Introduction #

OMS gives us a nifty way to get the input and output fields through their annotations. This can be exploited in a great way to implement for every module of the Horton Machine the Geotools Process API.

# Details #

Following what is written [on the geotools process pages](http://docs.codehaus.org/display/GEOTDOC/Process+Plugin), and digging a bit deeper, we find the interface **org.geotools.process.Process**:

```
public interface Process {
	/**
	 * Execute this process with the provided inputs.
	 * 
	 * @param input Input parameters for this process
	 * @param monitor listener for handling the progress of the process
	 * @return Map of results, (@see ProcessFactory for details), or null if canceled
	 */
	public Map<String,Object> execute(Map<String,Object> input, ProgressListener monitor)
        throws ProcessException;
}
```

That can be adapted easily to be executed with OMS3:

```
    public Map<String, Object> execute( Map<String, Object> input, ProgressListener monitor )
            throws ProcessException {
        // the geotools monitor is wrapped into the internal progress monitor
        GeotoolsProgressMonitorAdapter pm = new GeotoolsProgressMonitorAdapter(monitor);
        input.put("pm", pm);
        try {
            // set the inputs to the model
            ComponentAccess.setInputData(input, this, null);
        } catch (IOException e) {
            throw new ProcessException(e.getLocalizedMessage());
        }

        // trigger execution of the module
        ComponentAccess.callAnnotated(this, Initialize.class, true);
        ComponentAccess.callAnnotated(this, Execute.class, false);
        ComponentAccess.callAnnotated(this, Finalize.class, true);

        // get the results
        ComponentAccess cA = new ComponentAccess(this);
        Collection<Access> outputs = cA.outputs();

        // and put them into the output map
        HashMap<String, Object> outputMap = new HashMap<String, Object>();
        for( Access access : outputs ) {
            try {
                String fieldName = access.getField().getName();
                Object fieldValue = access.getFieldValue();
                outputMap.put(fieldName, fieldValue);
            } catch (Exception e) {
                throw new ProcessException(e.getLocalizedMessage());
            }
        }
        return outputMap;
    }
```

By putting the above method in the **eu.hydrologis.jgrass.hortonmachine.libs.models.HMModel** class and letting it implement **Process**, we are basically enabling every module of the Horton Machine to be compatible with the geotools process API.

For example you would be able to execute Pitfiller like that:

```
        Pitfiller pitfiller = new Pitfiller();
        Map<String, Object> inputMap = new HashMap<String, Object>();
        inputMap.put("inDem", elevationCoverage);
        Map<String, Object> outputMap = pitfiller.execute(inputMap, listener);
        GridCoverage2D pitfillerCoverage = (GridCoverage2D) outputMap.get("outPit");
```

To have that working you have to name the parameters after the name of the input fields.
That is how OMS3 gets things working through reflection.

Isn't that cool?