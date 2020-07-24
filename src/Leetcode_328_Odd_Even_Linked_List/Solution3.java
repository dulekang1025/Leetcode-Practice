package Leetcode_328_Odd_Even_Linked_List;

import Singly_LinkedList.ListNode;

public class Solution3 {
    public ListNode oddEvenList(ListNode head) {
        if(head == null) return head;
        ListNode odd = head, even = head.next, evenHead = even;
        while(even != null && even.next != null){
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }
        odd.next = evenHead;
        return head;
    }
}
