```
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
<modelVersion>4.0.0</modelVersion>

    <groupId>org.example</groupId>
    <artifactId>my-test-pjct-sample</artifactId>
    <version>1.0-SNAPSHOT</version>
    <packaging>jar</packaging>
    <description>This pom is for demonstration purpose of various pom features</description>

    <properties>
        <beam.version>2.43.0</beam.version>
        <mockito.version>1.10.19</mockito.version>
        <maven-compiler-plugin.version>3.7.0</maven-compiler-plugin.version>
        <maven-exec-plugin.version>1.6.0</maven-exec-plugin.version>
        <maven-jar-plugin.version>3.2.0</maven-jar-plugin.version>
        <maven-shade-plugin.version>3.1.0</maven-shade-plugin.version>
        <maven-javadoc-plugin.version>3.1.0</maven-javadoc-plugin.version>
        <maven-surefire-plugin.version>3.0.0-M1</maven-surefire-plugin.version>
        <maven-failsafe-plugin.version>2.7</maven-failsafe-plugin.version>
    </properties>

    <repositories>
        <repository>
            <id>RepoUsr</id>
            <url><//Path to the user defined remote repo></url>
            <snapshots>
                <enabled>true</enabled>
            </snapshots>
        </repository>
    </repositories>

    <pluginRepositories>
        <pluginRepository>
            <id>RepoUsr</id>
            <url><//Path to the user defined remote repo></url>
            <snapshots>
                <enabled>true</enabled>
            </snapshots>
        </pluginRepository>
    </pluginRepositories>

    <build>
        <plugins>
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-compiler-plugin</artifactId>
                <version>${maven-compiler-plugin.version}</version>
                <configuration>
                    <source>1.8</source>
                    <target>1.8</target>
                </configuration>
            </plugin>

            <!-- Ensure that the Maven jar plugin runs before the Maven
              shade plugin by listing the plugin higher within the file. -->
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-jar-plugin</artifactId>
                <version>${maven-jar-plugin.version}</version>
            </plugin>

            <!--
              Configures `mvn package` to produce a bundled jar ("fat jar")
            -->
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-shade-plugin</artifactId>
                <version>${maven-shade-plugin.version}</version>
                <executions>
                    <execution>
                        <phase>package</phase>
                        <goals>
                            <goal>shade</goal>
                        </goals>
                        <configuration>
                            <finalName>${project.artifactId}-bundled-${project.version}</finalName>
                            <filters>
                                <filter>
                                    <artifact>*:*</artifact>
                                    <excludes>
                                        <exclude>META-INF/LICENSE</exclude>
                                        <exclude>META-INF/*.SF</exclude>
                                        <exclude>META-INF/*.DSA</exclude>
                                        <exclude>META-INF/*.RSA</exclude>
                                    </excludes>
                                </filter>
                            </filters>
                            <transformers>
                                <transformer implementation="org.apache.maven.plugins.shade.resource.ServicesResourceTransformer"/>
                            </transformers>
                        </configuration>
                    </execution>
                </executions>
            </plugin>

        </plugins>

    </build>


    <profiles>
        <profile>
            <id>direct-runner</id>
            <activation>
                <activeByDefault>true</activeByDefault>
            </activation>
            <!-- Makes the DirectRunner available when running a pipeline. -->
            <dependencies>
                <dependency>
                    <groupId>org.apache.beam</groupId>
                    <artifactId>beam-runners-direct-java</artifactId>
                    <version>${beam.version}</version>
                    <scope>runtime</scope>
                </dependency>
            </dependencies>
        </profile>



        <profile>
            <id>dataflow-runner</id>
            <!-- Makes the DataflowRunner available when running a pipeline. -->
            <dependencies>
                <dependency>
                    <groupId>org.apache.beam</groupId>
                    <artifactId>beam-runners-google-cloud-dataflow-java</artifactId>
                    <version>${beam.version}</version>
                </dependency>
            </dependencies>
        </profile>

    </profiles>

    <dependencies>
        <!-- Adds a dependency on the Beam SDK. -->
        <dependency>
            <groupId>org.apache.beam</groupId>
            <artifactId>beam-sdks-java-core</artifactId>
            <version>${beam.version}</version>
        </dependency>

        <!-- Adds a dependency on the Beam Google Cloud Platform IO module. -->
        <dependency>
            <groupId>org.apache.beam</groupId>
            <artifactId>beam-sdks-java-io-google-cloud-platform</artifactId>
            <version>${beam.version}</version>
            <exclusions>
                <exclusion>
                    <groupId>io.github.classgraph</groupId>
                    <artifactId>classgraph</artifactId>
                </exclusion>
            </exclusions>
        </dependency>

        <!-- https://mvnrepository.com/artifact/org.apache.beam/beam-sdks-java-io-jdbc -->
        <dependency>
            <groupId>org.apache.beam</groupId>
            <artifactId>beam-sdks-java-io-jdbc</artifactId>
            <version>${beam.version}</version>
        </dependency>

        <dependency>
            <groupId>org.apache.beam</groupId>
            <artifactId>beam-runners-google-cloud-dataflow-java</artifactId>
            <version>${beam.version}</version>
            <exclusions>
                <exclusion>
                    <groupId>io.confluent</groupId>
                    <artifactId>kafka-avro-serializer</artifactId>
                </exclusion>
            </exclusions>
        </dependency>
    </dependencies>
</project>
```