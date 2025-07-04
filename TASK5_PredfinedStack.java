package Day14;
import java.util.Stack;
public class TASK5_PredfinedStack {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();

        stack.push(10);
        stack.push(20);
        stack.push(30);

        System.out.println("Stack: " + stack); // [10, 20, 30]

        // Peek (top of stack)
        System.out.println("Top element: " + stack.peek()); // 30

        // Pop
        System.out.println("Popped: " + stack.pop()); // 30
        System.out.println("Stack after pop: " + stack); // [10, 20]
        System.out.println("Popped: " + stack.pop()); // 20
        System.out.println("Stack after pop: " + stack); // [10, 20]
    }
}
