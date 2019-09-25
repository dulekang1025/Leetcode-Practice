package Leetcode_876_Middle_of_the_Linked_List;

import Singly_LinkedList.ListNode;

class Solution {
    public ListNode middleNode(ListNode head) {
        ListNode f = head;
        ListNode s = head;
        while(f != null){
            if(f.next != null){
                f = f.next.next;
            }
            else break;
            s = s.next;
        }
        return s;
    }
}