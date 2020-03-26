package Leetcode_897_Increasing_Order_Search_Tree;

import TreeNode.TreeNode;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public TreeNode increasingBST(TreeNode root) {
        List<TreeNode> res = new ArrayList<>();
        res = inorder(root, res);
        TreeNode prev = null;
        TreeNode new_root = null;
        for(TreeNode cur : res){
            cur.left = null;
            cur.right = null;
            if(prev == null) {
                new_root = cur;
                prev = cur;
            }else{
                prev.right = cur;
                prev = cur;
            }
        }
        return new_root;
    }
    private List<TreeNode> inorder(TreeNode root, List<TreeNode> res){
        if(root == null) return res;
        inorder(root.left,res);
        res.add(root);
        inorder(root.right,res);
        return res;
    }
}

