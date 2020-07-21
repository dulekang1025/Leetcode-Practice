package Leetcode_109_Convert_Sorted_List_to_BST;

import Singly_LinkedList.ListNode;
import TreeNode.TreeNode;

public class Solution2 {
    public TreeNode sortedListToBST(ListNode head) {
        return helper(head, null);
    }
    private ListNode findMid(ListNode head, ListNode tail){
        ListNode slow = head, fast = head;
        while(fast != tail && fast.next != tail){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    private TreeNode helper(ListNode head, ListNode tail){
        if(head == tail) return null;
        ListNode node = findMid(head, tail);
        TreeNode root = new TreeNode(node.val);
        root.left = helper(head, node);
        root.right = helper(node.next, tail);
        return root;
    }
}
