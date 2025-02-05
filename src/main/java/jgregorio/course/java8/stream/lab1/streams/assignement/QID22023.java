package jgregorio.course.java8.stream.lab1.streams.assignement;

import java.util.OptionalDouble;
import java.util.stream.IntStream;

public class QID22023 {
    public static void main(String[] args) {
        // 1. Stream a list of int primitives between the range of 0 (inclusive) and 5 (exclusive). Calculate and
        //output the average.
        //(QID 2.2023)
        IntStream.range(0, 5)
                .average()
                .ifPresent(s -> System.out.println("1- the average of the range 0 (inclusive) and 5 (exclusive) is: " + s));
    }
}
