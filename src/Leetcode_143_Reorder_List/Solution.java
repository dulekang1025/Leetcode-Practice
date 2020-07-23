package Leetcode_143_Reorder_List;

import Singly_LinkedList.ListNode;

import java.util.List;

/*
STILL WRANG ANSWER!!!!!!!
MAYBE WRONG DIRECTION!!!!
 */
class Solution {
    public void reorderList(ListNode head) {
        if(head == null || head.next == null || head.next.next == null) return;
        ListNode slow = head, fast = head, p = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode q = reverse(slow.next);
        ListNode cur = q;
        slow.next = null;
        while(p != null && q != null){
            ListNode temp_p = p.next;
            ListNode temp_q = q.next;
            p.next = q;
            q.next = temp_p;
            p = temp_p;
            q = temp_q;
        }
        return;
    }
    private ListNode reverse(ListNode q){
        if(q == null || q.next == null) return q;
        q.next = reverse(q.next);
        ListNode temp = q, newHead = q.next;
        while(temp.next != null){
            temp = temp.next;
        }
        temp.next = q;
        q.next = null;
        return newHead;
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
