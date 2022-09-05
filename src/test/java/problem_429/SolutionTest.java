package problem_429;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void levelOrder_1() {
        Solution.Node root = new Solution.Node(
                1,
                List.of(
                        new Solution.Node(
                        3,
                        List.of(new Solution.Node(5, null),
                                new Solution.Node(6, null))
                        ),
                        new Solution.Node(
                                2,
                                null),
                        new Solution.Node(
                                4,
                                null)
                        )
                );
        List<List<Integer>> result = new Solution().levelOrder(root);
        // [[1],[3,2,4],[5,6]]
        List<List<Integer>> expected =
                List.of(
                        List.of(1),
                        List.of(3, 2, 4),
                        List.of(5, 6)
                );
        assertEquals(expected, result);
    }
}