package jgregorio.course.java8.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.*;

public class MethodReference {

    public static void main(String[] args) {
        lambdaVsMethodReference();
        boundMethodReference();
        unboundMethodReference();
        staticMethodReference();
        constructorMethodReference();
        methodReferenceContext();
    }

    private static void methodReferenceContext() {
        System.out.println("*** methodReferenceContext ***");
        System.out.println("1. Context determine which method execute. Supplier vs Function vs BiFunction");
        Supplier<String> testMethodSupplier = TestClass::testMethod;
        System.out.println(testMethodSupplier.get()); // testMethod()
        Function<TestClass, String> testMethodFunction = TestClass::testMethod;
        System.out.println(testMethodFunction.apply(new TestClass())); // testMethod(TestClass c)
        BiFunction<TestClass, TestClass, String> testMethodBiFunction = TestClass::testMethod;
        System.out.println(testMethodBiFunction.apply(new TestClass(), new TestClass())); // testMethod(TestClass c1, TestClass c2)
    }

    static class TestClass {
        public static String testMethod() {
            return "testMethod()";
        }
        public static String testMethod(TestClass c) {
            return "testMethod(TestClass c)";
        }
        public static String testMethod(TestClass c1, TestClass c2) {
            return "testMethod(TestClass c1, TestClass c2)";
        }
    }

    private static void constructorMethodReference() {
        System.out.println("*** constructorMethodReference ***");
        System.out.println("1. Supplier");
//        Supplier<T>
//            T get();
        Supplier<StringBuilder> newStringBuilderSupplier = () -> new StringBuilder();
        Supplier<StringBuilder> newStringBuilderSupplierMethodReference = StringBuilder::new;
        System.out.println(newStringBuilderSupplier.get().append("Hola")); // Hola
        System.out.println(newStringBuilderSupplierMethodReference.get().append("Adios")); // Adios
//        Function<T, R>
//            R apply(T t);
        System.out.println("2. Function");
        Function<Integer, List<String>> newListFunction = x -> new ArrayList(x);
        Function<Integer, List<String>> newListFunctionMethodReference = ArrayList::new;
        List<String> list1 = newListFunction.apply(10);
        list1.add("Hola");
        System.out.println(list1); // [Hola]
        List<String> list2 = newListFunction.apply(1);
        list2.add("Adios");
        System.out.println(list2); // [Adios]
    }

    /**
     * Static Method References are considered unbound
     */
    private static void staticMethodReference() {
        System.out.println("*** staticMethodReference ***");
        System.out.println("1. Consumer");
//        Consumer<T>
//            void accept(T t);
        Consumer<List<Integer>> sortConsumer = (list) -> Collections.sort(list);
        Consumer<List<Integer>> sortConsumerMethodReference = Collections::sort;
        List<Integer> integerList = Arrays.asList(3, 2, 1, 7, 5, 4, 3, 7, 3);
        sortConsumer.accept(integerList);
        System.out.println(integerList); // [1, 2, 3, 3, 3, 4, 5, 7, 7]
        integerList = Arrays.asList(8, 0, 7, 3, 1, 7, 4);
        sortConsumerMethodReference.accept(integerList);
        System.out.println(integerList); // [0, 1, 3, 4, 7, 7, 8]
    }

    /**
     * The Functional interface is NOT bound to any instance
     */
    private static void unboundMethodReference() {
        System.out.println("*** unboundMethodReference ***");
//        Function<T, R>
//            R apply(T t);
        System.out.println("1. Function");
        Function<String, String> upperCaseFunction = (name) -> name.toUpperCase();
        Function<String, String> upperCaseFunctionMethodReference = String::toUpperCase;
        // The function is unbound so an instance must be specified
        System.out.println(upperCaseFunction.apply("Pepe")); // PEPE
        System.out.println(upperCaseFunctionMethodReference.apply("Pepe")); // PEPE
//        BiFunction<T, U, R>
//            R apply(T t, U u);
        System.out.println("2. BiFunction");
        BiFunction<String, String, String> concatBiFunction = (String firstname, String lastname) -> firstname.concat(" " + lastname);
        BiFunction<String, String, String> concatBiFunctionMethodReference = String::concat;
        System.out.println(concatBiFunction.apply("Pepe", "Garrido")); // Pepe Garrido
        System.out.println(concatBiFunctionMethodReference.apply("Pepe", "Garrido")); // Pepe Garrido
    }

    /**
     * The Functional Interface is bound to the instance
     */
    private static void boundMethodReference() {
        System.out.println("*** boundMethodReference ***");
        // Supplier<T>
        //    T get();
        // The Supplier is bound to the instance name
        System.out.println("1. Supplier");
        String boundVariable = "Mr. Pepe";
        Supplier<String> lowerCaseLambda = () -> boundVariable.toLowerCase(); // lambda
        Supplier<String> lowerCaseMethodReference = boundVariable::toLowerCase; // method reference
        // There is no need to pass any argument
        System.out.println(lowerCaseLambda.get());
        System.out.println(lowerCaseMethodReference.get());

        // Predicate<T>
        //    boolean test(T t);
        System.out.println("2. Predicate");
        Predicate<String> startsWithPredicate = (prefix) -> boundVariable.startsWith(prefix);
        Predicate<String> startsWithPredicateMethodReference = boundVariable::startsWith;
        // startsWith is overloaded, it exists boolean startsWith(String prefix) and boolean startsWith(String prefix, int toffset)
        // However, it knows the method we use is with ONE parameter only because Predicate has a functional method test (T t)
        System.out.println(startsWithPredicate.test("Ms.")); // false
        System.out.println(startsWithPredicateMethodReference.test("Mr.")); // true
        // BiConsumer<T, U>
        //      void accept(T t, U u);
        System.out.println("3. BiPredicate");
        BiPredicate<String, Integer> startsWithBiPredicate = (prefix, offset) -> boundVariable.startsWith(prefix, offset);
        BiPredicate<String, Integer> startsWithBiPredicateMethodReference = boundVariable::startsWith;
        // startsWith is overloaded, it exists boolean startsWith(String prefix) and boolean startsWith(String prefix, int toffset)
        // However, it knows the method we use is with TWO parameter because BiConsumer has a functional method accept (T t, U u)
        System.out.println(startsWithBiPredicate.test("Mr.", 0)); // true
        System.out.println(startsWithBiPredicateMethodReference.test("Mr.", 1)); // false
    }

    /**
     * Sample for
     * Interface: Consumer
     * Functional method: accept
     * Lambda vs Method refence
     */
    private static void lambdaVsMethodReference() {
        System.out.println("*** lambdaVsMethodReference ***");
        List<String> names = Arrays.asList("Juan", "Pepe", "Marta");
        names.forEach(name -> System.out.println(name)); // Lambda
        names.forEach(System.out::println); // Method reference
    }
}
