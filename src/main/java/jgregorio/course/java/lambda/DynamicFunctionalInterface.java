package jgregorio.course.java.lambda;

import java.util.function.Predicate;

public class DynamicFunctionalInterface {
    interface Evaluate<T> {
        boolean isNegative(T t);
    }

    public static void main(String[] args) {
        Evaluate<Integer> lambda = i -> i < 0;
        System.out.println("Evaluate -1: " + lambda.isNegative(-1));
        System.out.println("Evaluate 1: " + lambda.isNegative(1));

        Predicate<Integer> predicate = i -> i < 0;
        System.out.println("predicate -1: " + predicate.test(-1));
        System.out.println("predicate 1: " + predicate.test(1));

    }
}
