package jgregorio.course.java8.lambda;

import java.util.function.BiPredicate;
import java.util.function.Predicate;

public class PredicateSample {
    public static void main(String[] args) {
        Predicate<Integer> isEven = i -> i % 2 == 0;
        System.out.println("is " + 2 + " even? " + isEven.test(2));
        System.out.println("is " + 3 + " even? " + isEven.test(3));

        BiPredicate<String, Integer> isLarger = (s,i) -> s.length() > i;
        String s1 = "Aleluya";
        Integer i1 = 3;
        System.out.println("is " + s1 + " larger than " + i1 + "? " + isLarger.test(s1, i1));
        Integer i2 = 100;
        System.out.println("is " + s1 + " larger than " + i2 + "? " + isLarger.test(s1, i2));
    }
}
