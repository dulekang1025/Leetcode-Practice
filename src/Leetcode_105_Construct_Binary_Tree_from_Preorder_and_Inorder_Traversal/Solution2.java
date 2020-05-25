package Leetcode_105_Construct_Binary_Tree_from_Preorder_and_Inorder_Traversal;

import TreeNode.TreeNode;

import java.util.HashMap;
import java.util.Map;

//本题在属于二叉树遍历的经典题目，已知二叉树的两个遍历序列构造二叉树，有如下性质：
//
//若已知先序和中序，则可以构造出唯一的二叉树
//
//若已知先序和后序，则可以构造出多颗不同的二叉树
//
//若已知中序和后序，则可以构造出唯一的二叉树
//
//本题中我们已知的条件为中序遍历和后序遍历，所以我们一定可以构造出唯一的二叉树。

class Solution2 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < inorder.length; i++){
            map.put(inorder[i], i);
        }
        return helper(preorder, inorder, map, 0, 0, inorder.length - 1);
    }
    public TreeNode helper(int[] preorder, int[] inorder, Map<Integer, Integer> map, int preStart, int inStart, int inEnd){
        if(preStart > preorder.length || inStart > inEnd) return null;
        TreeNode root = new TreeNode(preorder[preStart]);
        int root_index = map.get(preorder[preStart]);
        root.left = helper(preorder, inorder, map, preStart + 1, inStart, root_index - 1);
        root.right = helper(preorder, inorder, map, preStart + (root_index - inStart) + 1, root_index + 1, inEnd);
        return root;
    }
}
