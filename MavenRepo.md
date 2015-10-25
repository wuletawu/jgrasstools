

This page is for those that use maven as their build system and want to access the project releases that way.

# Snapshots #

The snapshots are hosted on sonatype OSS. To get them, add the following repo to your pom:

```
    <repository>
      <snapshots>
        <enabled>true</enabled>
      </snapshots>
      <id>sonatype</id>
      <name>Sonatype Maven Repository</name>
      <url>http://oss.sonatype.org/content/repositories/snapshots/</url>
    </repository>
```

# Available modules #

Modules are available from the jgrassgears and hortonmachine subprojects. To get them you need to specify the dependency in your project's POM:

```
                <!-- for jgrass gears -->
		<dependency>
			<groupId>org.jgrasstools</groupId>
			<artifactId>jgt-jgrassgears</artifactId>
			<version>0.7.0</version>
		</dependency>

                <!-- for hortonmachine -->
		<dependency>
			<groupId>org.jgrasstools</groupId>
			<artifactId>jgt-hortonmachine</artifactId>
			<version>0.7.0</version>
		</dependency>

                <!-- for oms -->
		<dependency>
			<groupId>org.jgrasstools</groupId>
			<artifactId>jgt-oms3</artifactId>
			<version>0.7.0</version>
		</dependency>
```