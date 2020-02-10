package Leetcode_143_Reorder_List;

import Singly_LinkedList.ListNode;

import java.util.List;

/*
STILL WRANG ANSWER!!!!!!!
MAYBE WRONG DIRECTION!!!!
 */
class Solution {
    public void reorderList(ListNode head) {
        ListNode p1 = head;
        ListNode p2 = head;
        ListNode temp;

        while(p2.next.next != null){
            p2 = p2.next;
        }
        while(p1.next != null){
            while(p2.next.next != null){
                p2 = p2.next;
            }
            System.out.println(p1.val + ", " + p2.val);

            temp = p1.next;
            p1.next = p2.next;
            p2.next.next = temp;
            p2.next = null;
            p1 = p1.next.next;
            p2 = head;
        }
    }

    public static void main(String[] args){
        // create List
        ListNode head = new ListNode(1);
        ListNode prev = head;
        for(int i = 2; i < 6; i++){
            ListNode cur = new ListNode(i);
            prev.next = cur;
            prev = cur;
        }
//        ListNode t = head;
//        while(t != null){
//            System.out.println(t.val);
//            t = t.next;
//        }
        Solution s = new Solution();
        s.reorderList(head);
    }
}
