
# Scala-Native Starter . [![Build Status](https://travis-ci.org/GnaneshKunal/scala-native-starter.svg?branch=master)](https://travis-ci.org/GnaneshKunal/scala-native-starter.svg?branch=master)
## Background


* [Dependencies](https://github.com/scala-native/scala-native/blob/master/bin/travis_setup.sh#L29-L39)
* [Additional Dependencies](https://github.com/crystal-lang/crystal/wiki/All-required-libraries)

## Requirements

* scala 2.11.x
* sbt 0.13.16

## Installation


In your app directory run `sbt` to install all the dependencies

    sbt    

## Usage

### Link libraries

Add your compilation script in `makefile` file:

    clang -m64 -c src/main/c/hello.c -o target/libhello.so

And in your `scala` file

```scala
    import scalanative.native._
    
    @extern
    @link("hello")
    object hello {
      def greet(str: CString, n: CInt): CString = extern
    }
```

### Compile
```bash
    sbt compile
```

### Compile, link and run
```bash
    sbt run
```

## Run
After compiling, you can find the executable file in target/{SCALA_VERSION}/EXE
```bash
    target/scala-2.11/scala-native-starter-out
```

## License

The MIT License (MIT)
