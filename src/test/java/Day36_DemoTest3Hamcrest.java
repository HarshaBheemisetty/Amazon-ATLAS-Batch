import org.junit.jupiter.api.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class Day36_DemoTest3Hamcrest {

    @Test
    void method01() {
        Day36_Customer customer = new Day36_Customer("john", "Abraham");

        // Check property existence
        assertThat(customer, hasProperty("fname"));
        assertThat(customer, hasProperty("lname"));

    }
}
