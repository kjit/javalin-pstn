# Javalin server example

## Prerequisites 

- Java 8/11
- Maven 3.6
- Git 
- IDE
- Docker

## Steps

* Create maven project: `` mvn archetype:generate``
* Update compiler in pom:

        <maven.compiler.source>11</maven.compiler.source>
        <maven.compiler.target>11</maven.compiler.target>

* Add javalin (and slf4j) dependency:

        <dependency>
            <groupId>io.javalin</groupId>
            <artifactId>javalin</artifactId>
            <version>2.7.0</version>
        </dependency>
        <dependency>
            <groupId>ch.qos.logback</groupId>
            <artifactId>logback-classic</artifactId>
            <version>1.0.13</version>
        </dependency>

* Add assembly plugin to create single executable jar:

        <builds>
        ...
        <plugins>
            <plugin>
                <artifactId>maven-assembly-plugin</artifactId>
                <version>3.1.1</version>
                <configuration>
                    <descriptorRefs>
                        <descriptorRef>jar-with-dependencies</descriptorRef>
                    </descriptorRefs>
                    <archive>
                        <manifest>
                            <mainClass>com.github.kjit.App</mainClass>
                        </manifest>
                    </archive>
                </configuration>
                <executions>
                    <execution>
                        <id>make-assembly</id> <!-- this is used for inheritance merges -->
                        <phase>package</phase> <!-- bind to the packaging phase -->
                        <goals>
                            <goal>single</goal>
                        </goals>
                    </execution>
                </executions>
            </plugin>
        </plugins>

* Create Javalin server in main class and first handler:

        Javalin app = Javalin.create().start(7000);
        app.get("/", ctx -> ctx.result("Hello there"));

* Create more handlers...
	

