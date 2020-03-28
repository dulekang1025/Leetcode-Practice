package Leetcode_998_Maximum_Binary_Tree_II;

import TreeNode.TreeNode;

class Solution {
    public TreeNode insertIntoMaxTree(TreeNode root, int val) {
        if(root == null) return new TreeNode(val);
        if(val > root.val){
            TreeNode cur = new TreeNode(val);
            cur.left = root;
            return cur;
        }else{
            root.right = insertIntoMaxTree(root.right, val);
        }
        return root;
    }
}
