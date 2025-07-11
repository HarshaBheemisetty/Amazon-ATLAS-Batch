package Day13;

import java.util.LinkedList;

public class TASK8_RemoveElements {
    public static void main(String[] args) {
        // Create a LinkedList of Strings
        LinkedList<String> fruits = new LinkedList<>();

        // Add elements to the LinkedList
        fruits.add("Apple");
        fruits.add("Banana");
        fruits.add("Mango");
        fruits.add("Grapes");
        System.out.println("LinkedList elements: " + fruits);
        for(String s : fruits)
        {
            System.out.println(s);
        }
        System.out.println("Remove 1st element of Linkedlist : " + fruits.removeFirst());
        System.out.println("Remove last element of Linkedlist : " + fruits.removeLast());

    }
}