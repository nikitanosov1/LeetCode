package problem_14;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void longestCommonPrefix_1() {
        String[] input = new String[]{"flower","flow","flight"};
        String output = "fl";
        assertEquals(new Solution().longestCommonPrefix(input), output);
    }

    @Test
    void longestCommonPrefix_2() {
        String[] input = new String[]{"dog","racecar","car"};
        String output = "";
        assertEquals(new Solution().longestCommonPrefix(input), output);
    }

    @Test
    void longestCommonPrefix_3() {
        String[] input = new String[]{"flower","flower","flower"};
        String output = "flower";
        assertEquals(new Solution().longestCommonPrefix(input), output);
    }

    @Test
    void longestCommonPrefix_4() {
        String[] input = new String[]{"flower","flow","flower"};
        String output = "flow";
        assertEquals(new Solution().longestCommonPrefix(input), output);
    }

}