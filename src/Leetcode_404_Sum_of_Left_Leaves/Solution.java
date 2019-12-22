package Leetcode_404_Sum_of_Left_Leaves;

import TreeNode.TreeNode;

class Solution {
    int ans = 0;
    public int sumOfLeftLeaves(TreeNode root) {
        dfs(root);
        return ans;
    }
    public int dfs(TreeNode root){
        if(root == null) return 0;
        if(root.left != null && root.left.left == null && root.left.right == null) ans += root.left.val;
        dfs(root.left);
        dfs(root.right);
        return ans;
    }
}
