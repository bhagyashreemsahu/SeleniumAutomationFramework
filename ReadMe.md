# Selemium Automation Framework


- Java 11
- Maven
- TestNG
- Selenium


## Features

- Performs UI  Automated Tests for Amazon login and search functionality
- Can be Integrated with Jenkins CI for Continious Testing for UI Component 
- Categorizing the Tests in  TestNG 
- Performs Parallel Testing and Isolated Tests


## Tech

Framework uses a number of dependencies to work properly:

- Selenium WebDriver
-WebDriver Manager
- TestNG
- OpenCSV
- Apache POI

## Adding New Dependencies

New Dependencies can be added in pom.xml at root level under dependencies tag

Example
```
<dependency>
			<groupId>org.testng</groupId>
			<artifactId>testng</artifactId>
			<version>6.14.2</version>
			<scope>test</scope>
		</dependency>
```



## Plugins

Maven Plugins used in the Project
<table>
  <tr><th>Plugin</th><th>README</th></tr>
    <tr><td> Exec Maven Plugin -</td><td>https://www.mojohaus.org/exec-maven-plugin/ </td></tr>
</table>




### To Run the Automated Test for TestNG from cli...

```sh
mvn -Dexec.classpathScope=test  -Dexec.arguments="api,sanity" test-compile  exec:java -Dexec.cleanupDaemonThreads=false -X
```

