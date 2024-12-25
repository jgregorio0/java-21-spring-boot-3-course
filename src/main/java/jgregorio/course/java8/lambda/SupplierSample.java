package jgregorio.course.java8.lambda;

import java.time.LocalTime;
import java.util.function.Supplier;

public class SupplierSample {
    public static void main(String[] args) {
        Supplier<LocalTime> timeSupplier = () -> LocalTime.now();
        System.out.println("What is the time? " + timeSupplier.get());
        Supplier<Double> randomDoubleSupplier = () -> Math.random();
        System.out.println("Give me a random: " + randomDoubleSupplier.get());
        System.out.println("Another random: " + randomDoubleSupplier.get());
    }
}
