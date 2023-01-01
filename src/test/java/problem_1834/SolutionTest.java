package problem_1834;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void getOrder_1() {
        int[][] input = new int[][] {{1, 2}, {2, 4}, {3, 2}, {4, 1}};
        int[] expected = new int[] {0, 2, 3, 1};
        assertArrayEquals(expected, new Solution().getOrder(input));
    }

    @Test
    void getOrder_2() {
        int[][] input = new int[][] {{7, 10}, {7, 12}, {7, 5}, {7, 4}, {7, 2}};
        int[] expected = new int[] {4, 3, 2, 0, 1};
        assertArrayEquals(expected, new Solution().getOrder(input));
    }

    @Test
    void getOrder_3() {
        int[][] input = new int[][] {{19,13},{16,9},{21,10},{32,25},{37,4},{49,24},{2,15},{38,41},{37,34},{33,6},{45,4},{18,18},{46,39},{12,24}};
        int[] expected = new int[] {6,1,2,9,4,10,0,11,5,13,3,8,12,7};
        assertArrayEquals(expected, new Solution().getOrder(input));
    }

    @Test
    void getOrder_4() {
        int[][] input = new int[][] {{1, 1}, {2, 1}, {3, 1}};
        int[] expected = new int[] {0, 1, 2};
        assertArrayEquals(expected, new Solution().getOrder(input));
    }
}