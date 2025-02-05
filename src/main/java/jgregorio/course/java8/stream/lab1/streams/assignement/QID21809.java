package jgregorio.course.java8.stream.lab1.streams.assignement;

import java.util.List;
import java.util.OptionalDouble;

public class QID21809 {
    public static void main(String[] args) {
        //6. Given the Book class (in the zip file), declare a List typed for Book with the following Book’s:
        //a. title=”Thinking in Java”, price=30.0
        //b. title=”Java in 24 hrs”, price=20.0
        //c. title=”Java Recipes”, price=10.0
        //Stream the books and calculate the average price of the books whose price is > 10.
        //Change the filter to books whose price is > 90. Ensure you do not get an exception
        List<Book> books = List.of(
                new Book("Thinking in Java", 30.0),
                new Book("Java in 24 hrs", 20.0),
                new Book("Java Recipes", 10.0));
        books.stream()
                .filter(b -> b.getPrice() > 10)
                .mapToDouble(Book::getPrice)
                .average()
                .ifPresent(d -> System.out.println("6. average " + d));
        books.stream()
                .filter(b -> b.getPrice() > 90)
                .mapToDouble(Book::getPrice)
                .average()
                .ifPresent(d -> System.out.println("6. average " + d));
    }
}
