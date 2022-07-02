package problem_1465;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void example_1() {
        assertEquals(new Solution().maxArea(5,4, new int[]{1, 2, 4}, new int[]{1,3}), 4);
    }

    @Test
    void example_2() {
        assertEquals(new Solution().maxArea(5,4, new int[]{3,1}, new int[]{1}), 6);
    }

    @Test
    void example_3() {
        assertEquals(new Solution().maxArea(5,4, new int[]{3}, new int[]{3}), 9);
    }

    @Test
    void WA_1() {
        assertEquals(new Solution().maxArea(8,5, new int[]{5,2,6,3}, new int[]{1,4}), 6);
    }

    /*
    1000000000
    1000000000
    [2]
    [2]
     */
    @Test
    void WA_2() {
        assertEquals(new Solution().maxArea(1000000000,1000000000,
                new int[]{2}, new int[]{2}), 81);
    }
}