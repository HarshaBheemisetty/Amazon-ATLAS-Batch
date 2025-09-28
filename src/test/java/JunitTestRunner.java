import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class JunitTestRunner
{
    public static void main(String[] args)
    {
        Result resObj = JUnitCore.runClasses(JavaTestCase01.class);

        for(Failure failure : resObj.getFailures())
        {
            System.out.println(failure.toString());
        }
        System.out.println(resObj.wasSuccessful());
    }
}
