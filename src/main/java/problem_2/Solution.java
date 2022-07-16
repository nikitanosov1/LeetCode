package problem_2;

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = null;
        ListNode currentNode = null;
        int firstDigit;
        int secondDigit;
        boolean addition = false;
        while (l1 != null || l2 != null){
            firstDigit = (l1 == null) ? 0 : l1.val;
            secondDigit = (l2 == null) ? 0 : l2.val;

            if (result == null){
                result = new ListNode();
                currentNode = result;
            }else{
                currentNode.next = new ListNode();
                currentNode = currentNode.next;
            }
            int sumTwoDigits = firstDigit + secondDigit;
            if (addition) {
                ++sumTwoDigits;
                addition = false;
            }
            if (sumTwoDigits > 9){
                currentNode.val = sumTwoDigits % 10;
                addition = true;
            }else{
                currentNode.val = sumTwoDigits;
            }

            l1 = (l1 != null) ? l1.next : null;
            l2 = (l2 != null) ? l2.next : null;
        }
        if (addition){
            currentNode.next = new ListNode(1);
        }
        return result;
    }
    private class ListNode {
        private int val;
        private ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}