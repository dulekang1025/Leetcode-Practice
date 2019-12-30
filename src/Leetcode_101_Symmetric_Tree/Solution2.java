package Leetcode_101_Symmetric_Tree;

import TreeNode.TreeNode;

public class Solution2 {
    public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;
        if(root.right == null && root.left == null) return true;
        return isSy(root.left, root.right);
    }
    public boolean isSy(TreeNode left, TreeNode right){
        if(right == null && left == null) return true;
        if(right == null || left == null) return false;
        if(right.val != left.val) return false;
        return isSy(left.left, right.right) && isSy(left.right, right.left);
    }
}
