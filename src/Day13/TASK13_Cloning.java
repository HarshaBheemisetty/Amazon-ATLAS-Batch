package Day13;

import java.util.LinkedList;

public class TASK13_Cloning {
    public static void main(String[] args) {
        LinkedList<String> original = new LinkedList<>();
        original.add("Arun");
        original.add("Teddy");

        LinkedList<String> clone = (LinkedList<String>) original.clone();
        System.out.println("Original LinkedList: " + original);
        System.out.println("Cloned LinkedList: " + clone);
    }
}
