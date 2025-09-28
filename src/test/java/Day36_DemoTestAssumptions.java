import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.Test;
public class Day36_DemoTestAssumptions {
    @Test
    void Testcase1() {
        boolean condition = "true".equalsIgnoreCase(System.getProperty("runTest"));
        Assumptions.assumeTrue(condition, "as the condition is not met skip test case");
        int result = testcase2();
        Assertions.assertEquals(10, result, "value need to be 10");
    }
    private int testcase2() {
        return 10;
    }
}
