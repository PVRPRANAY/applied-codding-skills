class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k == 1) return head;
        
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        ListNode prevGroupTail = dummy;
        ListNode curr = head;
        
        while (curr != null) {
            ListNode groupTail = prevGroupTail;
            for (int i = 0; i < k; i++) {
                groupTail = groupTail.next;
                if (groupTail == null) return dummy.next;
            }
            
            ListNode nextGroupHead = groupTail.next;
            ListNode prev = nextGroupHead;
            ListNode groupHead = curr;
            
            while (curr != nextGroupHead) {
                ListNode nextNode = curr.next;
                curr.next = prev;
                prev = curr;
                curr = nextNode;
            }
            
            prevGroupTail.next = groupTail;
            prevGroupTail = groupHead;
        }
        
        return dummy.next;
    }
}
