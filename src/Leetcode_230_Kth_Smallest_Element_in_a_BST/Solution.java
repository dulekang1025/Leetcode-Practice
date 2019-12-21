package Leetcode_230_Kth_Smallest_Element_in_a_BST;

import TreeNode.TreeNode;

class Solution {
    int counter = 0;
    int res = 0;
    public int kthSmallest(TreeNode root, int k) {
        inorder(root, k);
        return res;
    }
    public void inorder(TreeNode root, int target){
        if(root == null) return;
        inorder(root.left, target);
        counter++;
        if(counter == target){
            res = root.val;
            return;
        }
        inorder(root.right, target);
    }
}