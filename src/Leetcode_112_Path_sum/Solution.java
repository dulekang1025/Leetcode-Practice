package Leetcode_112_Path_sum;

import TreeNode.TreeNode;

class Solution {
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root == null) return false;
        // till leaf node
        if(root.left == null && root.right == null) return ((sum - root.val) == 0) ? true : false;

        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
    }
}