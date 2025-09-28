import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JavaTestCase01 {

    @Test
    public void add() {
        int num1 = 10;
        int num2 = 20;
        int sum = num1 + num2;
        assertEquals(30, sum);//test case passed
        assertEquals(31, sum);//test case failed

    }
}
