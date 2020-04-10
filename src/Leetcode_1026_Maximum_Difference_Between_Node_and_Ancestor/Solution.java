package Leetcode_1026_Maximum_Difference_Between_Node_and_Ancestor;

import TreeNode.TreeNode;

class Solution {
    private int minV = 0;
    public int maxAncestorDiff(TreeNode root) {
        helper(root, Integer.MAX_VALUE, Integer.MIN_VALUE);
        return minV;
    }
    private void helper(TreeNode root, int min, int max){
        if(root == null) return;
        min = min > root.val ? root.val : min;
        max = max < root.val ? root.val : max;
        minV = Math.max(Math.abs(max - min), minV);
        helper(root.left, min, max);
        helper(root.right, min, max);
    }
}
