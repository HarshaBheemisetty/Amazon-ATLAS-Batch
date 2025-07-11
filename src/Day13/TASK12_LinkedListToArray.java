package Day13;

import java.util.LinkedList;

public class TASK12_LinkedListToArray {
    public static void main(String[] args) {
        // Create and populate the LinkedList
        LinkedList<String> names = new LinkedList<>();
        names.add("Pen");
        names.add("Book");
        names.add("Paper");
        System.out.println(names);


        // Convert LinkedList to Object array
        Object[] arr = names.toArray();

        // Display elements of the array
        System.out.println("Elements in Object[] array:");
        for (Object obj : arr) {
            System.out.println(obj);
        }
    }
}

