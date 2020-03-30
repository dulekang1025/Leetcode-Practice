package Leetcode_655_Print_Binary_Tree;

import TreeNode.TreeNode;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<String>> printTree(TreeNode root) {
        int height = depth(root);
        int width = (1 << height) - 1;
        List<String> row = new ArrayList<>();
        for(int i = 0; i < width; i++){
            row.add("");
        }
        List<List<String>> ans = new ArrayList<>();
        for(int i = 0; i < height; i++){
            ans.add(new ArrayList<>(row));
        }
        helper(root, ans, 0, 0, width - 1);
        return ans;
    }

    private int depth(TreeNode root){
        if(root == null) return 0;
        return Math.max(depth(root.right), depth(root.left)) + 1;
    }

    private void helper(TreeNode root, List<List<String>> ans, int level, int left, int right){
        if(root == null) return;
        List<String> row = ans.get(level);
        int mid = (right + left) / 2;
        row.set(mid, Integer.toString(root.val));
        helper(root.left, ans, level + 1, left, mid - 1);
        helper(root.right, ans, level + 1, mid + 1, right);
    }
}