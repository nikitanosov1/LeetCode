package problem_814;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void pruneTree_1() {
        Solution.TreeNode root =
                new Solution.TreeNode(1,
                        null,
                        new Solution.TreeNode(0,
                                new Solution.TreeNode(0),
                                new Solution.TreeNode(1)));
        Solution.TreeNode expected =
                new Solution.TreeNode(1,
                        null,
                        new Solution.TreeNode(0,
                                null,
                                new Solution.TreeNode(1)));
        new Solution().pruneTree(root);
        assertEquals(expected, root);
    }

    @Test
    void pruneTree_2() {
        Solution.TreeNode root =
                new Solution.TreeNode(1,
                        new Solution.TreeNode(0,
                                new Solution.TreeNode(0),
                                new Solution.TreeNode(0)),
                        new Solution.TreeNode(1,
                                new Solution.TreeNode(0),
                                new Solution.TreeNode(1)));
        Solution.TreeNode expected =
                new Solution.TreeNode(1,
                        null,
                        new Solution.TreeNode(1,
                                null,
                                new Solution.TreeNode(1)));
        new Solution().pruneTree(root);
        assertEquals(expected, root);
    }

    @Test
    void pruneTree_3() {
        Solution.TreeNode root =
                new Solution.TreeNode(1,
                        new Solution.TreeNode(1,
                                new Solution.TreeNode(1,
                                        new Solution.TreeNode(0),
                                        null),
                                new Solution.TreeNode(1)),
                        new Solution.TreeNode(0,
                                new Solution.TreeNode(0),
                                new Solution.TreeNode(1)));
        Solution.TreeNode expected =
                new Solution.TreeNode(1,
                        new Solution.TreeNode(1,
                                new Solution.TreeNode(1),
                                new Solution.TreeNode(1)),
                        new Solution.TreeNode(0,
                                null,
                                new Solution.TreeNode(1)));
        new Solution().pruneTree(root);
        assertEquals(expected, root);
    }

    @Test
    void pruneTree_4() {
        Solution.TreeNode root =
                new Solution.TreeNode(0,
                        null,
                        new Solution.TreeNode(0,
                                new Solution.TreeNode(0),
                                new Solution.TreeNode(0)));
        Solution.TreeNode result = new Solution().pruneTree(root);
        assertNull(result);
    }
}