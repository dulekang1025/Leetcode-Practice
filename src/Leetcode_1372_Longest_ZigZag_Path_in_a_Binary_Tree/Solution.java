package Leetcode_1372_Longest_ZigZag_Path_in_a_Binary_Tree;

import TreeNode.TreeNode;

class Solution {
    private int maxLength = 0;
    public int longestZigZag(TreeNode root) {
        dfs(root, false, 0);
        dfs(root, true, 0);
        return this.maxLength;
    }
    private void dfs(TreeNode root, boolean isRight, int length){
        if(root == null) return;
        this.maxLength = Math.max(length, this.maxLength);
        if(isRight){
            dfs(root.right, false, length + 1); // turn to left
            dfs(root.left, true, 1); // restart from current node
        }else{
            dfs(root.left, true, length + 1); // turn to right
            dfs(root.right, false, 1); // restart from current node
        }
    }
}
