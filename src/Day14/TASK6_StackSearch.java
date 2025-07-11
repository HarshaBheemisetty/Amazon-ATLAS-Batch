package Day14;

import java.util.Stack;

public class TASK6_StackSearch {

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();

        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);

        System.out.println("Current Stack: " + stack);  // [10, 20, 30, 40]

        int searchElement = 20;
        int position = stack.search(searchElement);
        System.out.println("Element found at position : " + position);
        System.out.println(stack.search(20));
    }
}
