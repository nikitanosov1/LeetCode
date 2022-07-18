package problem_7;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @ParameterizedTest(name = "{index} - {0} need to be {1}")
    @CsvSource(value = {
            "123, 321",
            "-123, -321",
            "120, 21",
            "2147483647, 0"
    })
    void reverse(int input, int result) {
        assertEquals(new Solution().reverse(input), result);
    }
}