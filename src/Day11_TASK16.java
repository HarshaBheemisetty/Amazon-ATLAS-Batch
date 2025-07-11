import java.util.*;
import java.util.stream.Collectors;
public class Day11_TASK16 {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(11, 22, 33, 44, 55, 77, 12, 13);

        List<Integer> oddNumbers = numbers.stream()
                .filter(num -> num % 2 != 0)
                .collect(Collectors.toList());

        System.out.println("Odd Numbers: " + oddNumbers);
    }
}
