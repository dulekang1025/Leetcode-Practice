package Leetcode_1123_Lowest_Common_Ancestor_of_Deepest_Leaves;

import TreeNode.TreeNode;

class Solution2 {
    int max = -1;
    TreeNode lca = null;
    public TreeNode lcaDeepestLeaves(TreeNode root) {
        dfs(root, 0);
        return lca;
    }
    private int dfs(TreeNode root, int depth){
        if(root == null) return depth - 1;
        if(depth > max) max = depth;
        int left = dfs(root.left, depth + 1);
        int right = dfs(root.right, depth + 1);
        if(left == max && right == max){
            lca = root;
        }
        return Math.max(left, right);
    }
}