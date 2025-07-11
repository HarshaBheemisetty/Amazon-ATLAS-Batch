import java.util.function.Function;

public class Day11_TASK10 {
    public static void main(String[] args) {
        String input = "Lambda";

        // Lambda expression to reverse a string using StringBuilder
        Function<String, String> reverse = str -> new StringBuilder(str).reverse().toString();

        String result = reverse.apply(input);

        System.out.println("Original: " + input);
        System.out.println("Reversed: " + result);
    }
}
