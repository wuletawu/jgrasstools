## Introduction ##

A patch is a text file which contains differences between different version of a file or a collection of file. <p>Creating a patch allow us to share our modify in an alternative way with other member of the team. For example we can send it by mail so that the other member can apply it to his <a href='http://mercurial.selenic.com/wiki/Repository'>repository</a>.</p>

<a href='Hidden comment: 


<p> You can found some more information about the patch in mercurial at <a href="http://hgbook.red-bean.com/read/managing-change-with-mercurial-queues.html#sec:mq:patch"> Understanding patches 

Unknown end tag for &lt;/a&gt;

 chapter.

'></a>
## Creating a patch ##

The main command to create a patch is _hg export_ but before to run this we have to do some preparations indeed it's necessary to be sure to have <a href='http://mercurial.selenic.com/wiki/Pull'>pulled out</a> from the trunk the local repository and <a href='http://mercurial.selenic.com/wiki/Update'>update</a> the working directory and then added and <a href='http://mercurial.selenic.com/wiki/Commit'>commited</a> all the changes to the local repository. So first of all you have to run _addr_ and _ci_ command.




<p> A useful set of command is the list of command which allow us to create a patch from the <a href='http://mercurial.selenic.com/wiki/Tip'>tip</a>.<br>
<br>
<br>
An example of the use of creating a patch is the following, where a new package with a new model are added to the project. So, for instance, you can create the <i>org.jgrasstools.hortonmachine.modules.newpackage</i> and inside this package the <i>NewClass</i> Java class. Now it's necessary to add the new file and commit it to the local repository (~/JGrassToolsRepo/jgrasstools) as zigmund user, so:<br>
<br>
<pre><code>[09:56:31]daniele@:~[502] $ cd jgrassToolsRepo/jgrasstools<br>
[09:56:35]daniele@:~/jgrassToolsRepo/jgrasstools[503] $ hg addr                                               <br>
adding hortonmachine/src/main/java/org/jgrasstools/hortonmachine/modules/newpackage/NewClass.java<br>
[09:59:35]daniele@:~/jgrassToolsRepo/jgrasstools[504] $ hg ci -m "add a new package and new class in the HM models" -u "zigmund"   <br>
</code></pre>

Now you can  modify the <i>NewClass</i> :<br>
<br>
<pre><code><br>
package org.jgrasstools.hortonmachine.modules.newpackage;<br>
<br>
import oms3.annotations.Author;<br>
import oms3.annotations.Description;<br>
import oms3.annotations.In;<br>
import oms3.annotations.Keywords;<br>
<br>
import org.geotools.coverage.grid.GridCoverage2D;<br>
import org.jgrasstools.gears.libs.modules.JGTModel;<br>
<br>
@Description("This is a model example to crate a patch")<br>
@Author(name = "Daniele Andreis")<br>
@Keywords("Example")<br>
<br>
public class NewClass extends JGTModel {<br>
<br>
    @Description("The input map.")<br>
    @In<br>
    public GridCoverage2D inMap = null;<br>
}<br>
<br>
</code></pre>


And commit the change and see the log of all the commit of the zigmund user:<br>
<br>
<pre><code><br>
[10:38:39]daniele@:~/jgrassToolsRepo/jgrasstools[506] $ hg ci -m "add a field to the NewClass model" -u "zigmund"                                                                                                           <br>
[10:39:25]daniele@:~/jgrassToolsRepo/jgrasstools[507] $ hg log -u "zigmund"                                   <br>
changeset:   220:76365e747c4a                                                                                 <br>
tag:         tip<br>
utente:      zigmund<br>
data:        Wed Jun 23 10:39:25 2010 +0200<br>
sommario:    add a field to the NewClass model<br>
<br>
changeset:   219:e21d9cd77cd7<br>
utente:      zigmund<br>
data:        Wed Jun 23 10:38:39 2010 +0200<br>
sommario:    add a new package and new class in the HM models<br>
<br>
</code></pre>

Now we can look at the <a href='http://mercurial.selenic.com/wiki/Diff?highlight=%28\bCategoryGlossary\b%29'>difference</a> between the version before the changes (218, obtained with the hg log command) and the tip:<br>
<br>
<br>
<pre><code>[10:41:27]daniele@:~/jgrassToolsRepo/jgrasstools[509] $ hg diff -r 218                                        <br>
diff -r e8fccef1fb74 hortonmachine/src/main/java/org/jgrasstools/hortonmachine/modules/newpackage/NewClass.java                                                                                                             <br>
--- /dev/null   Thu Jan 01 00:00:00 1970 +0000                                                                <br>
+++ b/hortonmachine/src/main/java/org/jgrasstools/hortonmachine/modules/newpackage/NewClass.java        Wed Jun 23 10:41:36 2010 +0200                                                                                      <br>
@@ -0,0 +1,20 @@                                                                                              <br>
+package org.jgrasstools.hortonmachine.modules.newpackage;                                                    <br>
+                                                                                                             <br>
+import oms3.annotations.Author;                                                                              <br>
+import oms3.annotations.Description;                                                                         <br>
+import oms3.annotations.In;                                                                                  <br>
+import oms3.annotations.Keywords;                                                                            <br>
+                                                                                                             <br>
+import org.geotools.coverage.grid.GridCoverage2D;                                                            <br>
+import org.jgrasstools.gears.libs.modules.JGTModel;                                                          <br>
+                                                                                                             <br>
+@Description("This is a model example to crate a patch")                                                     <br>
+@Author(name = "Daniele Andreis")                                                                            <br>
+@Keywords("Example")                                                                                         <br>
+                                                                                                             <br>
+public class NewClass extends JGTModel {                                                                     <br>
+                                                                                                             <br>
+    @Description("The input map.")                                                  <br>
+    @In                                                                                                      <br>
+    public GridCoverage2D inMap = null;                                                                      <br>
+}                                                                                                            <br>
\ No newline at end of file     <br>
<br>
<br>
<br>
</code></pre>



And finally we can see the <a href='http://mercurial.selenic.com/wiki/Head?highlight=%28\bCategoryGlossary\b%29'>head</a> and export the patch:<br>
<br>
<pre><code>[10:41:36]daniele@:~/jgrassToolsRepo/jgrasstools[510] $ hg head                                               <br>
changeset:   220:76365e747c4a                                                                                 <br>
tag:         tip                                                                                              <br>
utente:      zigmund                                                                                          <br>
data:        Wed Jun 23 10:39:25 2010 +0200                                                                   <br>
sommario:    add a field to the NewClass model                                                                <br>
                                                                                                                              <br>
[10:49:56]daniele@:~/jgrassToolsRepo/jgrasstools[511] $  hg export  tip    -o /home/daniele/Scrivania/newPatch.diff  <br>
<br>
</code></pre>

Where <i>~/jgrassToolsRepo/jgrasstools</i> is the location, on the file system, of the local repository and <i>/home/daniele/Scrivania/newPatch.diff</i> is the patch file.<br>
<br>
<br>
If you want to create a patch of a specific revision, for example to the 219, you can type:<br>
<br>
<pre><code>[11:32:57]daniele@:~/jgrassToolsRepo/jgrasstools[516] $ hg export  219   -o /home/daniele/Scrivania/radiationPatch2.diff<br>
</code></pre>




<b>Notes</b>:<br>
<ol><li>You can export a specific <a href='http://mercurial.selenic.com/wiki/ChangeSet'>changeset</a> (type hg export --help for the details).<br>
</li><li>You can use the plug-in for eclipse,<a href='http://javaforge.com/project/HGE'> Mercurial Eclipse </a>, to export the patch.<br>
</li><li>You can open the .diff file with an editor or witha a program like <a href='http://en.wikipedia.org/wiki/Kompare'> kompare </a> which can show you the difference in a more "friendly" way.<br>
</li><li>You can also generate the .diff file if you redirect the output of the diff command to the .diff file.</li></ol>

<h2>Import a patch</h2>

Importing changesets from a patch is fairly easy and can be accomplished through the command:<br>
<pre><code>hg import<br>
</code></pre>

In the following example I import a set of changesets that contain the tca3d module and its testcase:<br>
<pre><code>~/development/jgrasstools-hg/jgrasstools &gt;&gt;&gt; hg import tca3d_and_testcase.patch <br>
applying tca3d_and_testcase.patch<br>
patching file hortonmachine/src/test/java/org/jgrasstools/hortonmachine/models/hm/Test_Tca3d.java<br>
patching file hortonmachine/src/main/java/org/jgrasstools/hortonmachine/modules/geomorphology/tca3d/Tca3d.java<br>
adding hortonmachine/src/main/java/org/jgrasstools/hortonmachine/modules/geomorphology/tca3d/Tca3d.java<br>
adding hortonmachine/src/test/java/org/jgrasstools/hortonmachine/models/hm/Test_Tca3d.java<br>
hortonmachine/src/main/java/org/jgrasstools/hortonmachine/modules/geomorphology/tca3d/Tca3d.java<br>
</code></pre>

The import command merges the new changesets into the local repo and therefore the commit message of the changesets are preserved as contained in the patch.<br>
<br>
If there are conflicts obviously these will have to be solved through a comparison program and committed on their own.<br>
<br>
At that point a push would bring the changes in the remote repo.<br>
<br>
<br>
<h2>References</h2>

<ul><li><a href='http://mercurial.selenic.com/wiki/Mercurial?action=AttachFile&do=view&target=Hague2009.pdf'> Mercurial by Example </a>
</li><li><a href='http://mercurial.selenic.com/wiki/MercurialBook'> Mercurial Book </a>