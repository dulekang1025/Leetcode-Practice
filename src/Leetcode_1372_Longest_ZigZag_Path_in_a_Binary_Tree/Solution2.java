package Leetcode_1372_Longest_ZigZag_Path_in_a_Binary_Tree;

import TreeNode.TreeNode;

public class Solution2 {
    private int maxLength = 0;
    public int longestZigZag(TreeNode root) {
        if(root == null) return 0;
        dfs(root.left, false, 1);
        dfs(root.right, true, 1);
        return this.maxLength;
    }
    private void dfs(TreeNode root, boolean isRight, int length){
        if(root == null) return;
        this.maxLength = Math.max(length, this.maxLength);
        if(isRight){
            dfs(root.left, false, length + 1);
            dfs(root.right, true, 1);
        }else{
            dfs(root.right, true, length + 1);
            dfs(root.left, false, 1);
        }
    }
}
