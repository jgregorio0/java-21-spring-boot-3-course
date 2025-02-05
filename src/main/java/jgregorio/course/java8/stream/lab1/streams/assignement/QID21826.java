package jgregorio.course.java8.stream.lab1.streams.assignement;

import java.util.Optional;

public class QID21826 {
    public static void main(String[] args) {
        // 5. Code a method public static Optional<String> getGrade(int marks)
        //(QID 2.1826)
        //b. in main():
        //i. declare an Optional, typed for String named grade1 which is initialised to the return
        //value of calling getGrade(50)
        Optional<String> grade1 = getGrade(50);
        //ii. declare an Optional, typed for String named grade2 which is initialised to the return
        //value of calling getGrade(55)
        Optional<String> grade2 = getGrade(55);
        //iii. using orElse() on grade1, output the value of grade1 or “UNKNOWN”
        System.out.println("5.b.iii. " + grade1.orElse("UNKNOWN"));
        //iv. if(grade2.isPresent()) is true: use ifPresent(Consumer) to output the contents of
        //grade2; if false, use orElse() to output the contents of grade2 or “Empty”
        grade2.ifPresent(s -> System.out.println("5.b.vi. if present " + s));
        System.out.println("5.b.iv else: " + grade2.orElse("Empty"));
        //v. Notes:
        //1. Optional’s are immutable.
        //2. Optional.of(null); // NullPointerException
        //3. Optional.ofNullable(null); // Optional.empty returned

    }

    public static Optional<String> getGrade(int marks) {
        //a. in the method getGrade:
        //i. declare an empty optional, typed for String called grade
        Optional<String> grade = Optional.empty();
        //ii. insert the following code:
        if (marks > 50) {
            grade = Optional.of("PASS");
        } else {
            grade.of("FAIL");// wrong assignement
        }
        return grade;
    }
}
