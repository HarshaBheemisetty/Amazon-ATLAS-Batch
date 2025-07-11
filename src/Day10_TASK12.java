import java.util.stream.*;
import java.util.stream.Stream;
class Day10_TASK12 {
    public static void main(String[] args) {
        Stream<String> stream = Stream.of("Heelo", "My", "name", "is", "Prasunamba", ".MK");

        stream.forEach(System.out::println);
    }
}
