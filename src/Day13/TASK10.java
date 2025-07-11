package Day13;

import java.util.LinkedList;

public class TASK10 {
    public static void main(String[] args) {
        LinkedList<String> items = new LinkedList<>();

        // Add elements to the LinkedList
        items.add("Pen");
        items.add("Notebook");
        items.add("Pencil");
        items.add("Eraser");

        System.out.println("Display using for loop with get():");
        for (int i = 0; i < items.size(); i++) {
            System.out.println("Item at index " + i + ": " + items.get(i));
        }

        System.out.println("\nDisplay using for-each loop:");
        for (String item : items) {
            System.out.println("Item: " + item);
        }
    }
}
