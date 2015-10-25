# Introduction #

This page will give a very brief introduction to Unit Tests facilities available in the framework.


# Details #

Each of the sub-projects of the JGrassTools framework has a specific folder where Unit Test classes have to be placed.

For the Hortomachine sub-project this folder is located at:
`/jgt-hortonmachine/src/test/java/org/jgrasstools/hortonmachine/models/hm/`

Any Class placed in this container is automatically executed upon any build of the Maven project and cause a build failure if they throw any exception.


---

Currently JGrassTools Unit Testing facilities are built over JUnit3.

This means that every test case class must explicitly extend the
```
org.jgrasstools.hortonmachine.utils.HMTestCase
```
class.

Each implemented method MUST be prefixed with (start with) the world **test** in order to be run as a test.

Annotations like `@Test` (`@org.junit.Test`) or `@Ignore` (`@org.junit.Ignore`) have no effect on test execution since belong to JUnit4.

An advantage of extending HMTestCase.class it that any subclass will have access to an instance of a **PrintStreamProgressMonitor** through the  protected **`pm`** object.
This means that calling within a test case:

```
pm.beginTask("Checking input map started..");
```

will notify the user of what is happening by printing the passed message in the Console view (uDig/Eclipse) or in the command prompt.

See PrintStreamProgressMonitor for more details.