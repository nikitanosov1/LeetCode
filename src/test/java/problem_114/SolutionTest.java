package problem_114;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void flatten() {
        Solution.TreeNode root = new Solution.TreeNode(1,
                new Solution.TreeNode(2, new Solution.TreeNode(3), new Solution.TreeNode(4)),
                new Solution.TreeNode(5, null, new Solution.TreeNode(6)));

        Solution.TreeNode result = new Solution.TreeNode(1, null,
                new Solution.TreeNode(2, null,
                        new Solution.TreeNode(3, null,
                                new Solution.TreeNode(4, null,
                                        new Solution.TreeNode(5, null,
                                                new Solution.TreeNode(6))))));
        new Solution().flatten(root);
        assertEquals(root, result);
    }

    @Test
    void flatten_2() {
        Solution.TreeNode root = new Solution.TreeNode();

        Solution.TreeNode result = new Solution.TreeNode();
        new Solution().flatten(root);
        assertEquals(root, result);
    }

    @Test
    void flatten_3() {
        Solution.TreeNode root = new Solution.TreeNode(0);

        Solution.TreeNode result = new Solution.TreeNode(0);
        new Solution().flatten(root);
        assertEquals(root, result);
    }
}