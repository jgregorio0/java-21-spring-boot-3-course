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

