import org.junit.jupiter.api.Test;
import static org.hamcrest.MatcherAssert.assertThat;//Object Matcher:
import static org.hamcrest.Matchers.hasToString;
// we  are given a bean ... string correctness
class Day36_DemoTest2Hamcrest {
    @Test
    public void method1() {
        Day36_Customer customer = new Day36_Customer("John", "Abraham");
        String str = customer.toString();
        assertThat(customer, hasToString(str));
    }
}


