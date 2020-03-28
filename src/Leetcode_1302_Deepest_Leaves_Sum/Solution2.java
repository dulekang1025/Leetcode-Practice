package Leetcode_1302_Deepest_Leaves_Sum;

import TreeNode.TreeNode;

class Solution2 {
    private int sum = 0;
    private int maxLevel = 0;
    public int deepestLeavesSum(TreeNode root) {
        helper(root, 0);
        return this.sum;
    }
    private void helper(TreeNode root, int level){
        if(root == null) return;
        if(level == this.maxLevel) this.sum += root.val;
        if(level > this.maxLevel){
            this.maxLevel = level;
            this.sum = root.val;
        }
        helper(root.left, level + 1);
        helper(root.right, level + 1);
    }
}
