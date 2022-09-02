package problem_637;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void averageOfLevels_1() {
        Solution.TreeNode root =
                new Solution.TreeNode(3,
                        new Solution.TreeNode(9,
                                null,
                                null),
                        new Solution.TreeNode(20,
                                new Solution.TreeNode(15,
                                        null,
                                        null),
                                new Solution.TreeNode(7,
                                        null,
                                        null)));
        List<Double> expected = List.of(3.00000,14.50000,11.00000);
        assertEquals(expected, new Solution().averageOfLevels(root));
    }
}