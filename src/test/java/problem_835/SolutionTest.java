package problem_835;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void largestOverlap_2() {
        int[][] img1 = new int[][]{{1}};
        int[][] img2 = new int[][]{{1}};

        int expected = 1;
        assertEquals(expected, new Solution().largestOverlap(img1, img2));
    }

    @Test
    void largestOverlap_3() {
        int[][] img1 = new int[][]{{0}};
        int[][] img2 = new int[][]{{0}};

        int expected = 0;
        assertEquals(expected, new Solution().largestOverlap(img1, img2));
    }
}