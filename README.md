# 🌐 API Testing with Karate

This project is a simple API testing project using [Karate](https://github.com/karatelabs/karate) and [JUnit 5](https://junit.org/junit5/).

## 🥋 What is Karate?

Karate is a modern, powerful, and elegant [BDD](https://en.wikipedia.org/wiki/Behavior-driven_development) testing framework for Java. It brings the simplicity and readability of [Gherkin](https://cucumber.io/docs/gherkin/reference/) syntax to Java, while enabling parallel test execution. Karate is a Java implementation of the [Cucumber](https://cucumber.io/docs/cucumber/) BDD framework.

---

## 📚 Table of Contents
- [📝 Project Structure](#-project-structure)
- [🚀 Getting Started](#-getting-started)
    - [Prerequisites](#prerequisites)
      - [Installing Java and Maven](#installing-java-and-maven)
          - [Windows](#windows)
          - [Mac](#mac)
          - [Installing Karate in IntelliJ IDEA](#installing-karate-in-intellij-idea)
          - [Installing Karate in VS Code](#installing-karate-in-vs-code)
    - [Installing Karate](#installing-karate)
- [🏃‍♂️ Running the Tests](#-running-the-tests)
- [Performance Testing with Gatling](#-performance-testing-with-gatling)

---
## 📝 Project Structure

```karate-restful-api-testing 
karate-restful-api-testing
├── pom.xml
├── src
│   ├── main
│   │   └── java
│   └── test
│       ├── java
│       │   └── in
│       │       └── reqres
│       │           └── utils
│       │               └── RandomDataGenerator.java
│       │               └── performance
│       │                 └── usersSimlation.java.java
│       └── resources
│           └── in
│               └── reqres
│                   └── users
│                       ├── users-post.feature
|                       ├── users-gets.feature
|                       ├── UsersRunner.java
│                       └── payloads
│                           └── createUser.json
└── README.md
```

## 🚀 Getting Started

### Prerequisites

Ensure you have the following installed:

- **Java** 17 or higher
- **Maven** 3.8.1 or higher
- An IDE like **IntelliJ IDEA**, **VS code** or **Eclipse** (optional, but recommended)

### 🛠️ Installing Java and Maven

#### Windows

1. **Install Java**
  - Download the JDK from [Adoptium](https://adoptium.net/) or Oracle.
  - Run the installer and follow the prompts.
  - Set the `JAVA_HOME` environment variable to your JDK path (e.g., `C:\Program Files\Eclipse Adoptium\jdk-17`).
  - Add `%JAVA_HOME%\bin` to your `Path`.

   Verify:
   ```bash
    java -version
   ```
    
2. **Install Maven**
    - Download Maven from [Apache Maven](https://maven.apache.org/download.cgi).
    - Extract the archive to a directory (e.g., `C:\apache-maven-3.8.1`).
    - Set the `MAVEN_HOME` environment variable to your Maven path.
    - Add `%MAVEN_HOME%\bin` to your `Path`.
    
     Verify:
     ```bash
     mvn -version
     ```  
#### Mac
1. **Install Java**
   - Use [Homebrew](https://brew.sh/) to install Java:
     ```bash
     brew install openjdk@17
     ```
   - Set the `JAVA_HOME` environment variable:
     ```bash
     export JAVA_HOME=$(/usr/libexec/java_home -v 17)
     ```

   Verify:
   ```bash
   java -version
   ```
2. **Install Maven**
    - Use Homebrew to install Maven:
      ```bash
      brew install maven
      ```
    
    Verify:
    ```bash
    mvn -version
    ```
     


### Installing Karate in IntelliJ IDEA
To install Karate in IntelliJ IDEA, you can use the built-in Maven support.
1. Open your project in IntelliJ IDEA.
2. Open the `pom.xml` file.
3. IntelliJ will automatically detect the Maven project and download the necessary dependencies.

Follow the instructions in the [Karate documentation](https://github.com/karatelabs/karate#installation). Alternatively, you can add the following Maven dependency to your `pom.xml`:

```xml
<dependency>
    <groupId>com.intuit.karate</groupId>
    <artifactId>karate-apache</artifactId>
    <version>1.5.0</version>
    <scope>test</scope>
</dependency>
```
or run the following command to add it:

```bash
  mvn archetype:generate \
-DarchetypeGroupId=io.karatelabs \
-DarchetypeArtifactId=karate-archetype \
-DarchetypeVersion=1.5.1 \
-DgroupId=com.mycompany \
-DartifactId=myproject
```

### Installing Karate in VS Code
To install Karate in Visual Studio Code, you can use the built-in Maven support.
1. Open your project in Visual Studio Code.
2. Open the `pom.xml` file.
3. VS Code will automatically detect the Maven project and download the necessary dependencies.
4. You can also install the [Karate VS Code extension](https://github.com/karatelabs/vscode-extension) for better support.

## 🏃‍♂️ Running the tests

To run the tests, use the following command:

```bash
  mvn clean test
```

This will execute all the tests in the `src/test/java` directory. 

You can also run a specific test class by using the following command:

```bash
  mvn test -Dtest=examples.product.ProductRunner
```

After running the tests, you can view the results in the `target/karate-reports` directory. The results will be in the form of HTML and XML files.

Run by environment:

```bash
  mvn clean test -Dkarate.env=dev 
```
you can swith to `prod` or `stage` environment by changing the value of `karate.env`.

Run by tag:

```bash
  mvn clean test -Dkarate.options="--tags @smoke"
``` 

Integrate with IDE:

```bash
  mvn clean test -Dgatling
```

## Performance Testing with  Gatling
Gatling is a powerful tool for load testing and performance testing. To run Gatling simulations, you need to add the Gatling Maven plugin to your `pom.xml`.

This project include different Gatling simulations in the `src/test/java/in/reqres/utils/performance` like
Smoke test, load test, Peak test, stress test,Soak test,  and load test.

There are maven profiles defined in the `pom.xml` to run Gatling simulations. You can run the Gatling simulations using the following command:

For smoke test:
```bash
  mvn gatling:test -P gatling-smoke 
```
For load test:
```bash
  mvn gatling:test -P gatling-load
```
For peak test:
```bash
  mvn gatling:test -P gatling-peak
```
For stress test:
```bash
  mvn gatling:test -P gatling-stress
```
For soak test:
```bash
  mvn gatling:test -P gatling-soak
```

you can find the Gatling reports in the `target/gatling` directory. The reports will be in the form of HTML files.


