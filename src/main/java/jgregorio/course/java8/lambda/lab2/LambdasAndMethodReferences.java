package jgregorio.course.java8.lambda.lab2;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;

public class LambdasAndMethodReferences {
    public static void main(String[] args) {
        staticMR();
    }

    /**
     * 1. Static method references:
     * <p>
     * method, code a lambda that sorts the list passed in.
     * c. invoke the lambda.
     * d. prove that the sort worked.
     * e. re-initialise the list (so it is unsorted again).
     * f. code the method reference version.
     * i. sort() is overloaded : sort(List) and sort(List, Comparator)
     * ii. how does Java know which version to call?
     * g. invoke the method reference version.
     * h. prove that the sort worked.
     */
    static void staticMR() {
        // a. in staticMR(), declare a List of integers with 1, 2, 7, 4, and 5 as values.
        List<Integer> values = Arrays.asList(1, 2, 7, 4, 5);
        // b. using a Consumer typed for List<Integer> and the Collections.sort static method, code a lambda that sorts the list passed in.
        Consumer<List<Integer>> sortConsumerLambda = (list) -> {
            Collections.sort(list);
        };
        // c. invoke the lambda.
        sortConsumerLambda.accept(values);
        // d. prove that the sort worked.
        List<Integer> test = List.of(1, 2, 4, 5, 7);
        for (int i = 0; i < test.size(); i++) {
            if (!values.get(i).equals(test.get(i))) {
                throw new RuntimeException("No ha ordenado");
            }
        }
        System.out.println("d. The sort worked");

    }

    void boundMR() {

    }

    void unboundMR() {

    }

    void constructorMR() {

    }
}
