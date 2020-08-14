package Leetcode_623_Add_One_Row_to_Tree;

import TreeNode.TreeNode;

public class Solution2 {
    public TreeNode addOneRow(TreeNode root, int v, int d) {
        if(d == 1){
            TreeNode node = new TreeNode(v);
            node.left = root;
            return node;
        }
        dfs(root, 1, v, d);
        return root;
    }
    private void dfs(TreeNode root, int depth, int v, int d){
        if(root == null) return;
        if(depth == d - 1){
            TreeNode tempL = root.left;
            TreeNode tempR = root.right;
            root.left = new TreeNode(v);
            root.right = new TreeNode(v);
            root.left.left = tempL;
            root.right.right = tempR;
        }else{
            dfs(root.left, depth + 1, v, d);
            dfs(root.right, depth + 1, v, d);
        }
    }
}
