import java.util.*;
public class Day11_TASK14 {
    public static void main(String[] args) {
        List<String> fullNames = Arrays.asList(
                "Arun Ramaji",
                "Harsha Bheemisetty",
                "Anusha Bheemisetty",
                "Neelima Ramaji",
                "Lavany Ramaji");

        fullNames.stream()
                .filter(name -> name.startsWith("H"))
                .map(String::toUpperCase)
                .sorted()
                .forEach(System.out::println);
    }
}
