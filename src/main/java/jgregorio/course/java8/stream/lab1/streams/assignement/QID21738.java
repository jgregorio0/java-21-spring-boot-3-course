package jgregorio.course.java8.stream.lab1.streams.assignement;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.stream.IntStream;

public class QID21738 {
    public static void main(String[] args) {

        // 4. There are several parts to this:
        //a. Using 1, 2 and 3 create a List of Integers.
        List<Integer> list = List.of(1, 2, 3);
        //i. Stream the list and calculate the sum, using the sum() method from IntStream.
        int sum = list.stream().mapToInt(Integer::intValue).sum();
        System.out.println("4.a.i. Sum is " + sum);
        //ii. Stream the list again and calculate the maximum value, using the max() method from
        //IntStream.
        int max = list.stream().mapToInt(Integer::intValue).max().getAsInt();
        System.out.println("4.a.ii. Maximum is " + max);
        //b. Given the Person class (in the zip file), declare a List typed for Person with the following
        //Person’s:
        //i. “Alan”, “Burke”, 22
        //ii. “Zoe”, “Peters”, 20
        //iii. “Peter”, “Castle”, 29
        List<Person> people = List.of(new Person("Alan", "Burke", 22),
                new Person("Zoe", "Peters", 20),
                new Person("Peter", "Castle", 29));
        //Using the max(Comparator) from Stream, calculate the oldest person in the list.
        Optional<Person> maxPerson = people.stream().max(Comparator.comparing(Person::getAge));
        maxPerson.ifPresent(m -> System.out.println("4.b. Max person is " + m));
        //c. Using 10, 47, 33 and 23 create a List of Integers. Stream the list and using the following
        //versions of reduce(), calculate the maximum value:
        List<Integer> ints = List.of(10, 47, 33, 23);
        //i. Optional<T> reduce(BinaryOperator<T> accumulator)
        Optional<Integer> maxInt = ints.stream().reduce(Integer::max);
        maxInt.ifPresent(m -> System.out.println("M4.c.i. Max int is " + m));
        //ii. T reduce(T identity, BinaryOperator<T> accumulator)
        Integer max2 = ints.stream().reduce(0, Integer::max);
        System.out.println("M4.c.i. Max int is " + max2);
    }
}
