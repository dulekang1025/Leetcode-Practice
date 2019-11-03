package Leetcode_98_Validate_Binary_Search_Tree;

import TreeNode.TreeNode;

class Solution {
    public boolean isValidBST(TreeNode root) {
        if(root == null) return true;
        return recursion(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    public boolean recursion(TreeNode root, long min, long max){
        if(root == null) return true;
        if(root.val <= min || root.val >= max) return false;
        return recursion(root.left, min, root.val) && recursion(root.right, root.val, max);
    }
}
