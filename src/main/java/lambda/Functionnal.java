package lambda;

import java.util.function.Consumer;

public class Functionnal {
    public static void  main(String[] args) {
        Consumer<Person> greeter = (p) -> System.out.println("Hello, " + p.getName());
        greeter.accept(new Person("Lambda"));
    }
}