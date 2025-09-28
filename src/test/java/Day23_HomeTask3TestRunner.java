import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class Day23_HomeTask3TestRunner {
    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(Day23_HomeTask3TestSuite.class);

        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }

        System.out.println("All tests successful? " + result.wasSuccessful());
    }
}


