# 🌐 API Testing with Karate

This project is a simple API testing project using [Karate](https://github.com/karatelabs/karate) and [JUnit 5](https://junit.org/junit5/).

## 🥋 What is Karate?

Karate is a modern, powerful, and elegant [BDD](https://en.wikipedia.org/wiki/Behavior-driven_development) testing framework for Java. It brings the simplicity and readability of [Gherkin](https://cucumber.io/docs/gherkin/reference/) syntax to Java, while enabling parallel test execution. Karate is a Java implementation of the [Cucumber](https://cucumber.io/docs/cucumber/) BDD framework.

---

## 📚 Table of Contents
- [📝 Project Structure](#-project-structure)
- [🚀 Getting Started](#-getting-started)
    - [Prerequisites](#prerequisites)
    - [Installing Karate](#installing-karate)
- [🏃‍♂️ Running the Tests](#-running-the-tests)

---
## 📝 Project Structure

```karate-restful-api-testing 
├── pom.xml
├── src
│   └── test
│       ├── java
│       │   ├── examples
│       │   │   ├── users
│       │   │   │   ├── UsersRunner.java
│       │   │   │   └── users.feature
│       │   └── resources   
```

## 🚀 Getting Started

### Prerequisites

Ensure you have the following installed:

- **Java** 17 or higher
- **Maven** 3.8.1 or higher
- An IDE like **IntelliJ IDEA** or **Eclipse** (optional, but recommended)

### Installing Karate

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
mvn archetype:generate \                                                                                                                                                                                                                                                                                  ─╯
-DarchetypeGroupId=io.karatelabs \
-DarchetypeArtifactId=karate-archetype \
-DarchetypeVersion=1.5.1 \
-DgroupId=com.projectName \
-DartifactId=karate-restful-api-testing 
```
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
