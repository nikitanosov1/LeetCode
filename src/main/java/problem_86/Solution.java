package problem_86;

import java.util.Objects;

class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode smallHead = new ListNode();
        ListNode smallTail = smallHead;
        ListNode bigHead = new ListNode();
        ListNode bigTail = bigHead;
        while (head != null){
            if (head.val < x){
                smallTail.next = head;
                head = head.next;
                smallTail = smallTail.next;
                smallTail.next = null;
            }
            else{
                bigTail.next = head;
                head = head.next;
                bigTail = bigTail.next;
                bigTail.next = null;
            }
        }
        if (smallHead.next != null){
            head = smallHead.next;
            smallTail.next = bigHead.next;
        }else{
            head = bigHead.next;
        }
        return head;
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