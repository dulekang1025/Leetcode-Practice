package Leetcode_234_Palindrome_Linked_List;

import Singly_LinkedList.ListNode;

class Solution2 {
    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null) return true;
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        ListNode p = head;
        while(p != null){
            sb1.append(p.val);
            sb1.append("-");
            p = p.next;
        }
        p = reverse(head);
        while(p != null){
            sb2.append(p.val);
            sb2.append("-");
            p = p.next;
        }
        return sb1.toString().equals(sb2.toString());
    }
    private ListNode reverse(ListNode head){
        if(head == null || head.next == null) return head;
        ListNode newHead = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }
}
