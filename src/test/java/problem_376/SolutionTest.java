package problem_376;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    @Test
    void example_1() {
        assertEquals(new Solution().wiggleMaxLength(new int[]{1,7,4,9,2,5}), 6);
    }

    @Test
    void example_2() {
        assertEquals(new Solution().wiggleMaxLength(new int[]{1,17,5,10,13,15,10,5,16,8}), 7);
    }

    @Test
    void example_3() {
        assertEquals(new Solution().wiggleMaxLength(new int[]{1,2,3,4,5,6,7,8,9}), 2);
    }

    @Test
    void WA_2() {
        assertEquals(new Solution().wiggleMaxLength(new int[]{0, 0}), 1);
    }
}