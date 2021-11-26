# java
learning java

## Standard directory layout

| Directory | Description |
| :--- | :--- |
| `src` | Source material for building the project |
| `src/main` | Main build artifact |
| `src/main/java` | Application/Library sources (below this, the normal package hierarchy exists) |
| `src/main/resources` | Application/Library resources |
| `src/main/filters` | Resource filter files |
| `src/main/webapp` | Web application sources |
| `src/test` | Unit test code |
| `src/test/java` | Test sources |
| `src/test/resources` | Test resources |
| `src/test/filters` | Test resource filter files |
| `src/it` | Integration Tests (primarily for plugins) |
| `src/assembly` | Assembly descriptors |
| `target` | Build output's destination |

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

Above processes are packed in `run.sh`, to compile and run

```shell
sh run.sh com.basics Basics
```
