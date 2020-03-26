package Leetcode_872_Leaf_Similar_Trees;

import TreeNode.TreeNode;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> res1 = new ArrayList<>();
        List<Integer> res2 = new ArrayList<>();
        dfs(root1, res1);
        dfs(root2, res2);
        return res1.equals(res2);
    }
    private void dfs(TreeNode node, List<Integer> res){
        if(node == null) return;
        if(node.right == null && node.left == null){
            res.add(node.val);
        }
        dfs(node.left, res);
        dfs(node.right, res);
    }
}
