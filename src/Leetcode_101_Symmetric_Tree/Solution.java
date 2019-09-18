package Leetcode_101_Symmetric_Tree;

import TreeNode.TreeNode;

class Solution {
    public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;
        if(root.left == null && root.right == null) return true;
        return isSy(root.left,root.right);
    }
    public boolean isSy(TreeNode left, TreeNode right){
        if(left == null && right == null) return true;
        if(left == null || right == null) return false;
        return isSy(left.left,right.right) && isSy(left.right,right.left) && left.val == right.val;

    }
}
