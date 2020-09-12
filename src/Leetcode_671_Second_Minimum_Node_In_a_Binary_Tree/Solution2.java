package Leetcode_671_Second_Minimum_Node_In_a_Binary_Tree;

import TreeNode.TreeNode;

public class Solution2 {
    long ans = Long.MAX_VALUE;
    int min1;
    public int findSecondMinimumValue(TreeNode root) {
        min1 = root.val;
        dfs(root);
        return ans == Long.MAX_VALUE ? -1 : (int)ans;
    }

    private void dfs(TreeNode root){
        if(root == null) return;
        if(min1 < root.val && root.val <= ans){
            ans = root.val;
        }
        if(min1 == root.val){
            dfs(root.left);
            dfs(root.right);
        }
    }
}
