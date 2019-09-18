package Leetcode_109_Convert_Sorted_List_to_BST;

import Singly_LinkedList.ListNode;
import TreeNode.TreeNode;

import java.util.ArrayList;

class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        if(head == null) return null;
        ListNode cur = head;
        ArrayList<Integer> l = new ArrayList<>();
        int n = 0;
        while(cur != null){
            n++;
            l.add(cur.val);
            cur = cur.next;
        }
        Integer[] a = (Integer[])l.toArray(new Integer[l.size()]);
        return helper(a,0,a.length -1);
    }
    public TreeNode helper(Integer[] a, int low, int high){
        if(low > high) return null;
        int mid = (low + high) / 2;
        TreeNode node = new TreeNode(a[mid]);
        node.left = helper(a,low,mid-1);
        node.right = helper(a,mid+1,high);
        return node;
    }
}
