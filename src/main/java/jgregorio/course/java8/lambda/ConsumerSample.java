package jgregorio.course.java8.lambda;

import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class ConsumerSample {
    public static void main(String[] args) {
        Consumer<String> print = (s) -> System.out.println(s);
        print.accept("¡Hola mundo!");
        List<String> fruits = List.of("Banana", "Apple", "Pear");
        fruits.forEach(print);
        BiConsumer<String, String> mapPrinter = (s1,s2) -> System.out.println(s1 + ": " + s2);
        Map<String, String> capitals = Map.of("España", "Madrid", "Francia", "Paris", "Portugal", "Lisboa");
        capitals.forEach(mapPrinter);
    }
}
