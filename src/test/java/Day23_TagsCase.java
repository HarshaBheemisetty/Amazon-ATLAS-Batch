import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import static org.junit.jupiter.api.Assertions.assertEquals;

class Day23_TagsCase {

    @Test
    @Tag("firstPriority")
    void testMethod01() {
        assertEquals(2, 1 + 1); // example test
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
