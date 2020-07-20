package Leetcode_203_Remove_Linked_List_Elements;

import Singly_LinkedList.ListNode;

public class Solution2 {
    public ListNode removeElements(ListNode head, int val) {
        if(head == null) return head;
        head.next = removeElements(head.next, val);
        if(head.val == val) return head.next;
        return head;
    }
}
