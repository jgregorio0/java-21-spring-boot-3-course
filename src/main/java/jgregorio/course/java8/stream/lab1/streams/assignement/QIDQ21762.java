package jgregorio.course.java8.stream.lab1.streams.assignement;

import java.util.Comparator;
import java.util.List;

public class QIDQ21762 {
    public static void main(String[] args) {
        // 2. Given the Item class (in the zip file), declare a List typed for Item with the following Item’s:
        //a. id=1 name=”Screw”
        //b. id=2 name=”Nail”
        //c. id=3 name=”Bolt”
        //Stream the list and sort it so that it outputs “BoltNailScrew” i.e. alphabetic name order. Use Stream’s
        //forEach method to output the names (use the method reference version for the required Consumer
        //lambda).+
        List<Item> items = List.of(
                new Item(1, "Screw"),
                new Item(2, "Nail"),
                new Item(3, "Bolt"));
        items.stream()
                .sorted(Comparator.comparing(Item::getName))
                .forEach(System.out::println);
    }
}
