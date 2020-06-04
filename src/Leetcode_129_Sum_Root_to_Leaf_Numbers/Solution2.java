package Leetcode_129_Sum_Root_to_Leaf_Numbers;

import TreeNode.TreeNode;

class Solution2 {
    int res = 0;
    StringBuilder sb = new StringBuilder();
    public int sumNumbers(TreeNode root) {
        dfs(root);
        return res;
    }
    private void dfs(TreeNode root){
        if(root == null) return;
        sb.append(root.val);
        if(root.left == null && root.right == null){
            int temp = Integer.parseInt(sb.toString());
            res += temp;
        }
        dfs(root.left);
        dfs(root.right);
        sb.deleteCharAt(sb.length() - 1);
    }
}
