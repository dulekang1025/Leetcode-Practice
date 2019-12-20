package Leetcode_129_Sum_Root_to_Leaf_Numbers;

import TreeNode.TreeNode;

class Solution {
    public int sumNumbers(TreeNode root) {
        return dfs(root,0);
    }
    public int dfs(TreeNode root, int sum){
        if(root == null) return 0;
        sum = sum*10 + root.val;
        if(root.right == null && root.left == null){
            return sum;
        }
        return dfs(root.right, sum) + dfs(root.left, sum);
    }
}
