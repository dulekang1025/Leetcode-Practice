package Leetcode_234_Palindrome_Linked_List;

import Singly_LinkedList.ListNode;

public class Solution3 {
    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null) return true;
        ListNode slow = head, fast = head.next;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode mid = reverse(slow.next);
        slow.next = null;
        while(head != null && mid != null){
            if(head.val != mid.val) return false;
            head = head.next;
            mid = mid.next;
        }
        return true;
    }
    private ListNode reverse(ListNode head){
        if(head == null || head.next == null) return head;
        ListNode newHead = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }
}
