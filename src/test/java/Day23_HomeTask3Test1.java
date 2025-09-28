import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class Day23_HomeTask3Test1
{
    String msg = "Hi Everyone";
    Day23_HomeTask3 obj = new Day23_HomeTask3(msg);
    @Test
    public void msgTest()
    {
        System.out.println("Message Inside msg.Test");
        assertEquals(msg, obj.Printmsg());

    }
}
