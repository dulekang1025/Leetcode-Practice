package Leetcode_114_Flatten_Binary_Tree_to_Linked_List;

import TreeNode.TreeNode;

public class Solution3 {
    public void flatten(TreeNode root) {
        if(root == null) return;
        flatten(root.left);
        TreeNode temp = root.right;
        root.right = root.left;
        root.left = null;
        TreeNode cur = root;
        while(cur.right != null){
            cur = cur.right;
        }
        cur.right = temp;
        flatten(root.right);
    }
}
