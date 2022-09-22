package problem_557;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void reverseWords_1() {
        String input = "Let's take LeetCode contest";
        String expected = "s'teL ekat edoCteeL tsetnoc";
        assertEquals(expected, new Solution().reverseWords(input));
    }

    @Test
    void reverseWords_2() {
        String input = "God Ding";
        String expected = "doG gniD";
        assertEquals(expected, new Solution().reverseWords(input));
    }
}