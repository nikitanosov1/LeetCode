package problem_92;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode prevLeftNode = new ListNode(-1, head);
        for (int i = 0; i < left - 1; i++) {
            prevLeftNode = prevLeftNode.next;
        }
        ListNode rightNode = prevLeftNode;
        int length = right - left + 1;
        while (length > 0){
            rightNode = rightNode.next;
            --length;
        }
        ListNode afterRightNode = rightNode.next;
        rightNode.next = null;
        List<ListNode> tailAndHead = recursionReverse(prevLeftNode.next);
        prevLeftNode.next = tailAndHead.get(1);
        tailAndHead.get(0).next = afterRightNode;
        return (left == 1) ? prevLeftNode.next : head;
    }

    private List<ListNode> recursionReverse(ListNode head){
        if (head.next == null){
            return Arrays.asList(head, head);
        }
        List<ListNode> tailAndHead = recursionReverse(head.next);
        tailAndHead.get(0).next = head;
        tailAndHead.set(0, tailAndHead.get(0).next);
        return tailAndHead;
    }


    public static class ListNode {
        private int val;
        private ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            ListNode listNode = (ListNode) o;
            return val == listNode.val && Objects.equals(next, listNode.next);
        }

        @Override
        public int hashCode() {
            return Objects.hash(val, next);
        }
    }
}