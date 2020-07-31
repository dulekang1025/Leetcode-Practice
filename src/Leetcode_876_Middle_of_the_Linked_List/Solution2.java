package Leetcode_876_Middle_of_the_Linked_List;

import Singly_LinkedList.ListNode;

class Solution2 {
    public ListNode middleNode(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode slow = head, fast = head.next;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return fast == null ? slow : slow.next;
    }
}
