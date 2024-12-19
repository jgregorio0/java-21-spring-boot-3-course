package jgregorio.course.java.lambda;

import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;

public class FunctionSample {
    public static void main(String[] args) {
        Function<String, Integer> getLength = s -> s.length();
        String s = "¡Hola mundo!";
        System.out.println(s + " is " + getLength.apply(s) + " length");
        BiFunction<String, String, Integer> addLengths = (s1,s2) -> s1.length() + s2.length();
        String s1 = "Madrid";
        String s2 = "Barcelona";
        System.out.println(s1 + " and " + s2 + " lengths are: " + addLengths.apply(s1, s2));
    }
}
