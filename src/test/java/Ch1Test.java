import ch1.Ch1;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Ch1Test {

    @Test
    public void q1_test(){
        assertEquals(Ch1.q1("abc"), true);
        assertEquals(Ch1.q1("abca"), false);
        assertEquals(Ch1.q1("abcaabcaabcaabcaabcaabcaabcaabcaabcaabca"), false);
    }

    @Test
    public void q2_test() {
        assertEquals(Ch1.q2("", ""), true);
        assertEquals(Ch1.q2("ab", "ba"), true);
        assertEquals(Ch1.q2("acd", "dca"), true);
        assertEquals(Ch1.q2("acd", "dcaq"), false);
        assertEquals(Ch1.q2("ad", "dc"), false);
    }

    @Test
    public void q3_test() {
        assertEquals(Ch1.q3("a c"), "a%20c");
    }

    @Test
    public void q3_2_test() {
        Assertions.assertArrayEquals( new Character[]{'%', '2', '0', '/', '0'}, Ch1.q3_2(new Character[]{' ', ' ', ' ', ' ', ' '}, 1));
        Assertions.assertArrayEquals( new Character[]{'a', '/', '0'}, Ch1.q3_2(new Character[]{'a', ' ', ' '}, 1));
    }

    @Test
    public void q4_test() {
        assertEquals(Ch1.q4("aca"), true);
        assertEquals(Ch1.q4("acd"), false);
        assertEquals(Ch1.q4("aab"), true);
    }

    @Test
    public void q5_test() {
        assertEquals(true, Ch1.q5("yara", "yaras"));
        assertEquals(false, Ch1.q5("yara", "yarass"));
        assertEquals(true, Ch1.q5("yara", "ara"));
        assertEquals(true, Ch1.q5("yara", "yra"));
    }

    @Test
    public void q6_test() {
        assertEquals("aabbc", Ch1.q6( "aabbc"));
        assertEquals("a", Ch1.q6( "a"));
        assertEquals("", Ch1.q6( ""));
        assertEquals("a4", Ch1.q6( "aaaa"));
    }

    @Test
    public void q7_test() {
        assertArrayEquals(new int[][]{{1, 4, 7}, {2, 5, 8}, {3, 6, 9}}, Ch1.q7( new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8,9}}, 3));

    }
}
