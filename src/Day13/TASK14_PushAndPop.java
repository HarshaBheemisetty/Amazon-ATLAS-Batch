package Day13;

import java.util.LinkedList;

public class TASK14_PushAndPop {
    public static void main(String[] args) {
        // Create a LinkedList to use as a stack
        LinkedList<String> stack = new LinkedList<>();

        // Push elements onto the stack (adds to the front)
        stack.push("First");
        stack.push("Second");
        stack.push("Third");

        System.out.println("Stack after pushes: " + stack);

        // Pop element from the stack (removes from the front)
        String popped = stack.pop();
        System.out.println("Popped element: " + popped);

        System.out.println("Stack after pop: " + stack);
    }
}
