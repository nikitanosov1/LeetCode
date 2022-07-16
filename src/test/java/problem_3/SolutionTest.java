package problem_3;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @ParameterizedTest(name = "{index} - {0} answer need to be {1}")
    @CsvSource(value = {
            "abcabcbb, 3",
            "bbbbb, 1",
            "pwwkew, 3",
            "dvdf, 3",
            "abba, 2"
    })
    void allExamplesFromLeetCode(String input, int result) {
        assertEquals(new Solution().lengthOfLongestSubstring(input),
                result);
    }
}