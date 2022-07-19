package problem_21;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void mergeTwoLists() {
        Solution.ListNode listNode1 =
                new Solution.ListNode(1,
                new Solution.ListNode(2,
                new Solution.ListNode(4)));
        Solution.ListNode listNode2 =
                new Solution.ListNode(1,
                new Solution.ListNode(3,
                new Solution.ListNode(4)));

        Solution.ListNode listNode3 =
                new Solution.ListNode(1,
                new Solution.ListNode(1,
                new Solution.ListNode(2,
                new Solution.ListNode(3,
                new Solution.ListNode(4,
                new Solution.ListNode(4))))));
        assertEquals(new Solution().mergeTwoLists(listNode1, listNode2), listNode3);
    }
}