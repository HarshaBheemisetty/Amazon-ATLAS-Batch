import java.util.stream.Stream;
public class Day11_TASK18 {
    public static void main(String[] args) {
        Stream<Integer> numbers = Stream.iterate(1, n -> n + 1).limit(20);

        numbers.limit(10).forEach(System.out::println);
    }
}
