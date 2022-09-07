package problem_606;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void tree2str_1() {
        Solution.TreeNode root =
                new Solution.TreeNode(1,
                        new Solution.TreeNode(2,
                                new Solution.TreeNode(4,
                                        null,
                                        null),
                                null),
                        new Solution.TreeNode(3));
        String expected = "1(2(4))(3)";
        assertEquals(expected, new Solution().tree2str(root));
    }

    @Test
    void tree2str_2() {
        Solution.TreeNode root =
                new Solution.TreeNode(1,
                        new Solution.TreeNode(2,
                                null,
                                new Solution.TreeNode(4,
                                        null,
                                        null)),
                        new Solution.TreeNode(3));
        String expected = "1(2()(4))(3)";
        assertEquals(expected, new Solution().tree2str(root));
    }
}