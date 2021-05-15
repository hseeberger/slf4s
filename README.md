# slf4s #

![Build](https://img.shields.io/github/workflow/status/hseeberger/slf4s/Test)
![Maven Central](https://img.shields.io/maven-central/v/rocks.heikoseeberger/slf4s)

slf4s is a library providing convenient and performant logging for Scala 3. It piggybacks on
[SLF4J](http://www.slf4j.org/) and it automagically applies the check-enabled-idiom thanks to
Scala 3 metaprogramming.

In a nutshell, you can invoke logging methods like `info` without checking whether the respective
log level is enabled, because that exact check is handled for you by the compiler:

``` scala
val expensive = "expensive"
val logger = Logger(getClass)
logger.info(s"I am an $expensive log message!") // unnecessary String interpolation?
```

The compiler will – more or less – create the following code for you:

``` scala
...
if (logger.isInfoEnabled)
  logger.info(s"I am an $expensive log message!")
```

So if the respective log level is not enabled, the potentially expensive construction of the log
message will not happen, even though you do not have to spend any efforts on that.

Further slf4s makes it easy to work with MDCs (a.k.a. context maps):

``` scala
withMDC("key1" -> "value1", "key2" -> "value2") {
  logger.info("Some message")
  ...
  logger.info("Some other message")
}
```

The `withMDC` method takes one or more MDC entries (key-value-pairs) and a block of code. Within
that block the key-value-pairs are put on the MDC and removed afterwards even in the case of an
exception.

slf4s is inspired by:
- [Scala Logging](https://github.com/lightbend/scala-logging)
- [Scala 3 / Dotty docs](http://dotty.epfl.ch/docs/reference/metaprogramming/inline.html)

## Contribution policy ##

Contributions via GitHub pull requests are gladly accepted from their original author. Along with
any pull requests, please state that the contribution is your original work and that you license
the work to the project under the project's open source license. Whether or not you state this
explicitly, by submitting any copyrighted material via pull request, email, or other means you
agree to license the material under the project's open source license and warrant that you have the
legal authority to do so.

## License ##

This code is open source software licensed under the
[Apache-2.0](http://www.apache.org/licenses/LICENSE-2.0) license.
