package Leetcode_206_Reverse_Linked_List;

import Singly_LinkedList.ListNode;

class Solution2 {
    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode newHead = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }
}
