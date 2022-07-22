package problem_85;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void maximalRectangle_1() {
        char[][] matrix = new char[][]{
                {'1','0','1','0','0'},
                {'1','0','1','1','1'},
                {'1','1','1','1','1'},
                {'1','0','0','1','0'}};
        int result = 6;
        assertEquals(new Solution().maximalRectangle(matrix), result);
    }

    @Test
    void maximalRectangle_2() {
        char[][] matrix = new char[][]{
                {'1','1','1','1','0'},
                {'1','1','1','1','1'},
                {'1','1','1','1','0'},
                {'1','1','1','1','1'}};
        int result = 16;
        assertEquals(new Solution().maximalRectangle(matrix), result);
    }

    @Test
    void maximalRectangle_3() {
        char[][] matrix = new char[][]{{'0'}};
        int result = 0;
        assertEquals(new Solution().maximalRectangle(matrix), result);
    }

    @Test
    void maximalRectangle_4() {
        char[][] matrix = new char[][]{{'1'}};
        int result = 1;
        assertEquals(new Solution().maximalRectangle(matrix), result);
    }

    @Test
    void maximalRectangle_5() {
        char[][] matrix = new char[][]{
                {'1','0','0','0','1'},
                {'1','1','0','1','1'},
                {'1','1','1','1','1'}};
        int result = 5;
        assertEquals(new Solution().maximalRectangle(matrix), result);
    }

    @Test
    void maximalSquareInRow() {
        int[] row = new int[]{1, 2, 3, 0, 5, 2, 4};
        new Solution().maximalSquareInRow(row);
    }
}