import java.util.Scanner;
public class Day18_CountDigits {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Taking input
        System.out.print("Enter a number: ");
        long number = sc.nextLong(); // long used to handle big numbers

        // Converting negative to positive
        number = Math.abs(number);

        // Counting digits
        int digitCount = 0;
        if (number == 0) {
            digitCount = 1;
        } else {
            while (number > 0) {
                number /= 10;
                digitCount++;
            }
        }

        // Displaying result
        System.out.println("It's a " + digitCount + " digit number.");
    }
}
