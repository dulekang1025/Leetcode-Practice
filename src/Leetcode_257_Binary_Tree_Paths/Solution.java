package Leetcode_257_Binary_Tree_Paths;

import TreeNode.TreeNode;

import java.util.LinkedList;
import java.util.List;

class Solution {
    LinkedList<String> res = new LinkedList<>();
    public List<String> binaryTreePaths(TreeNode root) {
        dfs(root, "");
        return res;
    }
    public void dfs(TreeNode root, String s){
        if(root == null) return;
        if(root.left == null && root.right == null){
            res.add(s + root.val);
        }
        s += root.val + "->";
        dfs(root.left, s);
        dfs(root.right, s);
    }
}
