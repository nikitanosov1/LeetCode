package problem_98;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    void isValidBST_1() {
        Solution.TreeNode treeNode = new Solution.TreeNode(2,
                new Solution.TreeNode(1, null, null),
                new Solution.TreeNode(3, null, null));

        boolean expectedResult = true;
        assertEquals(expectedResult, new Solution().isValidBST(treeNode));
    }

    @Test
    void isValidBST_2() {
        Solution.TreeNode treeNode = new Solution.TreeNode(5,
                new Solution.TreeNode(1, null, null),
                new Solution.TreeNode(4,
                        new Solution.TreeNode(3, null, null),
                        new Solution.TreeNode(6, null, null)));

        boolean expectedResult = false;
        assertEquals(expectedResult, new Solution().isValidBST(treeNode));
    }

    @Test
    void isValidBST_3() {
        Solution.TreeNode treeNode = new Solution.TreeNode(5,
                new Solution.TreeNode(4, null, null),
                new Solution.TreeNode(6,
                        new Solution.TreeNode(3, null, null),
                        new Solution.TreeNode(7, null, null)));

        boolean expectedResult = false;
        assertEquals(expectedResult, new Solution().isValidBST(treeNode));
    }

    @Test
    void isValidBST_4() {
        Solution.TreeNode treeNode = new Solution.TreeNode(2147483647, null, null);

        boolean expectedResult = true;
        assertEquals(expectedResult, new Solution().isValidBST(treeNode));
    }

}