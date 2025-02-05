package jgregorio.course.java8.stream.lab1.streams.assignement;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

public class QID21841 {
    public static void main(String[] args) {
        //14. Examine the following code. Note that an AtomicInteger is a version of Integer that is safe to use in
        //concurrent (multi-threaded) environments. The method incrementAndGet() is similar to ++ai
        //a) Why is the value of ai at the end 0 (and not 4)?
        AtomicInteger ai = new AtomicInteger();
        Stream.of(11, 11, 22, 33)
                .parallel()
                .filter(n -> {
                    ai.incrementAndGet();
                    return n % 2 == 0;
                });
        System.out.println(ai);
        // RES: because filter is not a terminal operation
        //b) The following code generates an IllegalStateException. Fix the code.
        AtomicInteger ai2 = new AtomicInteger();
        Stream<Integer> stream = Stream.of(11, 11, 22, 33)
                .parallel();
        stream.filter(n -> {
                    ai2.incrementAndGet();
                    return n % 2 == 0;
                })
                .forEach(System.out::println);
        System.out.println(ai2);
    }
}
