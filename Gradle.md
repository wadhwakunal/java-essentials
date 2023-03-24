# Gradle
### Build Tool
Build automation allows us to automate the manual steps involved in the build process. It saves the cost and time spent in the manual process

There are two types of build tools
+ imperative - tells the system what to do and how to do it : <b>Ant</b>
+ declarative - we only need to specify what we would like to achieve, and the system will figure out how to do it. :  <b>Maven</b>

## Gradle ? 
Gradle = Ant + Maven

Groovy or Kotlin can be used to write a build script.

#### Feature of Gradle 
+ Parallel Execution of task 
+ Build Output Caching - Reuse the cashed output for dependent task 
+ Task Exclusion using -x option (-xtest)
+ Dry Run - To check configuration for build script are ok using -m option 
+ Version Conflict Resolution
+ Customisable Logging

### How to create Gradle Project in Intellij ? 

### Different type of files in Gradle
+ Settings : settings.gradle
+ Build scripts : build.gradle
+ Property files. : gradle.properties
+ Init scripts : Init scripts run before the project instance is created

Note: use .kts for Kotlin in file name.

### Custom Repo 
```
ivy {
        url "http://repo.mycompany.com/repo"
    }
    
    Or 
    
    maven {
    url "http://repo.mycompany.com/repo"
    }

```

Gradle version 
```
gradle -v
```
Gradle help
```dtd
gradle help
```
gradle task list
```dtd
gradle task
gradle help --task build
```
Gradle Build tasks & ways to execute it in intellij
+ assemble - Assembles the outputs of this project.
+ build - Assembles and tests this project.
+ buildDependents - Assembles and tests this project and all projects that depend on it.
+ buildNeeded - Assembles and tests this project and all projects it depends on.
+ classes - Assembles main classes.
+ clean - Deletes the build directory.
+ jar - Assembles a jar archive containing the main classes.
+ testClasses - Assembles test classes.

Documentation tasks
+ javadoc - Generates Javadoc API documentation for the main source code

Important Id's
+ id "maven-publish"
+ id "jacoco"
+ id "com.google.cloud.tools.jib" version "${jib_version}"
+ id "org.springframework.boot" version "${spring_boot_version}"

```dtd
jib {
    // specify the name of docker image to be built
    to.image = "us.gcr.io/ProjectId/MyProject-service:v1.0.0"
    // specify the exact base image to be used.
    from.image = "us.gcr.io/ProjectId/Base-image:v0.42.0"
    container.mainClass = 'com.sapient.MyProjectServiceApplication'
    container.user = "nonroot"
}

```

```
springBoot {
    mainClass = 'com.sapient.MyProjectServiceApplication'
}
```


| Gradle                                                                                                | 	Maven                                                                                                                |
|-------------------------------------------------------------------------------------------------------|-----------------------------------------------------------------------------------------------------------------------|
| It is a build automation system that uses a Groovy-based DSL (domain-specific language )	             | It is a software project management system that is primarily used for java projects.                                  |
|It does not use an XML file for declaring the project configuration.| 	It uses an XML file for declaring the project, its dependencies, the build order, and its required plugin.           |
| It is based on a graph of task dependencies that do the work.                                         | 	It is based on the phases of the fixed and linear model.                                                             |
| In Gradle, the main goal is to add functionality to the project.                                      | 	In maven, the main goal is related to the project phase.                                                             |
| It avoids the work by tracking input and output tasks and only runs the tasks that have been changed. | Therefore it gives a faster performance.	It does not use the build cache; thus, its build time is slower than Gradle. |
| Gradle is highly customizable; it provides a wide range of IDE support custom builds.	                | Maven has a limited number of parameters and requirements, so customization is a bit complicated.                     |
| Gradle avoids the compilation of Java.	                                                               | The compilation is mandatory in Maven.                                                                                |

References:
+ https://gradle.org/guides/
+ https://medium.com/@shivam.gosavi340_58315/gradle-101-introduction-1d83c0394942
+ https://medium.com/@shivam.gosavi340_58315/gradle-102-gradle-basics-798db70a6c20
+ https://medium.com/@shivam.gosavi340_58315/gradle-103-build-life-cycle-6d1b595d72cc
