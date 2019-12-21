package Leetcode_437_Path_Sum_III;

import TreeNode.TreeNode;

class Solution {
    public int pathSum(TreeNode root, int sum) {
        if(root == null) return 0;
        return helper(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
    }
    public int helper(TreeNode root, int sum){
        if(root == null) return 0;
        int counter = 0;
        if(sum - root.val == 0) counter++;
        counter += helper(root.right, sum - root.val);
        counter += helper(root.left, sum - root.val);
        return counter;
    }
}
