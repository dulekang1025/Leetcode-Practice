package Leetcode_606_Construct_String_from_Binary_Tree;

import TreeNode.TreeNode;

class Solution {
    public String tree2str(TreeNode t) {
        StringBuilder sb = new StringBuilder();
        dfs(t, sb);
        return sb.toString();
    }
    private void dfs(TreeNode t, StringBuilder sb){
        if(t == null) return;
        sb.append(t.val);
        if(t.left != null || t.right != null){
            sb.append('(');
            dfs(t.left, sb);
            sb.append(')');
        }
        if(t.right != null){
            sb.append('(');
            dfs(t.right, sb);
            sb.append(')');
        }
    }
}
