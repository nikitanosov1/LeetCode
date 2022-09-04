package problem_987;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void verticalTraversal_1() {
        Solution.TreeNode root =
                new Solution.TreeNode(3,
                        new Solution.TreeNode(9, null, null),
                        new Solution.TreeNode(20,
                                new Solution.TreeNode(15, null , null),
                                new Solution.TreeNode(7, null, null)));
        // [9],[3,15],[20],[7]
        List<List<Integer>> expected =
                List.of(
                        List.of(9),
                        List.of(3, 15),
                        List.of(20),
                        List.of(7)
                );
        assertEquals(expected, new Solution().verticalTraversal(root));
    }

    @Test
    void verticalTraversal_2() {
        Solution.TreeNode root =
                new Solution.TreeNode(1,
                        new Solution.TreeNode(2,
                                new Solution.TreeNode(4, null , null),
                                new Solution.TreeNode(5, null, null)),
                        new Solution.TreeNode(3,
                                new Solution.TreeNode(6, null , null),
                                new Solution.TreeNode(7, null, null)));
        // [[4],[2],[1,5,6],[3],[7]]
        List<List<Integer>> expected =
                List.of(
                        List.of(4),
                        List.of(2),
                        List.of(1, 5, 6),
                        List.of(3),
                        List.of(7)
                );
        assertEquals(expected, new Solution().verticalTraversal(root));
    }

    @Test
    void verticalTraversal_3() {
        Solution.TreeNode root =
                new Solution.TreeNode(1,
                        new Solution.TreeNode(2,
                                new Solution.TreeNode(4, null , null),
                                new Solution.TreeNode(6, null, null)),
                        new Solution.TreeNode(3,
                                new Solution.TreeNode(5, null , null),
                                new Solution.TreeNode(7, null, null)));
        // [[4],[2],[1,5,6],[3],[7]]
        List<List<Integer>> expected =
                List.of(
                        List.of(4),
                        List.of(2),
                        List.of(1, 5, 6),
                        List.of(3),
                        List.of(7)
                );
        assertEquals(expected, new Solution().verticalTraversal(root));
    }

    @Test
    void verticalTraversal_4() {
        Solution.TreeNode root =
                new Solution.TreeNode(3,
                        new Solution.TreeNode(1,
                                new Solution.TreeNode(0, null , null),
                                new Solution.TreeNode(2, null, null)),
                        new Solution.TreeNode(4,
                                new Solution.TreeNode(2, null , null),
                                null));
        // [[0],[1],[3,2,2],[4]]
        List<List<Integer>> expected =
                List.of(
                        List.of(0),
                        List.of(1),
                        List.of(3, 2, 2),
                        List.of(4)
                );
        assertEquals(expected, new Solution().verticalTraversal(root));
    }
}