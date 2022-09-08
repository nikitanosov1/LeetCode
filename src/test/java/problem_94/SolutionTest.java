package problem_94;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void inorderTraversal_1() {
        Solution.TreeNode root =
                new Solution.TreeNode(1,
                        null,
                        new Solution.TreeNode(2,
                                new Solution.TreeNode(3),
                                null));
        List<Integer> expected = List.of(1, 3, 2);
        assertEquals(expected, new Solution().inorderTraversal(root));
    }

    @Test
    void inorderTraversal_2() {
        Solution.TreeNode root = null;
        List<Integer> expected = List.of();
        assertEquals(expected, new Solution().inorderTraversal(root));
    }

    @Test
    void inorderTraversal_3() {
        Solution.TreeNode root = new Solution.TreeNode(1);
        List<Integer> expected = List.of(1);
        assertEquals(expected, new Solution().inorderTraversal(root));
    }
}