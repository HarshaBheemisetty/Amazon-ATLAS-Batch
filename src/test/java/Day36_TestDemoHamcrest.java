import org.junit.jupiter.api.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class Day36_TestDemoHamcrest {
    @Test
    public void hamcrestMethod() {
        String str1 = "Apple";
        String str2 = "Apple";
        assertThat(str1 ,equalToIgnoringCase(str2));
    }
}
