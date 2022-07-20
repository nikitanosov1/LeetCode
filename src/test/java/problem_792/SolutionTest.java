package problem_792;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void numMatchingSubseq_1() {
        String s = "abcde";
        String[] words = new String[]{"a","bb","acd","ace"};
        assertEquals(new Solution().numMatchingSubseq(s, words), 3);
    }

    @Test
    void numMatchingSubseq_2() {
        String s = "dsahjpjauf";
        String[] words = new String[]{"ahjpjau","ja","ahbwzgqnuk","tnmlanowax"};
        assertEquals(new Solution().numMatchingSubseq(s, words), 2);
    }

    @Test
    void numMatchingSubseq_3() {
        String s = "a";
        String[] words = new String[]{"ab","a","b"};
        assertEquals(new Solution().numMatchingSubseq(s, words), 1);
    }
}