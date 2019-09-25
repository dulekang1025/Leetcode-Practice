package Leetcode_237_Delete_Node_in_a_Linked_List;

import Singly_LinkedList.ListNode;

class Solution {
    public void deleteNode(ListNode node) {
        ListNode pre = node;
        while(node.next != null){
            pre = node;
            node.val = node.next.val;
            node = node.next;
        }
        pre.next = null;
    }
}
