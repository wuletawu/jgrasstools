# Introduction #

The JGrassTools framework is a multi task environment. The Spatial Toolbox withing uDig has a button to stop the execution of running tasks. But how is it possible to keep the user informed about the stage of any launched task?
The answer is: using a Progress Monitor.


# Details #

## Using the Progress Monitor ##

Any Oms`*` model within the JGrassTools framework must extend the **JTModel class**.
This implies that any new model will inherit the _public_ **pm** object: an object implementing the _IJGTProgressMonitor_ interface and capable of delivering messages to the user through the Console View (in uDig) or the command line.

The Progress Monitor usage can be as simple as issuing an **error** with the following line:

```
pm.error("Your input does not meet requirements");
```

but it can also be used to report completion percentages of long tasks. A recurrent example of this usage occurs in raster processing tasks:

```
...
pm.beginTask("Start of slope calculation...", nRasterCols);
        // Cycle through columns and rows
        for( int c = 0; c < nCols; c++ ) {
            for( int r = 0; r < nRows; r++ ) {
                //[...model logic...]
            }
            pm.worked(1);
        }
        pm.done();
...
```

In the code above the Progress Monitor is instantiated passing _nRasterCols_ : the number of columns in the processed raster.

The line `pm.worked(1);` notifies the **pm** object that one _unit of work_ - here a column - has been completely processed. Upon this notification, the Progress Monitor will print a progress percentage each time the work exceeds a new tenth.

The line `pm.done();` sets the completion of the task.

The complete output resulting from the code above is a sequence like this:
```
Start of slope calculation...
0%...
10%...
20%...
30%...
40%...
50%...
60%...
70%...
80%...
90%...
Finished.
```

## Notes ##

Note that it is not possible to use the default Progress Monitor inherited from JGTModel to keep track of progresses of a set of actions performed by other modules, such as saving a set of files.

Each model points to the same **pm** object (and so also the OsmRasterWriter usually used to write grids!). The **pm** object gets reset as each model calls its `pm.beginTask()`.