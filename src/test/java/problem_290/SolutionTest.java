package problem_290;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void wordPattern_1() {
        String pattern = "abba";
        String s = "dog cat cat dog";
        boolean expected = true;
        assertEquals(expected, new Solution().wordPattern(pattern, s));
    }

    @Test
    void wordPattern_2() {
        String pattern = "abba";
        String s = "dog cat cat fish";
        boolean expected = false;
        assertEquals(expected, new Solution().wordPattern(pattern, s));
    }

    @Test
    void wordPattern_3() {
        String pattern = "aaaa";
        String s = "dog cat cat dog";
        boolean expected = false;
        assertEquals(expected, new Solution().wordPattern(pattern, s));
    }

    @Test
    void wordPattern_4() {
        String pattern = "abba";
        String s = "dog dog dog dog";
        boolean expected = false;
        assertEquals(expected, new Solution().wordPattern(pattern, s));
    }

    @Test
    void wordPattern_5() {
        String pattern = "ab";
        String s = "dog dog";
        boolean expected = false;
        assertEquals(expected, new Solution().wordPattern(pattern, s));
    }
}