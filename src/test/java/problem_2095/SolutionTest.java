package problem_2095;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void deleteMiddle_1() {
        Solution.ListNode head =
                new Solution.ListNode(2,
                        new Solution.ListNode(1));

        Solution.ListNode expected = new Solution.ListNode(2);
        assertEquals(expected, new Solution().deleteMiddle(head));
    }
}