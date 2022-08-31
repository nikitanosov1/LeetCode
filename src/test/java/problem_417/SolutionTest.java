package problem_417;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void pacificAtlantic_1() {
        int[][] heights = new int[][]{
                {1, 2, 2, 3, 5},
                {3, 2, 3, 4, 4},
                {2, 4, 5, 3, 1},
                {6, 7, 1, 4, 5},
                {5, 1, 1, 2, 4}
        };
        List<List<Integer>> expected = new LinkedList<>();
        expected.add(List.of(0, 4));
        expected.add(List.of(1, 3));
        expected.add(List.of(1, 4));
        expected.add(List.of(2, 2));
        expected.add(List.of(3, 0));
        expected.add(List.of(3, 1));
        expected.add(List.of(4, 0));

        assertEquals(expected, new Solution().pacificAtlantic(heights));
    }

    @Test
    void pacificAtlantic_2() {
        int[][] heights = new int[][]{
                {1}
        };
        List<List<Integer>> expected = new LinkedList<>();
        expected.add(List.of(0, 0));

        assertEquals(expected, new Solution().pacificAtlantic(heights));
    }
}