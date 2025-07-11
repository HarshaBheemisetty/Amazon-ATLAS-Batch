package Day14;

public class HomeTask_CountDigits {

    // Recursive function to count digits
    public static int countDigits(int number) {
        // Base case: if number is 0, it has 0 digits (handled separately for 0 case)
        if (number == 0) {
            return 0;
        }

        // Recursive case: divide number by 10 and add 1 to the count
        return 1 + countDigits(number / 10);
    }

    public static void main(String[] args) {
        int num = 12345;

        // Special case for 0
        if (num == 0) {
            System.out.println("Number of digits: 1");
        } else {
            int digitCount = countDigits(num);
            System.out.println("Number of digits: " + digitCount);
        }
    }
}
