package Day14;

public class HomeTask_DecimalToBinary {

    // Recursive function to convert decimal to binary
    public static void convertToBinary(int n) {
        if (n == 0) {
            return;
        }

        convertToBinary(n / 2);  // recursive call with quotient
        System.out.print(n % 2); // print remainder after recursion
    }

    public static void main(String[] args) {
        int decimal = 13;

        if (decimal == 0) {
            System.out.print(0);
        } else {
            convertToBinary(decimal);
        }
    }
}
