package Leetcode_106_Construct_Binary_Tree_from_Inorder_and_Postorder_Traversal;

//本题在属于二叉树遍历的经典题目，已知二叉树的两个遍历序列构造二叉树，有如下性质：
//
//若已知先序和中序，则可以构造出唯一的二叉树
//
//若已知先序和后序，则可以构造出多颗不同的二叉树
//
//若已知中序和后序，则可以构造出唯一的二叉树
//
//本题中我们已知的条件为中序遍历和后序遍历，所以我们一定可以构造出唯一的二叉树。

import TreeNode.TreeNode;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < inorder.length; i++){
            map.put(inorder[i], i);
        }
        return helper(inorder, postorder, map, 0, postorder.length - 1, 0, inorder.length - 1);
    }
    public TreeNode helper(int[] inorder,int[] postorder, Map<Integer, Integer> map,int postL, int postR, int inL,int inR){
        if(inL > inR || postL > postR) return null;
        //System.out.println(postL + " " + postR);
        TreeNode root = new TreeNode(postorder[postR]);
        int k = map.get(postorder[postR]);
        // inorder :
        //          left : [inL, k - 1],  right : [k + 1, inR]
        // postorder :
        //          left : [postL, postL + k - 1 - inL], right : [postL + inL - k, postR - 1]
        root.left = helper(inorder, postorder, map, postL, postL + k - 1 - inL, inL, k - 1);
        root.right = helper(inorder, postorder, map, postL + k - inL, postR - 1, k + 1, inR);
        return root;
    }
}
