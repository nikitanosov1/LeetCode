package problem_206;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    private ListNode newRoot;

    public ListNode reverseList(ListNode head) {
        if (head == null) return null;
        recursion(head);
        return newRoot;
    }

    private ListNode recursion(ListNode node) {
        if (node.next == null) {
            newRoot = node;
            return node;  // tail
        }
        ListNode tail = recursion(node.next);
        tail.next = node;
        node.next = null;
        return node;
    }

    public static class ListNode {
        private int val;
        private ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}