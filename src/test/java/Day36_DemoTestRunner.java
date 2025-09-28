import com.sun.net.httpserver.Authenticator;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;


//DemoTest001TestJunit.class
public class Day36_DemoTestRunner {
    public static void main(String[] args) {
        System.out.println("running a test runner code");
        Result res = JUnitCore.runClasses(Day36_Test001.class);


        for (Failure fail: res.getFailures()) {
            System.out.println(fail.toString());
        }
        System.out.println(res.wasSuccessful());
    }
}
