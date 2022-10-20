package problem_12;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void intToRoman_1() {
        int num = 58;
        String expected = "LVIII";
        assertEquals(expected, new Solution().intToRoman(num));
    }
}