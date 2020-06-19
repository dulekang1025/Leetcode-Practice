package Leetcode_1339_Maximum_Product_of_Splitted_Binary_Tree;

import TreeNode.TreeNode;

class Solution {
    long res = -1;
    long sum = 0;
    public int maxProduct(TreeNode root) {
        sum = dfs(root);
        dfs(root);
        return (int)(res % (Math.pow(10, 9) + 7));
    }
    private int dfs(TreeNode root){
        if(root == null) return 0;
        long sumLeft = dfs(root.left);
        long sumRight = dfs(root.right);
        res = Math.max(res, Math.max(sumLeft * (sum - sumLeft), sumRight * (sum - sumRight)));
        return (int)(sumLeft + sumRight + root.val);
    }
}