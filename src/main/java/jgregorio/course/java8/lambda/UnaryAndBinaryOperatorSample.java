package jgregorio.course.java8.lambda;

import java.util.function.BinaryOperator;
import java.util.function.UnaryOperator;

public class UnaryAndBinaryOperatorSample {
    public static void main(String[] args) {
        UnaryOperator<String> nameText = s -> "My name is " + s;
        String firstname = "Pepito";
        System.out.println(nameText.apply(firstname));
        BinaryOperator<String> fullname = (name, surname) -> name + " " + surname;
        String lastname = "Perez";
        System.out.println("My fullname is " + fullname.apply(firstname, lastname));
    }
}
