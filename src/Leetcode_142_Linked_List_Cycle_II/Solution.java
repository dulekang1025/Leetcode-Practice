package Leetcode_142_Linked_List_Cycle_II;

import Singly_LinkedList.ListNode;

class Solution {
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode slow = head, fast = head.next;  /// 在cut到链表长度为2时，如果fast, slow都指向头部，那么fast会走两步，slow走一步，cut点是不对的。 如果fast先走一步，就会避免长度为2时出现的特殊错误情况。
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode tmp = slow.next;
        slow.next = null;
        ListNode left = sortList(head);
        ListNode right = sortList(tmp);
        ListNode res = new ListNode();
        ListNode p = res;
        while(left != null && right != null){
            if(left.val < right.val){
                p.next = left;
                left = left.next;
            }else{
                p.next = right;
                right = right.next;
            }
            p = p.next;
        }
        p.next = left == null ? right : left;
        return res.next;
    }
}
