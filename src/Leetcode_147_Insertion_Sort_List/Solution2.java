package Leetcode_147_Insertion_Sort_List;

import Singly_LinkedList.ListNode;

public class Solution2 {
    public ListNode insertionSortList(ListNode head) {
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode cur = head;
        while(cur != null && cur.next != null){
            if(cur.val < cur.next.val){
                cur = cur.next;
            }else{
                ListNode pre = dummy;
                while(pre.next != null && pre.next.val < cur.next.val){
                    pre = pre.next;
                }
                ListNode temp = cur.next;
                cur.next = cur.next.next;
                temp.next = pre.next;
                pre.next = temp;
            }
        }
        return dummy.next;
    }
}
