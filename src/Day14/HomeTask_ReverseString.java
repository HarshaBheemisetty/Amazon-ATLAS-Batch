package Day14;
public class HomeTask_ReverseString {

    // Recursive function to reverse a string
    public static String reverse(String str) {
        // Base case: if the string is empty or has 1 character
        if (str.isEmpty()) {
            return str;
        }
        // Recursive case: reverse the rest of the string and add the first character at the end
        return reverse(str.substring(1)) + str.charAt(0);
    }

    public static void main(String[] args) {
        String original = "hello";
        String reversed = reverse(original);

        System.out.println("Original string: " + original);
        System.out.println("Reversed string: " + reversed);
    }
}
