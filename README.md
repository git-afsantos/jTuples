# jTuples

> Java gets a pair.

[![Build](https://api.travis-ci.org/git-afsantos/jTuples.svg)](https://travis-ci.org/git-afsantos/jTuples)
[![Coverage Status](https://coveralls.io/repos/github/git-afsantos/jTuples/badge.svg?branch=master)](https://coveralls.io/github/git-afsantos/jTuples?branch=master)
[![Coverity](https://scan.coverity.com/projects/8822/badge.svg)](https://scan.coverity.com/projects/git-afsantos-jtuples)

Have you ever wanted a pair? Do you end up writing C-like `struct`s every other project? Fear not.

The **jTuples** project provides [tuple](http://en.wikipedia.org/wiki/Tuple) implementations for the Java platform.
With **jTuples**, you can group up to *ten* (!) objects at once (although not recommended).

If you are into functional programming, know that **jTuples** treats functions as first-class citizens.
It provides some utilities to combine functions too!

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

You can also change the order of the elements of the tuples.
You can flip it around:

```java
Pair<String, String> pair = new Pair<>("hello", "world");
Pair<String, String> other = pair.invert();
// => ("world", "hello")
```

If the types do not match, shift the elements to the left, or to the right:

```java
Triple<String, Integer, Double> triple = new Triple<>("one", 1, 1.0);
Triple<Integer, Double, String> toTheLeft = triple.shiftLeft();
// => (1, 1.0, "one")
Triple<Double, String, Integer> toTheRight = triple.shiftRight();
// => (1.0, "one", 1)
```

Integrate with existing code, converting to lists or arrays:

```java
Pair<String, String> pair = new Pair<>("hello", "world");
Object[] array = pair.toArray();
// => ["hello", "world"]
List<?> list = pair.asList();
// => ["hello", "world"]
```

Speaking of lists, zip two lists together:

```java
List<Integer> integers = Arrays.asList(1, 2, 3);
List<String> strings = Arrays.asList("one", "two", "three");
List<Pair<Integer, String>> pairs = Tuples.zip(integers, strings);
// => [(1, "one"), (2, "two"), (3, "three")]
```

## Documentation

The javadocs can be seen [here](http://git-afsantos.github.io/jTuples/).
