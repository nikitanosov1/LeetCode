package problem_91;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @ParameterizedTest
    @CsvSource(value = {
            "'12', 2",
            "'226', 3",
            "'06', 0"
    })
    void numDecodings(String input, int expected) {
        assertEquals(expected, new Solution().numDecodings(input));
    }
}