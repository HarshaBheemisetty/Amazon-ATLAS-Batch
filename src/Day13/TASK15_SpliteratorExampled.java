package Day13;

import java.util.LinkedList;
import java.util.Spliterator;

public class TASK15_SpliteratorExampled {
    public static void main(String[] args) {
        LinkedList<String> names = new LinkedList<>();
        names.add("Arun");
        names.add("Kumar");
        names.add("Arun Kumar");

        Spliterator<String> sp = names.spliterator();
        System.out.println("Using Spliterator:");
        sp.forEachRemaining(System.out::println);
    }
}
