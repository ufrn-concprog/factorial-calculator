# factorial-calculator
Demonstration of the use of callables and futures in Java concurrent programming

# Factorial concurrent calculator #

## About ##
This project implements the concurrent calculation of the [factorial](https://en.wikipedia.org/wiki/Factorial) of integer numbers using _callables_ and _futures_ in the Java programming language. 

A callable object, an instance of the [`Callable` interface](https://docs.oracle.com/en/java/javase/19/docs/api/java.base/java/util/concurrent/Callable.html), represents a task that will be executed concurrently, but that will return a value when it is finished. This value is a [`Future` object](https://docs.oracle.com/en/java/javase/19/docs/api/java.base/java/util/concurrent/Future.html): a value that will be returned by a thread in the future, when the task has been completed. If the thread has not yet returned the value, then it is suspended.

## Repository structure
Source code in this repository is organized as follows:

```
+─factorial-calculator                  ---> Project directory
  ├─── doc                              ---> Directory with HTML pages resulted from generated Javadoc
  └─── src                              ---> Directory with source code files
       └─── FactorialCalculator.java    ---> Base factorial calculator to run upon a thread
       └─── MultiThreadCalculator.java  ---> Program version that uses multiple threads to calculate the factorial of a set of numbers
       └─── SingleThreadCalculator.java ---> Program version that uses a single thread to calculate the factorial of a set of numbers
```

After cloning this repository with `git clone` to your local file system, you can import it to your preferred IDE.
[Java Development Kit (JDK)](https://www.oracle.com/java/technologies/downloads/) is required to develop with and run
these programs. HTML documentation is generated by running the `javadoc` command.