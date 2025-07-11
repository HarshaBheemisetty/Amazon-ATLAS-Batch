package Day13;

import java.util.LinkedList;
import java.util.Spliterator;

public class TASK16_Splits {
    public static void main(String[] args) {
        LinkedList<String> data = new LinkedList<>();
        data.add("Nirupa");
        data.add("Anu");
        data.add("Shruthika");
        data.add("Advika");

        Spliterator<String> s1 = data.spliterator();
        Spliterator<String> s2 = s1.trySplit();

        System.out.println("Spliterator 1:");
        while (s1.tryAdvance(System.out::println));

        System.out.println("Spliterator 2:");
        while (s2.tryAdvance(System.out::println));
    }
}
