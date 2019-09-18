package BT_Top_view;

import TreeNode.TreeNode;

import java.util.ArrayList;
import java.util.List;


// Very like Leetcode 199, but the output sequence is not easy to be right

// use this, mostRight and mostLeft
class Solution {
    public List<Integer> mostRight(TreeNode root) {
        List<Integer> res_rightSide = new ArrayList<>();
        List<Integer> res_leftSide = new ArrayList<>();
        List<Integer> ans = new ArrayList<>();
        if(root == null) return res_rightSide;

        dfs_rightSide(res_rightSide,root);
        dfs_leftSide(res_leftSide,root);
        res_leftSide.addAll(res_rightSide);
        ans = res_leftSide;
        return ans;
    }

    public void dfs_rightSide(List<Integer> res, TreeNode node){
        if(node == null) return;
        res.add(node.val);
        dfs_rightSide(res, node.right);

    }

    public void dfs_leftSide(List<Integer> res, TreeNode node){
        if(node == null) return;
        res.add(node.val);
        dfs_leftSide(res,node.right);

    }
}


