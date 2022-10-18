package problem_38;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @ParameterizedTest
    @CsvSource(value = {
            "4, 1211",
            "1, 1"
    })
    void countAndSay(int n, String expected) {
        assertEquals(expected, new Solution().countAndSay(n));
    }
}