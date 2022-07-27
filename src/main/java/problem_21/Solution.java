package problem_21;

import java.util.Objects;

class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode result = new ListNode();
        ListNode currentNode = result;
        while (list1 != null && list2 != null){
            currentNode.next = new ListNode();
            if (list1.val > list2.val){
                currentNode.next.val = list2.val;
                list2 = list2.next;
            }else{
                currentNode.next.val = list1.val;
                list1 = list1.next;
            }
            currentNode = currentNode.next;
        }
        while (list1 != null){
            currentNode.next = new ListNode(list1.val);
            list1 = list1.next;
            currentNode = currentNode.next;
        }
        while (list2 != null){
            currentNode.next = new ListNode(list2.val);
            list2 = list2.next;
            currentNode = currentNode.next;
        }
        return result.next;
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