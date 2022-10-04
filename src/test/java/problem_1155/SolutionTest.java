package problem_1155;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void numRollsToTarget_1() {
        int n = 1;
        int k = 6;
        int target = 3;
        int expected = 1;
        assertEquals(expected, new Solution().numRollsToTarget(n, k, target));
    }

    @Test
    void numRollsToTarget_2() {
        int n = 2;
        int k = 6;
        int target = 7;
        int expected = 6;
        assertEquals(expected, new Solution().numRollsToTarget(n, k, target));
    }

    @Test
    void numRollsToTarget_3() {
        int n = 30;
        int k = 30;
        int target = 500;
        int expected = 222616187;
        assertEquals(expected, new Solution().numRollsToTarget(n, k, target));
    }
}