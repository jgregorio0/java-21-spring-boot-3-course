package jgregorio.course.java8.stream.lab1.streams.assignement;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class QID21840 {
    public static void main(String[] args) {
        //13. This question demonstrates lazy evaluation. Declare the following List<Integer> ls =
        //Arrays.asList(11, 11, 22, 33, 33, 55, 66);
        List<Integer> ls = Arrays.asList(11, 11, 22, 33, 33, 55, 66);
        //a. stream the List (note that this is possible because List is a Collection and Collection defines a
        //stream() method); ensure only distinct (unique) numbers are streamed; check if “any match”
        //11. You should get true for this.
        boolean match = ls.stream().distinct().anyMatch(n -> 11 == n);
        System.out.println("13.a any match " + match);
        //b. stream the List again (this is necessary because once a stream is closed by a previous terminal
        //operation, you must re-create the stream); check to see if “none match” the expression
        //x%11>0. Note that the terminal operation noneMatch(Predicate) needs to return false for
        //every element in the stream for noneMatch() to return true. In other words, “none of them
        //match this….that’s correct, none of them do; return true”. You should get true here as well.
        boolean match1 = ls.stream().noneMatch(n -> n % 11 > 0);
        System.out.println("13.b none match " + match1);
    }
}
