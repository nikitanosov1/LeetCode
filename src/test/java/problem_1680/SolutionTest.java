package problem_1680;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void concatenatedBinary_1() {
        int input = 1;
        int expected = 1;
        assertEquals(expected, new Solution().concatenatedBinary(input));
    }

    @Test
    void concatenatedBinary_2() {
        int input = 3;
        int expected = 27;
        assertEquals(expected, new Solution().concatenatedBinary(input));
    }

    @Test
    void concatenatedBinary_3() {
        int input = 12;
        int expected = 505379714;
        assertEquals(expected, new Solution().concatenatedBinary(input));
    }
}