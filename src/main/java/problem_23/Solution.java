package problem_23;

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        /*
        The fastest solution (not my) with merge2List

        public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0) return null;
        int interval = 1;
        while(interval < lists.length){
            for(int i = interval; i < lists.length; i+=interval*2){
                lists[i-interval] = merge2List(lists[i], lists[i-interval]);
            }
            interval *= 2;
        }
        return lists[0];
        }

        public ListNode merge2List(ListNode l1, ListNode l2){
            if(l1 == null) return l2;
            if(l2 == null) return l1;
            ListNode head = new ListNode(0);
            ListNode curr = head;
            while(l1 != null && l2 != null){
                if(l1.val <= l2.val){
                    curr.next = l1;
                    l1 = l1.next;
                    curr = curr.next;
                }
                else{
                    curr.next = l2;
                    l2 = l2.next;
                    curr = curr.next;
                }
            }
            if(l1 == null) curr.next = l2;
            else{
                curr.next = l1;
            }
            return head.next;
        }
        */

        ListNode root = new ListNode();
        ListNode tail = root;

        int countOfNotNullLists = 0;
        for (int i = 0; i < lists.length; ++i) {
            if (lists[i] != null) {
                ++countOfNotNullLists;
            }
        }

        while (countOfNotNullLists > 0) {
            int indexOfMinNode = -1;
            int minNodeValue = Integer.MAX_VALUE;
            // find index where nodeVal is min
            for (int i = 0; i < lists.length; ++i) {
                if (lists[i] != null && lists[i].val < minNodeValue) {
                    minNodeValue = lists[i].val;
                    indexOfMinNode = i;
                }
            }
            if (lists[indexOfMinNode].next == null) {
                --countOfNotNullLists;
            }
            tail.next = lists[indexOfMinNode];
            lists[indexOfMinNode] = lists[indexOfMinNode].next;
            tail = tail.next;
            tail.next = null;
        }
        return root.next;
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