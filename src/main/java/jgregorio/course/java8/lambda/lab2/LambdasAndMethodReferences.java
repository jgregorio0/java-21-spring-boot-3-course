package jgregorio.course.java8.lambda.lab2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.*;

public class LambdasAndMethodReferences {
    public static void main(String[] args) {
        staticMR();
        boundMR();
        unboundMR();
        constructorMR();
    }

    /**
     * 1. Static method references
     */
    static void staticMR() {
        System.out.println("1. Static method references");
        // a. in staticMR(), declare a List of integers with 1, 2, 7, 4, and 5 as values.
        List<Integer> values = Arrays.asList(1, 2, 7, 4, 5);
        // b. using a Consumer typed for List<Integer> and the Collections.sort static method, code a lambda that sorts the list passed in.
        Consumer<List<Integer>> sortConsumerLambda = (list) -> {
            Collections.sort(list);
        };
        // c. invoke the lambda.
        sortConsumerLambda.accept(values);
        // d. prove that the sort worked.
        List<Integer> sortedValues = List.of(1, 2, 4, 5, 7);
        validateItemListAreEquals(sortedValues, values);
        System.out.println("d. The sort worked successfully");
//        e. re-initialise the list (so it is unsorted again).
        values = Arrays.asList(1, 2, 7, 4, 5);
//        f. code the method reference version.
        Consumer<List<Integer>> sortConsumerMR = Collections::sort;
//      i. sort() is overloaded : sort(List) and sort(List, Comparator)
//      ii. how does Java know which version to call?
        // Because the Consumer has only one generic type parameter so the compiler knows the method with a one parameter must be chosen.
//      g. invoke the method reference version.
        sortConsumerMR.accept(values);
//      h. prove that the sort worked.
        validateItemListAreEquals(sortedValues, values);
        System.out.println("h. The sort worked successfully");
    }

    private static void validateItemListAreEquals(List<Integer> test, List<Integer> values) {
        for (int i = 0; i < test.size(); i++) {
            if (!values.get(i).equals(test.get(i))) {
                throw new RuntimeException("No ha ordenado");
            }
        }
    }

    /**
     * 2. Bound method references (calling instance methods on a particular object):
     */
    static void boundMR() {
        System.out.println("2. Bound method references (calling instance methods on a particular object):");
//        a. in boundMR(), declare a String variable called name and initialise it to “Mr. Joe Bloggs”.
        String name = "Mr. Joe Bloggs";
//        b. using a Predicate typed for String, code a lambda that checks to see if name starts with the prefix passed in.
        Predicate<String> startsWithPredicate = (prefix) -> {
            return name.startsWith(prefix);
        };
//        c. invoke the lambda passing in “Mr.” which should return true.
        String test = "Mr.";
        System.out.println("c. Does '" + name + "' starts with '" + test + ": " + startsWithPredicate.test(test));
//        d. invoke the lambda passing in “Ms.” which should return false.
        test = "Ms.";
        System.out.println("e. Does '" + name + "' starts with '" + test + ": " + startsWithPredicate.test(test));
//        e. code the method reference version.
        Predicate<String> startsWithMR = name::startsWith;
//        f. repeat c and d above except using the method reference version.
        test = "Mr.";
        System.out.println("f.c. Does '" + name + "' starts with '" + test + ": " + startsWithMR.test(test));
//        d. invoke the lambda passing in “Ms.” which should return false.
        test = "Ms.";
        System.out.println("f.e. Does '" + name + "' starts with '" + test + ": " + startsWithMR.test(test));
    }

    /**
     * 3. Unbound method references (calling instance methods on a parameter):
     */
    static void unboundMR() {
        System.out.println("3. Unbound method references (calling instance methods on a parameter):");
        // a. in unboundMR(), code a Predicate lambda typed for String that checks to see if
        //the string passed in is empty.
        Predicate<String> isEmptyPredicate = (str) -> str.isEmpty();
        //b. invoke the lambda passing in “” (returns true).
        String test = "";
        System.out.println("b. Is '" + test + "' empty:" + isEmptyPredicate.test(test));
        //c. invoke the lambda passing in “xyz” (returns false).
        test = "xyz";
        System.out.println("c. Is '" + test + "' empty:" + isEmptyPredicate.test(test));
        //d. code the method reference version of the lambda from (a).
        Predicate<String> isEmptyMR = String::isEmpty;
        //e. repeat b and c above except using the method reference version.
        test = "";
        System.out.println("e.b. Is '" + test + "' empty:" + isEmptyMR.test(test));
        test = "xyz";
        System.out.println("e.c. Is '" + test + "' empty:" + isEmptyMR.test(test));
        //f. code a BiPredicate lambda typed for String and String:
        //i. the lambda takes in two parameters (hence “Bi”)
        //ii. check if the first parameter starts with the second parameter
        BiPredicate<String, String> startsWithBiPredicate = (a, b) -> a.startsWith(b);
        //iii. invoke the lambda twice:
        //1. passing in “Mr. Joe Bloggs” and “Mr.” (returns true)
        test = "Mr. Joe Bloggs";
        String test2 = "Mr.";
        System.out.println("f.1. Does '" + test + "' starts with '" + test2 + ": " + startsWithBiPredicate.test(test, test2));
        //2. passing in “Mr. Joe Bloggs” and “Ms.” (returns false)
        test2 = "Ms.";
        System.out.println("f.2. Does '" + test + "' starts with '" + test2 + ": " + startsWithBiPredicate.test(test, test2));
        //g. code the method reference version of the lambda from (f).
        BiPredicate<String, String> startsWithMR = String::startsWith;
        //h. test it as per above in (f.iii)
        test2 = "Mr.";
        System.out.println("g.1. Does '" + test + "' starts with '" + test2 + ": " + startsWithMR.test(test, test2));
        test2 = "Ms.";
        System.out.println("g.2. Does '" + test + "' starts with '" + test2 + ": " + startsWithMR.test(test, test2));
    }

    /**
     * 4. Constructor method references:
     */
    static void constructorMR() {
        System.out.println("4. Constructor method references:");
        //a. in constructorMR(), code a Supplier typed for List<String> that returns a new ArrayList.
        Supplier<List<String>> arrayListSupplier = () -> new ArrayList<>();
        //b. invoke the lambda to create a new List<String> named list.
        List<String> list = arrayListSupplier.get();
        //c. add “Lambda” to the list.
        list.add("Lambda");
        //d. output the list to show it worked.
        System.out.println("d. list should contain 'Lambda': " + list);
        //e. code the method reference version of the lambda:
        Supplier<List<String>> arrayListMR = ArrayList::new;
        //i. re-initialise list by invoking the method reference version.
        list = arrayListMR.get();
        //ii. add “Method Reference” to the list.
        list.add("Method Reference");
        //iii. output the list to show it worked.
        System.out.println("e. list should contain 'Method Reference': " + list);
        //f. next, we want to use the overloaded ArrayList constructor passing in 10 as the initial capacity (note: the default constructor assumes a capacity of 10).
        //i. thus, we need to pass IN something and get back OUT something:
        //1. IN: 10 OUT: ArrayList
        //ii. we need a Function typed for Integer and List<String> for this.
        //iii. code the lambda.
        Function<Integer, List<String>> arrayListFunction = (i) -> new ArrayList<>(i);
        //iv. re-initialise the list by invoking the lambda passing in 10 as the capacity.
        list = arrayListFunction.apply(10);
        //v. add “Lambda” to the list.
        list.add("Lambda");
        //vi. output the list to show it worked.
        System.out.println("f. list should contain 'Lambda': " + list);
        //g. code the method reference version.
        Function<Integer, List<String>> arrayListFunctionMR = ArrayList::new;
        //i. note that the method reference version is the exact same as above in e!!
        //ii. this is where context is all important:
        //1. the first method reference was for a Supplier and Supplier’s
        //functional method is T get() and thus, Java knew to look for the
        //ArrayList constructor that takes in NO argument
        //2. the first method reference was for a Function and Function’s
        //functional method is R apply(T t) and thus, Java knew to look for
        //the ArrayList constructor that takes in ONE argument.
    }
}
