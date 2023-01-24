package problem_909;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void snakesAndLadders_1() {
        int[][] board = new int[][]{
                {-1,-1,-1,-1,-1,-1},
                {-1,-1,-1,-1,-1,-1},
                {-1,-1,-1,-1,-1,-1},
                {-1,35,-1,-1,13,-1},
                {-1,-1,-1,-1,-1,-1},
                {-1,15,-1,-1,-1,-1}};
        int expected = 4;
        assertEquals(expected, new Solution().snakesAndLadders(board));
    }

    @Test
    void snakesAndLadders_2() {
        int[][] board = new int[][]{
                {-1,-1},
                {-1,3}};
        int expected = 1;
        assertEquals(expected, new Solution().snakesAndLadders(board));
    }

    @Test
    void snakesAndLadders_3() {
        int[][] board = new int[][]{
                {-1,4,-1},
                {6,2,6},
                {-1,3,-1}};
        int expected = 2;
        assertEquals(expected, new Solution().snakesAndLadders(board));
    }

    @Test
    void snakesAndLadders_4() {
        int[][] board = new int[][]{
                {-1,1,2,-1},
                {2,13,15,-1},
                {-1,10,-1,-1},
                {-1,6,2,8}};
        int expected = 2;
        assertEquals(expected, new Solution().snakesAndLadders(board));
    }

    @Test
    void snakesAndLadders_5() {
        int[][] board = new int[][]{
                {-1,9,8},
                {5,6,7},
                {-1,3,4}};
        int expected = 2;
        assertEquals(expected, new Solution().snakesAndLadders(board));
    }

}