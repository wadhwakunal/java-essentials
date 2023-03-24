# MAVEN

### Introduction
Maven, a Yiddish word meaning accumulator of knowledge, began as an attempt to simplify the build processes in the Jakarta Turbine project.

Building a software project typically consists of such tasks as downloading dependencies, putting additional jars on a classpath, compiling source code into binary code, running tests, packaging compiled code into deployable artifacts such as JAR, WAR, and ZIP files, and deploying these artifacts to an application server or repository.

Apache Maven automates these tasks, minimizing the risk of humans making errors while building the software manually and separating the work of compiling and packaging our code from that of code construction. 

### Why Use Maven?
The key features of Maven are:

Simple project setup that follows best practices
Dependency management
Isolation between project dependencies and plugins


### Project Object Model
The configuration of a Maven project is done via a Project Object Model (POM), represented by a pom.xml file. The POM describes the project, manages dependencies, and configures plugins for building the software.

The POM also defines the relationships among modules of multi-module projects. Let's look at the basic structure of a typical POM file:

```
<project>
    <modelVersion>4.0.0</modelVersion>
    <groupId>com.test</groupId>
    <artifactId>test</artifactId>
    <packaging>jar</packaging>
    <version>1.0-SNAPSHOT</version>
    <name>com.test</name>
    <dependencies>
        <dependency>
            <groupId>org.junit.jupiter</groupId>
            <artifactId>junit-jupiter-api</artifactId>
            <version>5.8.2</version>
            <scope>test</scope>
        </dependency>
    </dependencies>
    <build>
        <plugins>
            <plugin>
            //...
            </plugin>
        </plugins>
    </build>
</project>
```

### Project Identifiers

+ groupId – a unique base name of the company or group that created the project
+ artifactId – a unique name of the project
+ version – a version of the project
+ packaging – a packaging method (e.g. WAR/JAR/ZIP)

The first three of these (groupId:artifactId:version) combine to form the unique identifier and are the mechanism by which you specify which versions of external libraries (e.g. JARs) your project will use.

### Dependencies
These external libraries that a project uses are called dependencies. The dependency management feature in Maven ensures the automatic download of those libraries from a central repository, so you don't have to store them locally.

In order to declare a dependency on an external library, you need to provide the groupId, artifactId, and version of the library. Let's take a look at an example:

```
<dependency>
    <groupId>org.springframework</groupId>
    <artifactId>spring-core</artifactId>
    <version>5.3.16</version>
</dependency>
```

As Maven processes the dependencies, it will download the Spring Core library into your local Maven repository.

### Repositories
A repository in Maven is used to hold build artifacts and dependencies of varying types. The default local repository is located in the .m2/repository folder under the home directory of the user.

If an artifact or a plugin is available in the local repository, Maven uses it. Otherwise, it is downloaded from a central repository and stored in the local repository. The default central repository is Maven Central.

Please note that you can use multiple repositories in your projects.

### Properties
Custom properties can help to make your pom.xml file easier to read and maintain. In the classic use case, you would use custom properties to define versions for your project's dependencies.

Maven properties are value-placeholders and are accessible anywhere within a pom.xml by using the notation ${name}, where name is the property.

Let's see an example:

```
<properties>
    <spring.version>5.3.16</spring.version>
</properties>

<dependencies>
    <dependency>
        <groupId>org.springframework</groupId>
        <artifactId>spring-core</artifactId>
        <version>${spring.version}</version>
    </dependency>
    <dependency>
        <groupId>org.springframework</groupId>
        <artifactId>spring-context</artifactId>
        <version>${spring.version}</version>
    </dependency>
</dependencies>
```

Now if you want to upgrade Spring to a newer version, you only have to change the value inside the<spring.version> property tag and all the dependencies using that property in their <version> tags will be updated.

Also, the default output folder for compiled artifacts is named target, and the final name of the packaged artifact consists of the artifactId and version, but you can change it at any time.

### Using Profiles
Another important feature of Maven is its support for profiles. A profile is basically a set of configuration values. By using profiles, you can customize the build for different environments such as Production/Test/Development:

```
<profiles>
    <profile>
        <id>production</id>
        <build>
            <plugins>
                <plugin>
                //...
                </plugin>
            </plugins>
        </build>
    </profile>
    <profile>
        <id>development</id>
        <activation>
            <activeByDefault>true</activeByDefault>
        </activation>
        <build>
            <plugins>
                <plugin>
                //...
                </plugin>
            </plugins>
        </build>
     </profile>
 </profiles>
```

As you can see in the example above, the default profile is set to development. If you want to run the prod profile, you can use the following Maven command:

mvn clean install -Pproduction where we define profile after -P.

### Maven Build Lifecycles
Every Maven build follows a specified lifecycle. You can execute several build lifecycle goals, including the ones to compile the project’s code, create a package, and install the archive file in the local Maven dependency repository.

#### Lifecycle Phases
The following list shows the most important Maven lifecycle phases:

+ validate – checks the correctness of the project
+ compile – compiles the provided source code into binary artifacts
+ test – executes unit tests
+ package – packages compiled code into an archive file
+ integration-test – executes additional tests, which require the packaging
+ verify – checks if the package is valid
+ install – installs the package file into the local Maven repository
+ deploy – deploys the package file to a remote server or repository

#### Plugins and Goals
A Maven plugin is a collection of one or more goals. Goals are executed in phases, which helps to determine the order in which the goals are executed.

To go through any one of the above phases, we just have to call one command:

```
mvn <phase>
```

For example, mvn clean install will remove the previously created jar/war/zip files and compiled classes (clean) and execute all the phases necessary to install the new archive (install).

Please note that goals provided by plugins can be associated with different phases of the lifecycle.

### Your First Maven Project
In this section, we will use the command line functionality of Maven to create a Java project.

#### Generating a Simple Java Project
In order to build a simple Java project, let's run the following command:

```
mvn archetype:generate \
  -DgroupId=com.test \
  -DartifactId=test \
  -DarchetypeArtifactId=maven-archetype-quickstart \
  -DarchetypeVersion=1.4 \
  -DinteractiveMode=false
  ```

The groupId is a parameter indicating the group or individual that created a project, which is often a reversed company domain name. The artifactId is the base package name used in the project, and we use the standard archetype. Here we are using the latest archetype version to ensure our project is created with updated and latest structure.

Since we didn't specify the version and the packaging type, these will be set to default values — the version will be set to 1.0-SNAPSHOT, and the packaging will be jar by default.

If you don't know which parameters to provide, you can always specify interactiveMode=true, so that Maven asks for all the required parameters.

After the command completes, we have a Java project containing an App.java class, which is just a simple “Hello World” program, in the src/main/java folder.

We also have an example test class in src/test/java. The pom.xml of this project will look similar to this:

```
<project>
    <modelVersion>4.0.0</modelVersion>
    <groupId>com.test</groupId>
    <artifactId>test</artifactId>
    <version>1.0-SNAPSHOT</version>
    <name>test</name>
    <url>http://www.example.com</url>
    <dependencies>
        <dependency>
            <groupId>junit</groupId>
            <artifactId>junit</artifactId>
            <version>4.11</version>
            <scope>test</scope>
        </dependency>
    </dependencies>
</project>
```

As you can see, the JUnit dependency is provided by default.

#### Compiling and Packaging a Project
The next step is to compile the project:
```
mvn compile
```

Maven will run through all lifecycle phases needed by the compile phase to build the project's sources. If you want to run only the test phase, you can use:
```
mvn test
```
Now let's invoke the package phase, which will produce the compiled archive jar file:
```
mvn package
```
#### Executing an Application
Finally, we are going to execute our Java project with the exec-maven-plugin. Let's configure the necessary plugins in the pom.xml:

```
<build>
    <sourceDirectory>src</sourceDirectory>
    <plugins>
        <plugin>
            <artifactId>maven-compiler-plugin</artifactId>
            <version>3.6.1</version>
            <configuration>
                <source>1.8</source>
                <target>1.8</target>
            </configuration>
        </plugin>
        <plugin>
            <groupId>org.codehaus.mojo</groupId>
            <artifactId>exec-maven-plugin</artifactId>
            <version>3.0.0</version>
            <configuration>
                <mainClass>com.test.java.App</mainClass>
            </configuration>
        </plugin>
    </plugins>
</build>
```

The first plugin, maven-compiler-plugin, is responsible for compiling the source code using Java version 1.8. The exec-maven-plugin searches for the mainClass in our project.

To execute the application, we run the following command:

```
mvn exec:java
```

### Maven dependency scopes
In the Java world, dependencies become available at different stages of the development lifecycle by being included or excluded from the Java classpath, which is a list of directories and archives with compiled Java classes. Simply put, classes on the classpath are visible to all other classes and can be referenced and used according to their API.

If Java is run from the command line, you can specify the classpath by using the -cp or -classpath options, which take as argument a list of directories and JAR/ZIP files. But when using Maven, the classpath is automatically built on the basis of the scope chosen by the developer when declaring the dependency.

Maven distinguishes six dependency scopes: compile, runtime, test, provided, system and import.

The **compile** scope contains dependencies that are required for the compilation of the project under development. In other words, the source code of project classes directly or indirectly references classes of compile dependencies, which requires those compile dependencies to be present in all lifecycle phases, from compilation and test to the production environment.

The **runtime** scope contains dependencies whose classes are not referenced directly in code, but are loaded dynamically, using reflection or a Java ServiceLoader4, for example. Their classes also provide functionality required by the project under development, thus, require being on the classpath during tests and runtime.

The **provided** scope contains classes that will be provided by the project’s runtime environment and thus do not need to be included in the artifact produced by the development project. A typical example is the Java Servlet API, which will be provided by the Web application container, e.g., Apache Tomcat. For this reason, provided dependencies are on the classpath during compilation and test, but not included when creating the project artifact that will be deployed into production.

**Also below are some other useful commands discussed:**
mvn dependency:tree
mvn help:effective-pom
mvn help:effective-settings

### Conclusion

In this article, we discussed some of the more popular features of the Apache Maven build tool.

_References:_
https://maven.apache.org/
https://mvnrepository.com/
https://www.baeldung.com/maven