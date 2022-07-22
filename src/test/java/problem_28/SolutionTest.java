package problem_28;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @ParameterizedTest
    @CsvSource(value = {
            "hello, ll, 2",
            "aaaaa, bba, -1",
            "privet, ve, 3"
    })
    void strStr(String haystack, String needle, int result) {
        assertEquals(new Solution().strStr(haystack, needle), result);
    }
}