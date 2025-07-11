package Day14;

import java.util.Stack;
public class TASK7_StackPeek {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();

        stack.push(100);
        stack.push(200);
        stack.push(300);

        System.out.println("Stack: " + stack);// [100, 200, 300]
        System.out.println("Peek element : " + stack.peek());
    }
}
