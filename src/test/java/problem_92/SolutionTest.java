package problem_92;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void reverseBetween_1() {
        Solution.ListNode head =
                new Solution.ListNode(1,
                new Solution.ListNode(2,
                new Solution.ListNode(3,
                new Solution.ListNode(4,
                new Solution.ListNode(5)))));
        int left = 2;
        int right = 4;

        Solution.ListNode result =
                new Solution.ListNode(1,
                new Solution.ListNode(4,
                new Solution.ListNode(3,
                new Solution.ListNode(2,
                new Solution.ListNode(5)))));

        assertEquals(new Solution().reverseBetween(head, left, right), result);
    }

    @Test
    void reverseBetween_2() {
        Solution.ListNode head = new Solution.ListNode(5);
        int left = 1;
        int right = 1;

        Solution.ListNode result = new Solution.ListNode(5);

        assertEquals(new Solution().reverseBetween(head, left, right), result);
    }

    @Test
    void reverseBetween_3() {
        Solution.ListNode head =
                new Solution.ListNode(1,
                        new Solution.ListNode(2,
                                new Solution.ListNode(3,
                                        new Solution.ListNode(4,
                                                new Solution.ListNode(5)))));
        int left = 3;
        int right = 5;

        Solution.ListNode result =
                new Solution.ListNode(1,
                        new Solution.ListNode(2,
                                new Solution.ListNode(5,
                                        new Solution.ListNode(4,
                                                new Solution.ListNode(3)))));

        assertEquals(new Solution().reverseBetween(head, left, right), result);
    }

    @Test
    void reverseBetween_4() {
        Solution.ListNode head =
                new Solution.ListNode(1,
                        new Solution.ListNode(2,
                                new Solution.ListNode(3,
                                        new Solution.ListNode(4,
                                                new Solution.ListNode(5)))));
        int left = 1;
        int right = 2;

        Solution.ListNode result =
                new Solution.ListNode(2,
                        new Solution.ListNode(1,
                                new Solution.ListNode(3,
                                        new Solution.ListNode(4,
                                                new Solution.ListNode(5)))));

        assertEquals(new Solution().reverseBetween(head, left, right), result);
    }
}