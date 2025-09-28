import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Day23_IncludeExcludeTags {

    @Test
    @Tag("firstPriority")
    void testMethod01() {
        assertEquals(2, 1 + 1);
    }

    @Test
    @Tag("firstPriority")
    void runTestcase02() {
        assertEquals(5, 2 + 3);
    }

    @Test
    @Tag("fastTag")
    void testMethod03() {
        assertEquals("Hello", "Hel" + "lo");
    }

    @Test
    @Tag("slowTag")
    void runTestcase04() {
        assertEquals(9, 3 * 3);
    }
}
