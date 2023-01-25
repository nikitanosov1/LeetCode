package problem_2359;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void closestMeetingNode_1() {
        int[] edges = new int[]{4,4,8,-1,9,8,4,4,1,1};
        int node1 = 5;
        int node2 = 6;
        int expected = 1;
        assertEquals(expected, new Solution().closestMeetingNode(edges, node1, node2));
    }
}