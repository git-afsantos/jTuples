# jTuples

> Java gets a pair.

[![Build](https://api.travis-ci.org/git-afsantos/jTuples.svg)](https://travis-ci.org/git-afsantos/jTuples)
[![Coverage Status](https://coveralls.io/repos/github/git-afsantos/jTuples/badge.svg?branch=master)](https://coveralls.io/github/git-afsantos/jTuples?branch=master)
[![Coverity](https://scan.coverity.com/projects/8822/badge.svg)](https://scan.coverity.com/projects/git-afsantos-jtuples)

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

## Documentation

The javadocs can be seen [here](http://git-afsantos.github.io/jTuples/).
