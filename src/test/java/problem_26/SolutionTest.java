package problem_26;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void removeDuplicates_1() {
        int[] input = new int[]{1,1,2};
        int output = 2;
        assertEquals(new Solution().removeDuplicates(input), output);
    }

    @Test
    void removeDuplicates_2() {
        int[] input = new int[]{0,0,1,1,1,2,2,3,3,4};
        int output = 5;
        assertEquals(new Solution().removeDuplicates(input), output);
    }

    @Test
    void removeDuplicates_3() {
        int[] input = new int[]{0};
        int output = 1;
        assertEquals(new Solution().removeDuplicates(input), output);
    }
}