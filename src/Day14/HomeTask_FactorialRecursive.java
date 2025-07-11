package Day14;

import java.util.Scanner;

public class HomeTask_FactorialRecursive {
    // Recursive method to calculate factorial
    static long factorial(int n) {
        if (n == 0 || n == 1)
            return 1;
        return n * factorial(n - 1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int n = sc.nextInt();

        long result = factorial(n);
        System.out.println("Factorial of " + n + " is: " + result);
    }
}
