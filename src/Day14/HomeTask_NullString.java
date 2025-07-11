package Day14;

public class HomeTask_NullString {

    // Recursive function to reverse a string
    public static String reverse(String str) {
        // Base case: if the string is empty or has one character
        if (str == null || str.length() <= 1) {
            return str;
        }

        // Recursive case:
        // last character + reverse of the substring excluding the last character
        return str.charAt(str.length() - 1) + reverse(str.substring(0, str.length() - 1));
    }

    public static void main(String[] args) {
        String input = "hello";
        String reversed = reverse(input);
        System.out.println("Reversed string: " + reversed);
    }
}

