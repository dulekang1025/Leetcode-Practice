package Leetcode_24_Swap_Nodes_in_Pairs;
import Singly_LinkedList.ListNode;

class Solution2 {
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode nxt = head.next;
        head.next = swapPairs(nxt.next);
        nxt.next = head;
        return nxt;
    }
}
