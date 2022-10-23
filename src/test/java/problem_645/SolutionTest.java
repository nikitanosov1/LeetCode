package problem_645;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void findErrorNums_1() {
        int[] nums = new int[]{1,2,2,4};
        int[] expected = new int[]{2,3};
        assertEquals(expected, new Solution().findErrorNums(nums));
    }

    @Test
    void findErrorNums_2() {
        int[] nums = new int[]{1,1};
        int[] expected = new int[]{1,2};
        assertEquals(expected, new Solution().findErrorNums(nums));
    }
}