package Leetcode_1305_All_Elements_in_Two_Binary_Search_Trees;

import TreeNode.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> res = new ArrayList<>();
        dfs(root1, res);
        dfs(root2, res);
        Collections.sort(res);
        return res;
    }
    private void dfs(TreeNode root, List<Integer> res){
        if(root == null) return;
        res.add(root.val);
        dfs(root.left, res);
        dfs(root.right, res);
        return;
    }
}
