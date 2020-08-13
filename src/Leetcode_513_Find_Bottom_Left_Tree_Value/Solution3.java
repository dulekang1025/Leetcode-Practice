package Leetcode_513_Find_Bottom_Left_Tree_Value;

import TreeNode.TreeNode;

public class Solution3 {
    Integer res = null;
    int max = Integer.MIN_VALUE;
    public int findBottomLeftValue(TreeNode root) {
        dfs(root, 0);
        return res;
    }
    private void dfs(TreeNode root, int depth){
        if(root == null) return;
        dfs(root.left, depth + 1);
        dfs(root.right, depth + 1);
        if(depth > max){
            max = depth;
            res = root.val;
        }
    }
}
