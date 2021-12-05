# Java :coffee:
learning java

## Standard directory layout (for java-maven project)

| Directory                                  | Description                                                                   |
|:-------------------------------------------|:------------------------------------------------------------------------------|
| [`src`](src)                               | Source material for building the project                                      |
| [`src/main`](src/main)                     | Main build artifact                                                           |
| [`src/main/java`](src/main/java)           | Application/Library sources (below this, the normal package hierarchy exists) |
| [`src/main/resources`](src/main/resources) | Application/Library resources                                                 |
| [`src/main/filters`](src/main/filters)     | Resource filter files                                                         |
| [`src/main/webapp`](src/main/webapp)       | Web application sources                                                       |
| [`src/test`](src/test)                     | Unit test code                                                                |
| [`src/test/java`](src/test/java)           | Test sources                                                                  |
| [`src/test/resources`](src/test/resources) | Test resources                                                                |
| [`src/test/filters`](src/test/filters)     | Test resource filter files                                                    |
| [`src/it`](src/it)                         | Integration Tests (primarily for plugins)                                     |
| [`src/assembly`](src/assembly)             | Assembly descriptors                                                          |
| [`target`](target)                         | Build output's destination                                                    |

:link: [Ref](http://maven.apache.org/guides/introduction/introduction-to-the-standard-directory-layout.html)

### Package hierarchy

Root directory `src/main/java`, post this `package/subpackage/.../className.java`

For example, `src/main/java/com/basics/Basics.java`

```java
package com.basics;

class Basics {
    public static void main(String[] args) {
        System.out.println("Hello World!");
    }
}
```

## Compile & Run

To compile,

```shell
javac package/subpackage/className.java
```

and to run,

```shell
java package.subpackage.className
```

For example, to run above stated `src/main/java/com/basics/Basics.java`

```shell
javac src/main/java/com/basics/Basics.java
cd src/main/java && java com.basics.Basics
```

---

Above processes are packed in [`run.sh`](run.sh), to compile and run

```shell
sh run.sh com.basics Basics
```

## Build & Run Artifact

To build,

```shell
mvn package -f <pom_file>
```

and to run,

```shell
java -jar target/<artifactId>-<version>.jar
```

> Above variables retrieved from `pom.xml`: `project.artifactId` & `project.version`

### [Understanding the POM file](https://maven.apache.org/pom.html)

Example: [basics-pom.xml](basics-pom.xml)
