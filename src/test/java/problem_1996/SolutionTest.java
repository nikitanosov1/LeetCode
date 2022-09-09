package problem_1996;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void numberOfWeakCharacters_1() {
        // [[5,5],[6,3],[3,6]]
        int[][] properties = new int[][]{
                {5, 5},
                {6, 3},
                {3, 6}
        };
        int expected = 0;
        assertEquals(expected, new Solution().numberOfWeakCharacters(properties));
    }

    @Test
    void numberOfWeakCharacters_2() {
        // [[2,2],[3,3]]
        int[][] properties = new int[][]{
                {2, 2},
                {3, 3}
        };
        int expected = 1;
        assertEquals(expected, new Solution().numberOfWeakCharacters(properties));
    }

    @Test
    void numberOfWeakCharacters_3() {
        // [[1,5],[10,4],[4,3]]
        int[][] properties = new int[][]{
                {1, 5},
                {10, 4},
                {4, 3}
        };
        int expected = 1;
        assertEquals(expected, new Solution().numberOfWeakCharacters(properties));
    }

    @Test
    void numberOfWeakCharacters_4() {
        // [[1,1],[2,1],[2,2],[1,2]]
        int[][] properties = new int[][]{
                {1, 1},
                {2, 1},
                {2, 2},
                {1, 2}
        };
        int expected = 1;
        assertEquals(expected, new Solution().numberOfWeakCharacters(properties));
    }
}