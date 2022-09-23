package problem_1754;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void largestMerge_1() {
        String word1 = "cabaa";
        String word2 = "bcaaa";
        String expected = "cbcabaaaaa";
        assertEquals(expected, new Solution().largestMerge(word1, word2));
    }

    @Test
    void largestMerge_2() {
        String word1 = "abcabc";
        String word2 = "abdcaba";
        String expected = "abdcabcabcaba";
        assertEquals(expected, new Solution().largestMerge(word1, word2));
    }
}