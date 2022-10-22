package problem_76;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void minWindow_1() {
        String s = "ADOBECODEBANC";
        String t = "ABC";
        String expected = "BANC";
        assertEquals(expected, new Solution().minWindow(s, t));
    }

    @Test
    void minWindow_2() {
        String s = "a";
        String t = "a";
        String expected = "a";
        assertEquals(expected, new Solution().minWindow(s, t));
    }

    @Test
    void minWindow_3() {
        String s = "a";
        String t = "aa";
        String expected = "";
        assertEquals(expected, new Solution().minWindow(s, t));
    }

    @Test
    void minWindow_4() {
        String s = "ab";
        String t = "b";
        String expected = "b";
        assertEquals(expected, new Solution().minWindow(s, t));
    }
}