package Leetcode_968_Binary_Tree_Cameras;

import TreeNode.TreeNode;

class Solution {
    int res = 0;
    public int minCameraCover(TreeNode root) {
        // 0 : no cover
        // 1 : covered
        // 2 : installed
        if(dfs(root) == 0){
            res++;
        }
        return res;
    }
    private int dfs(TreeNode root){
        if(root == null) return 1;
        int left = dfs(root.left);
        int right = dfs(root.right);
        if(left == 0 || right == 0){
            res++;
            return 2;
        }
        if(left == 1 && right == 1){
            return 0;
        }
        if(left + right >= 3){
            return 1;
        }
        return -1;
    }
}
