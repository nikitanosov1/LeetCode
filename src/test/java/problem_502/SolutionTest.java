package problem_502;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void findMaximizedCapital_1() {
        int k = 2;
        int w = 0;
        int[] profits = new int[]{1, 2, 3};
        int[] capital = new int[]{0, 1, 1};
        int expected = 4;
        assertEquals(expected, new Solution().findMaximizedCapital(k, w, profits, capital));
    }

    @Test
    void findMaximizedCapital_2() {
        int k = 3;
        int w = 0;
        int[] profits = new int[]{1, 2, 3};
        int[] capital = new int[]{0, 1, 2};
        int expected = 6;
        assertEquals(expected, new Solution().findMaximizedCapital(k, w, profits, capital));
    }

    @Test
    void findMaximizedCapital_3() {
        int k = 3;
        int w = 0;
        int[] profits = new int[]{1, 2, 1000000};
        int[] capital = new int[]{0, 1, 100};
        int expected = 3;
        assertEquals(expected, new Solution().findMaximizedCapital(k, w, profits, capital));
    }
}