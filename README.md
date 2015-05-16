# jTuples

> Java gets a pair.

The **jTuples** project provides [tuple](http://en.wikipedia.org/wiki/Tuple) implementations for the Java platform.

Requires JDK 8 or higher.

## Installation

You can use Maven to build **jTuples** and install it into your Maven
repository with the following command:

```console
mvn install
```

If you do not use Maven to manage your project build, you can build a .jar
file with the following command:

```console
mvn package
```

The .jar will be placed in the "target" directory.

## Usage

You can create a Pair in one of two ways:

1. With the constructor:
  ```java
  Pair<String, String> pair = new Pair<>("hello", "world");
  ```

2. With `Tuples.with` factory method:
  ```java
  Pair<String, String> pair = Tuples.with("hello", "world");
  ```

The `Tuples` class also has factory methods for other tuples.

All tuples are immutable. To easily change a member of a tuple, you can use
one of the `apply*` methods to create a new tuple by applying a function:

```java
Pair<String, String> pair = new Pair<>("hello", "world");
Pair<String, String> other = pair.applySecond(s -> s.toUpperCase());
// => ("hello", "WORLD")
```

