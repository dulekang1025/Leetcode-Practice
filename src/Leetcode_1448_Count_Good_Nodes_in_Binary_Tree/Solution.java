package Leetcode_1448_Count_Good_Nodes_in_Binary_Tree;

import TreeNode.TreeNode;

class Solution {
    int res = 0;
    public int goodNodes(TreeNode root) {
        dfs(root, Integer.MIN_VALUE);
        return res;
    }
    private void dfs(TreeNode root, int max){
        if(root == null) return;
        if(root.val >= max){
            res++;
            max = root.val;
        }
        dfs(root.left, max);
        dfs(root.right, max);
    }
}
