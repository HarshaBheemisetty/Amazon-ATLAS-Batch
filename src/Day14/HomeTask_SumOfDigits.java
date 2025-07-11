package Day14;

public class HomeTask_SumOfDigits {

    // Recursive function to calculate sum of digits
    public static int sumDigits(int number) {
        // Base case: when number becomes 0
        if (number == 0) {
            return 0;
        }

        // Recursive case: add last digit + sum of remaining digits
        return (number % 10) + sumDigits(number / 10);
    }

    public static void main(String[] args) {
        int num = 1234;

        int sum = sumDigits(num);
        System.out.println("Sum of digits of " + num + " = " + sum);
    }
}
