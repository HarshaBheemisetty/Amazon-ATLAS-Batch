import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class Day23_HomeTask3Test3 {

    String msg = "running test03";
    Day23_HomeTask3 Obj2 = new Day23_HomeTask3(msg);

    @Test
    public void msgTest() {
        System.out.println("Inside JunitTest03.msgTest()");
        assertEquals(msg, Obj2.Printmsg());
    }
}

