package Leetcode_328_Odd_Even_Linked_List;

import Singly_LinkedList.ListNode;

public class Solution2 {
    public ListNode oddEvenList(ListNode head) {
        ListNode odd = new ListNode();
        ListNode even = new ListNode();
        ListNode p_odd = odd;
        ListNode p_even = even;
        int i = 1;
        while(head != null){
            if(i % 2 != 0){
                p_odd.next = head;
                p_odd = p_odd.next;
            }else{
                p_even.next = head;
                p_even = p_even.next;
            }
            head = head.next;
            i++;
        }
        p_even.next = null;
        p_odd.next = even.next;
        return odd.next;
    }
}
