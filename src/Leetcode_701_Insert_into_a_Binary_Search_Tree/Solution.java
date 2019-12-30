package Leetcode_701_Insert_into_a_Binary_Search_Tree;

import TreeNode.TreeNode;

class Solution {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if(root == null) root = new TreeNode(val);
        TreeNode temp = root;
        TreeNode prev = null;
        while(temp != null){
            prev = temp;
            if(temp.val > val) {temp = temp.left;}
            else {temp = temp.right;}
        }
        if(prev.val > val) {prev.left = new TreeNode(val);}
        else{
            prev.right = new TreeNode(val);
        }
        return root;
    }
}
