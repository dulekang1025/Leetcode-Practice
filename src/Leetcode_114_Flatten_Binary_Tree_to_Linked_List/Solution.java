package Leetcode_114_Flatten_Binary_Tree_to_Linked_List;

import TreeNode.TreeNode;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public void flatten(TreeNode root) {
        if(root == null) return;
        flatten(root.left);
        flatten(root.right);
        TreeNode temp = root.right;
        root.right = root.left;
        root.left = null;
        TreeNode cur = root;
        while(cur.right != null){
            cur = cur.right;
        }
        cur.right = temp;
    }
}