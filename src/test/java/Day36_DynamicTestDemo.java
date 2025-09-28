import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;
import java.util.Collection;
import java.util.stream.Stream;
import static java.util.stream.Collectors.toList;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.DynamicTest.dynamicTest;
public class Day36_DynamicTestDemo {
    @TestFactory
    Collection<DynamicTest> DynamicTestCase() {
        return TestCases().map(val ->
                dynamicTest("Dynamic Test:  " + val, () -> assertTrue(val % 2 == 0))
        ).toList();
    }
    private Stream<Integer> TestCases() {
        return Stream.of(100, 200, 300, 400, 5000);
    }
}
