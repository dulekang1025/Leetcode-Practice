package Leetcode_105_Bulid_Tree_from_Pre_Inorder;

import TreeNode.TreeNode;

import java.util.HashMap;
import java.util.Map;

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
