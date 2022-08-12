package problem_235;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    void lowestCommonAncestor_1() {
        Solution.TreeNode root =
                new Solution.TreeNode(6,
                        new Solution.TreeNode(2,
                                new Solution.TreeNode(0,null,null),
                                new Solution.TreeNode(4,
                                        new Solution.TreeNode(3,null,null),
                                        new Solution.TreeNode(5,null,null))),
                        new Solution.TreeNode(8,
                                new Solution.TreeNode(7, null, null),
                                new Solution.TreeNode(9, null, null)));
        assertEquals(root, new Solution().lowestCommonAncestor(root,
                root.left, root.right));
    }

    @Test
    void lowestCommonAncestor_2() {
        Solution.TreeNode root =
                new Solution.TreeNode(6,
                        new Solution.TreeNode(2,
                                new Solution.TreeNode(0,null,null),
                                new Solution.TreeNode(4,
                                        new Solution.TreeNode(3,null,null),
                                        new Solution.TreeNode(5,null,null))),
                        new Solution.TreeNode(8,
                                new Solution.TreeNode(7, null, null),
                                new Solution.TreeNode(9, null, null)));
        assertEquals(root.left, new Solution().lowestCommonAncestor(root,
                root.left, root.left.right));
    }
}