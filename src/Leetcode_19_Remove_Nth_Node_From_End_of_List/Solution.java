package Leetcode_19_Remove_Nth_Node_From_End_of_List;

import Singly_LinkedList.ListNode;

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode last = dummy;
        if(dummy.next == null){
            return dummy.next;
        }
        // 1. move the pre to the Nth node
        for(int i = 1; i <= n + 1; i++){
            pre = pre.next;
        }
        // 2, move pre and last at same time until pre get to last node
        while(pre != null){
            pre = pre.next;
            last = last.next;
        }
        // 3. remove last.next node
        last.next = last.next.next;

        return dummy.next;
        //     ListNode dummy = new ListNode(0);
        // dummy.next = head;
        // ListNode first = dummy;
        // ListNode second = dummy;
        // // Advances first pointer so that the gap between first and second is n nodes apart
        // for (int i = 1; i <= n + 1; i++) {
        //     first = first.next;
        // }
        // // Move first to the end, maintaining the gap
        // while (first != null) {
        //     first = first.next;
        //     second = second.next;
        // }
        // second.next = second.next.next;
        // return dummy.next;
    }
}
