package Leetcode_110_Balanced_Binary_Tree;

import TreeNode.TreeNode;

class Solution {
    public boolean isBalanced(TreeNode root) {
        if(root == null) return true;
        int left = depth(root.left,0);
        int right = depth(root.right,0);

        if(Math.abs(left - right) > 1) return false;
        return isBalanced(root.left) && isBalanced(root.right);
    }
    public int depth(TreeNode node, int d){
        if(node == null) return d;
        int left = depth(node.left,d + 1);
        int right = depth(node.right,d + 1);

        return Math.max(left, right);
    }
}