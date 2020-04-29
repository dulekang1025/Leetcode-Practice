package Leetcode_124_Binary_Tree_Maximum_Path_Sum;

import TreeNode.TreeNode;

class Solution {
    private int max = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        helper(root);
        return max;
    }
    private int helper(TreeNode root){
        if(root == null) return 0;
        int left = helper(root.left);
        int right = helper(root.right);
        max = Math.max(max, Math.max(root.val, Math.max(root.val + right,
                Math.max(root.val + left,root.val + left + right ))));
        return Math.max(root.val, Math.max(root.val + right, root.val + left));
    }
}
