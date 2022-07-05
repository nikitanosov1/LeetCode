package problem_13;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void example_1() {
        assertEquals(new Solution().romanToInt("III"), 3);
    }

    @Test
    void example_2() {
        assertEquals(new Solution().romanToInt("LVIII"), 58);
    }

    @Test
    void example_3() {
        assertEquals(new Solution().romanToInt("MCMXCIV"), 1994);
    }
}