package problem_443;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void compress_1() {
        char[] chars = new char[]{'a','a','b','b','c','c','c'};
        int expected = 6;
        assertEquals(expected, new Solution().compress(chars));
    }

    @Test
    void compress_2() {
        char[] chars = new char[]{'a'};
        int expected = 1;
        assertEquals(expected, new Solution().compress(chars));
    }

    @Test
    void compress_3() {
        char[] chars = new char[]{'a','b','b','b','b','b','b','b','b','b','b','b','b'};
        int expected = 4;
        assertEquals(expected, new Solution().compress(chars));
    }
}