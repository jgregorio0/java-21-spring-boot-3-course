package jgregorio.course.java8.stream.lab1.streams.assignement;

import java.util.Optional;

public class QID21849 {
    public static void main(String[] args) {
        //10. A question about Optional. Let us look at this in parts:
        //a. Declare an Optional, typed for Double, named ‘price’ using the Optional.ofNullable(20.0).
        //Output the Optional value for ‘price’ 3 times: using ifPresent(Consumer), orElse(T) and
        //orElseGet(Supplier).
        Optional<Double> price = Optional.ofNullable(20.0);
        price.ifPresent(p -> System.out.println("10.a.i price " + p));
        System.out.println("10.a.ii price " + price.orElse(null));
        System.out.println("10.a.ii price " + price.orElseGet(() -> null));
        //b. declare a new Optional, typed for Double, named ‘price2’ (or comment out (a) and re-use
        //‘price’). Use Optional.ofNullable again but this time, pass in null.
        Optional<Double> price2 = Optional.ofNullable(null);
        //i. Output ‘price2’ in a normal System.out.println().
        System.out.println("10.b.i. price " + price2);
        //ii. check to see if price2 isEmpty() and if so output “empty”.
        System.out.println("10.b.ii price " + (price2.isEmpty() ? "empty" : price2.get()));
        //iii. do (ii) again except this time use the more functional “ifPresent(Consumer)” method.
        price2.ifPresent(v -> System.out.println("10.b.iii price " + v));
        //iv. initialise a Double x to the return of “price2.orElse(44.0)”. Output and observe the
        //value of x.
        //c. declare a new Optional, typed for Double, named ‘price3’ (or comment out (b) and re-use
        //‘price’). Use Optional.ofNullable passing in null.
        //i. initialise a Double z to the return of “price3.orElseThrow(() -> new
        //RuntimeException(“Bad Code”). Output and observe the value of z

    }
}
