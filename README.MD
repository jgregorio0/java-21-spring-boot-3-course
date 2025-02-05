Java SE 21 Developer Course
---

# References

- [Become a Java SE 21 Developer](https://mylearn.oracle.com/ou/learning-path/become-a-java-se-21-developer/138845)

# Description

1. Java 8 Advanced:
    1. Lambda Expressions
    17. Streams
    18. Generics
    19. Collections
    20. Concurrency
    21. JDBC
    22. File IO
    23. NIO.2
    24. Serialisation
    25. Localisation

2. Java 11:
    1. Modules
    11. private interface methods
    12. LVTI (local variable type inference)
    13. Annotations
    14. Security

3. Java 17:
    1. Sealed classes
    6. Records
    7. switch expressions and pattern matching
    8. Text blocks

4. Java 21:
    1. Unnamed classes and instance main methods
    2. Record patterns
    3. Pattern matching for switch
    4. Sequenced collections

5. Spring Boot Application:
    1. configuring a Spring Boot application, including its dependencies
    2. understanding how RESTful applications work
    3. architecture overview
    4. code explained in detail
    5. testing the application with Postman

# Java 8 Advanced

## Lambda Expressions

- Lambda pre and pos Java 8: [BasicLambdas.java](src/main/java/jgregorio/course/java8/lambda/BasicLambdas.java)
- Lambda implemented by a dynamic functional
  interface [DynamicFunctionalInterface.java](src/main/java/jgregorio/course/java8/lambda/DynamicFunctionalInterface.java)
- Functional interfaces API in `java.util.function` package
- Predicate: [PredicateSample.java](src/main/java/jgregorio/course/java8/lambda/PredicateSample.java)
- Supplier: [SupplierSample.java](src/main/java/jgregorio/course/java8/lambda/SupplierSample.java)
- Consumer: [ConsumerSample.java](src/main/java/jgregorio/course/java8/lambda/ConsumerSample.java)
- Function: [FunctionSample.java](src/main/java/jgregorio/course/java8/lambda/FunctionSample.java)
- Unary and binary
  operator: [UnaryAndBinaryOperatorSample.java](src/main/java/jgregorio/course/java8/lambda/UnaryAndBinaryOperatorSample.java)

### Final or effectively final:

- Variable used in lambda expression should be final or effectively final
- They cannot be modified
- sample: [EffectivelyFinal.java](src/main/java/jgregorio/course/java8/lambda/EffectivelyFinal.java)

### Method references:

- 4 types:
  - Bound: instance known at compile-time
  - Unbound: instance provided at runtime
  - Static
  - Constructor
- Context is the key
- Compiler turns method references into lambdas in the background
- sample: [MethodReference.java](src/main/java/jgregorio/course/java8/lambda/MethodReference.java)
- 

### Lab 1
[1-Lambdas-Lab.pdf](src/main/resources/java8/lambda/lab/1-Lambdas-Lab.pdf)

### Lab 2
Instructions:
[2-Lambdas+and+Method+References+Exercises+v2.pdf](src/main/resources/java8/lambda/lab/2-Lambdas%2Band%2BMethod%2BReferences%2BExercises%2Bv2.pdf)
Completed:
[LambdasAndMethodReferences.java](src/main/java/jgregorio/course/java8/lambda/lab2/LambdasAndMethodReferences.java)

## Streams
stream pipeline
- Source: array, collection, etc...
- Intermediate operations: transform stream into another
- Terminal operation: produces a result

### Stream lazyness
Nothing happens until the terminal operation occurs.

The stream operates in a vertical manner. 
All stream operations are performed on an element until next element is processed.

### Terminal operations
- Reduction
Reductions are terminal operations where ALL of the contents are combined into a single primitive or Object.
```
Stream.of("h", "o", "l", "a").peek(System.out::println)
// Processes all values and prints them
```

- Accumulator: mutable variables that can be modified by tasks during execution of a streaming job.
```
Stream.of("h", "o", "l", "a").reduce("", (a,b) -> a+b)
// returns single Object "hola". The String "" is an accumulator.
```

- Collect: mutable reduction. The same mutable object is used while accumulating.

- PartitioningBy: grouping where groups are true or false.

### Intermediate operations

- filter: returns a Stream with the elements that match the given Predicate.
- distinct: returns a Stream with duplicated values removed
- limit: returns a Stream containing the limit number of elements
- map: returns a Stream with elements transformed by the mapping function
- flatMap: returns a Stream with a collection of elements contained by each element
- sorted: returns a Stream with sorted elements

### Primitive Streams
- IntStream: for int, short, byte and char
- DoubleStream: for double and float
- LongStream: for long

common methods:
- average
- max
- min
- sum

### Optionals
Represents an object that may or not be empty

- ifPresent: executes if value is not empty
- orElseGet: returns value if not empty or else value provided

### Parallel Streams
Stream parallel elements.
Be careful if factors order changes the result.



