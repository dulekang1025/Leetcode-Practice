package Leetcode_687_Longest_Univalue_Path;

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
    int res = 0;
    public int longestUnivaluePath(TreeNode root) {
        helper(root);
        return res;
    }
    public int helper(TreeNode root){
        if(root == null) return 0;
        int leftCount = helper(root.left);
        int rightCount = helper(root.right);
        int left = 0;
        int right = 0;
        if(root.left != null && root.val == root.left.val){
            left = leftCount + 1;
        }
        if(root.right != null && root.val == root.right.val){
            right = rightCount + 1;
        }
        res = Math.max(res, left + right);
        return Math.max(left,right);
    }
}