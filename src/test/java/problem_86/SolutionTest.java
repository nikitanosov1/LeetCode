package problem_86;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void example_1() {
        Solution.ListNode head =
                new Solution.ListNode(1,
                        new Solution.ListNode(4,
                                new Solution.ListNode(3,
                                        new Solution.ListNode(2,
                                                new Solution.ListNode(5,
                                                        new Solution.ListNode(2))))));
        int x = 3;

        Solution.ListNode result =
                new Solution.ListNode(1,
                        new Solution.ListNode(2,
                                new Solution.ListNode(2,
                                        new Solution.ListNode(4,
                                                new Solution.ListNode(3,
                                                        new Solution.ListNode(5))))));

        assertEquals(new Solution().partition(head, x), result);
    }

    @Test
    void example_2() {
        Solution.ListNode head =
                new Solution.ListNode(2,
                        new Solution.ListNode(1));
        int x = 2;

        Solution.ListNode result =
                new Solution.ListNode(1,
                        new Solution.ListNode(2));

        assertEquals(new Solution().partition(head, x), result);
    }

    @Test
    void example_3() {
        Solution.ListNode head =
                new Solution.ListNode(1,
                        new Solution.ListNode(4,
                                new Solution.ListNode(3,
                                        new Solution.ListNode(2,
                                                new Solution.ListNode(5,
                                                        new Solution.ListNode(2))))));
        int x = -5;

        Solution.ListNode result =
                new Solution.ListNode(1,
                        new Solution.ListNode(4,
                                new Solution.ListNode(3,
                                        new Solution.ListNode(2,
                                                new Solution.ListNode(5,
                                                        new Solution.ListNode(2))))));

        assertEquals(new Solution().partition(head, x), result);
    }
}