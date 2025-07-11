package Day14;
import java.util.Stack;
public class TASK8_StackOperations {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();

        // Check if the stack is empty initially
        System.out.println("Is stack empty? " + stack.isEmpty());  // true
        stack.push(10);
        stack.push(20);
        stack.push(30);
        System.out.println("Stack after pushing: " + stack);  // [10, 20, 30]

        System.out.println("Is stack empty now? " + stack.isEmpty());  // false

        int poppedElement = stack.pop();
        System.out.println("Popped element: " + poppedElement);  // 30
        int poppedElement1 = stack.pop();
        System.out.println("Popped element: " + poppedElement1);
        int poppedElement2 = stack.pop();
        System.out.println("Popped element: " + poppedElement2);
        System.out.println("Stack after pop: " + stack);
        if(stack.isEmpty())
        {
            System.out.println("Stack is Empty");
        }
    }
}
