import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class Day23_HomeTaskTask2 {

    @Test
    public void testCompare_FirstGreater() {
        Day23_HomeTask2 obj = new Day23_HomeTask2();
        int result = obj.compare(10, 5);
        assertEquals(1, result); // 10 > 5
    }

    @Test
    public void testCompare_SecondGreater() {
        Day23_HomeTask2 obj = new Day23_HomeTask2();
        int result = obj.compare(3, 8);
        assertEquals(-1, result); // 3 < 8
    }

    @Test
    public void testCompare_BothEqual() {
        Day23_HomeTask2 obj = new Day23_HomeTask2();
        int result = obj.compare(6, 6);
        assertEquals(-1, result); // 6 == 6, but logic returns -1
    }
}
