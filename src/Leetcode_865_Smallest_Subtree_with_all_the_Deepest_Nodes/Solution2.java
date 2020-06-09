package Leetcode_865_Smallest_Subtree_with_all_the_Deepest_Nodes;

import TreeNode.TreeNode;

class Solution2 {
    int max = -1;
    TreeNode lca = null;
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
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
