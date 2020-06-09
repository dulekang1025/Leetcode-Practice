package Leetcode_979_Distribute_Coins_in_Binary_Tree;

import TreeNode.TreeNode;

class Solution {
    int res = 0;
    public int distributeCoins(TreeNode root) {
        dfs(root);
        return res;
    }
    private int dfs(TreeNode root){
        if(root == null) return 0;
        int steps = 1 - root.val;
        int left = dfs(root.left);
        int right = dfs(root.right);
        res += Math.abs(left) + Math.abs(right);
        return steps + left + right;
    }
}
