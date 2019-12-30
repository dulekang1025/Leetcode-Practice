package Leetcode_110_Balanced_Binary_Tree;

import TreeNode.TreeNode;

public class Solution2 {
    public boolean isBalanced(TreeNode root) {
        if(root == null) return true;
        if(depth(root) == -1) return false;
        return true;
    }
    private int depth(TreeNode root){
        if(root == null) return 0;
        int left = depth(root.left);
        int right = depth(root.right);
        if(left == -1 || right == -1) return -1;
        if(Math.abs(left - right) > 1) return -1;
        return Math.max(left, right) + 1;
    }
}
