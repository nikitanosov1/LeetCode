package problem_787;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void findCheapestPrice_1() {
        int n = 5;
        int[][] flights = new int[][] {{0,1,5},{1,2,5},{0,3,2},{3,1,2},{1,4,1},{4,2,1}};
        int src = 0;
        int dst = 2;
        int k = 2;

        int expected = 7;
        assertEquals(expected, new Solution().findCheapestPrice(n, flights, src, dst, k));
    }
}