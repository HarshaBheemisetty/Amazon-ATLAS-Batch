import java.util.Scanner;
public class Day18_DigitByDigit {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a 6-digit number: ");
        String num = scanner.nextLine();

        if (num.length() != 6 || !num.matches("\\d{6}")) {
            System.out.println("Please enter a valid 6-digit number.");
        } else {
            System.out.println("units digit is " + num.charAt(5));
            System.out.println("Ones digit is " + num.charAt(4));
            System.out.println("Hundreds digit is " + num.charAt(3));
            System.out.println("Thousands digit is " + num.charAt(2));
            System.out.println("10 thousands digit is " + num.charAt(1));
            System.out.println("Lakhs digit is " + num.charAt(0));
        }

        scanner.close();
    }
}
