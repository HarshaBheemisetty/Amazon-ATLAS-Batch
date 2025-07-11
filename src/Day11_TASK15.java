import java.util.*;
import java.util.stream.Collectors;
public class Day11_TASK15 {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(2, 4, 6, 8, 10);

        List<Integer> squares = numbers.stream()
                .map(num -> num * num)
                .collect(Collectors.toList());

        System.out.println("Squares: " + squares);
    }
}
