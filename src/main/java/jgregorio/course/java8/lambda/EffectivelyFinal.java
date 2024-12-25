package jgregorio.course.java8.lambda;

import java.util.function.BinaryOperator;
import java.util.function.UnaryOperator;

public class EffectivelyFinal {
    public static void main(String[] args) {
        String text = "My name is "; // Variable used in lambda expression should be final or effectively final
        //text = "if I try to modify this variable the compiler throws an error";
        UnaryOperator<String> nameText = s -> text + s;
        //text = "if I try to modify this variable the compiler throws an error";
        String firstname = "Pepito";
        System.out.println(nameText.apply(firstname));
        BinaryOperator<String> fullname = (name, surname) -> name + " " + surname;
        String lastname = "Perez";
        System.out.println("My fullname is " + fullname.apply(firstname, lastname));
    }
}
