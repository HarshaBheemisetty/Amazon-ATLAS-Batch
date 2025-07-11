package Day13;

import java.util.LinkedList;

class TASK6_GetElements {
    public static void main(String[] args) {
        // Create a LinkedList of Strings
        LinkedList<String> fruits = new LinkedList<>();

        // Add elements to the LinkedList
        fruits.add("Apple");
        fruits.add("Banana");
        fruits.add("Mango");
        fruits.add("Grapes");
        System.out.println("LinkedList elements: " + fruits);
        System.out.println("1st element of Linkedlist : " + fruits.get(0));
        System.out.println("last element of Linkedlist : " + fruits.get(3));

    }
}