import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class Day23_HomeTask3Test2 {

    String msg = "running test02";
    Day23_HomeTask3 Obj1 = new Day23_HomeTask3(msg);

    @Test
    public void msgTest() {
        System.out.println("Inside JunitTest02.msgTest()");
        assertEquals(msg, Obj1.Printmsg());
    }
}

