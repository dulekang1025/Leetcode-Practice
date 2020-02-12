package Leetcode_141_Linked_List_Cycle;

import Singly_LinkedList.ListNode;

public class Solution2 {
    // using fast and slow pointers, if there is a cycle, the two points will be meet;
    public boolean hasCycle(ListNode head) {
        if(head == null || head.next == null) return false;
        ListNode f,s;
        f = head;
        s = head;
        while(f != null && f.next != null){
            s = s.next;
            f = f.next.next;
            if(s == f) return true;
        }
        return false;
    }
}
