package problem_128;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void example_1() {
        assertEquals(new Solution().longestConsecutive(new int[]{100,4,200,1,3,2}),
                4);
    }

    @Test
    void example_2() {
        assertEquals(new Solution().longestConsecutive(new int[]{0,3,7,2,5,8,4,6,0,1}),
                9);
    }
}