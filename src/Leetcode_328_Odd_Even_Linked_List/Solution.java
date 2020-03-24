package Leetcode_328_Odd_Even_Linked_List;

import Singly_LinkedList.ListNode;

public class Solution {
    public ListNode oddEvenList(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode r = head;
        ListNode p = head.next;
        ListNode EvenHead = p;
        ListNode s = EvenHead;
        while(p != null && p.next != null){
            r.next = p.next;
            r = r.next;
            p = p.next.next;
            s.next = p;
            s = s.next;
        }
        r.next = EvenHead;
        return head;
    }
}
