import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;//collection Matcher

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasSize;
public class Day36_DemoTest5Hamcrest {
    @Test
    public void method2() {
        List<String> custList = Arrays.asList("john", "Mary", "Sheik", "Singh");
        assertThat(custList, hasSize(4));
    }
}

