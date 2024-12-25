package jgregorio.course.java8.lambda;

public class BasicLambdas {
    interface I {
        void m();// a functional interface i.e. it has only one abstract method
    }

    public static void main(String[] args) {
        // pre-Java 8
        I i = new I() {
            @Override
            public void m() {
                System.out.println("I::m()");
            }
        };
        i.m(); // I::m()

        // Java 8 Lambda expression
        I lambdaI = () -> {
            System.out.println("Lambda version 1");
        };
        I lambda12 = () -> System.out.println("Lambda version 2");
        lambdaI.m(); // Lambda version
        lambda12.m();// Lambda version
    }
}
