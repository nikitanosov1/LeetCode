package problem_2095;

import java.util.Objects;

class Solution {
    public ListNode deleteMiddle(ListNode head) {
        // calculate size of LinkedList
        ListNode temp = head;
        int size = 0;
        while (temp != null) {
            temp = temp.next;
            ++size;
        }

        // borderline case  (size = 1)
        if (size == 1) {
            head = null;
            return head;
        }

        // calculate index of mid
        int indexOfMid = size / 2;

        // set prevOfMidListNode
        ListNode prevOfMidListNode = head;
        for (int i = 0; i < indexOfMid - 1; ++i) prevOfMidListNode = prevOfMidListNode.next;

        // delete MidNode
        prevOfMidListNode.next = prevOfMidListNode.next.next;

        return head;
    }

    public static class ListNode {
        private int val;
        private ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }

        @Override
        public String toString() {
            return "ListNode{" +
                    "val=" + val +
                    ", next=" + next +
                    '}';
        }

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
