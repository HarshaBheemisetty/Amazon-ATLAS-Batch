import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class JunitTestCase02
{
    protected int val1, val2;

    @Before
    public void setUp()
    {
        val1=100;
        val2=200;
    }
    @Test
    public void testSum()
    {
        int sum1 = val1+val2;
        assertTrue(sum1==300);
    }


}
