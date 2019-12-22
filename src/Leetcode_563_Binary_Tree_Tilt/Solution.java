package Leetcode_563_Binary_Tree_Tilt;

import TreeNode.TreeNode;

class Solution {
    int ans = 0;
    public int findTilt(TreeNode root) {
        dfs(root);
        return ans;
    }
    public int dfs(TreeNode root){
        if(root == null) return 0;
        int sum1 = dfs(root.left);
        int sum2 = dfs(root.right);
        ans += Math.abs(sum1 - sum2);
        return root.val + sum1 + sum2;
    }
}
