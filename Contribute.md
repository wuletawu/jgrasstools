

# Modules contributors #

Modules contributors have to follow some guidelines.

Before starting with the new module, they should get familiar with the [coding conventions](CodeConventions.md) and the [distributed versioning system](Mercurial.md) if they never used one before.

When writing a module the following is mandatory:
  * the module has to be OMS3 comliant. Soon we will post some documentation here, until then, feel free to email the project administrator for information.
  * the module has to come along with a testcase
  * a documentation has to be created in the wiki describing the module and linking to the testcase in the repository and if possible have also a nice screenshot to show what its results look like.

## The namespace ##

Since recently we had (and have) troubles in the uDig project, where the namspace contains a company name and other companies have problems in contributing, the namespace has decided to be: **org.jgrasstool**.

Please stick with this namespace if you contribute, in order to keep better readability. So the projects would be named:

  * org.jgrasstools.gears
  * org.jgrasstools.hortonmachine

Edc still has the old namespace, since there several hardcoded path in the reflection engines. Eventually I will change that.

## The code formatting ##

If you use IDE-aided formatting, it would be good to use the same we do. For eclipse we have a file ([download it here](http://www.hydrologis.com/devel/eclipse_formatter.xml)) that can be imported from within the preferences:
**Java -> Code Style -> Formatter**

## Committer inactivity ##

Committers that have been inactive for long, will be _backported_ to _contributer statuts + wiki edit rights_ (as opposed to _committer_). This is in order to constantly have a clear idea about how many developers are really active on the project. It takes 3 seconds to get a developer back to comitter status, so just drop me an email in private or in the mailinglist if you need (back) commit access.


# Documentation contributors #

If you want to help out in the documentation section you are most welcome to join us. We can give you permission to edit the wiki.

Please drop an email to the owner of the project, which can be found in the right sidebar of the [main page of the project](http://code.google.com/p/jgrasstools/)


# Bug reports #

A project grows only if it is used and its bugs are smashed as fast as they are identified.

A great contribution to the project is to **file a bug report** in the [bugtracker in the issues section](http://code.google.com/p/jgrasstools/issues/list).

Remember, the **more information** you will supply and the easier it will be for the developer to **reproduce the error and fix it**.