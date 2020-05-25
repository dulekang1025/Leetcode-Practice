package Leetcode_889_Construct_Binary_Tree_from_Preorder_and_Postorder_Traversal;

import TreeNode.TreeNode;

class Solution {
    public TreeNode constructFromPrePost(int[] pre, int[] post) {
        return helper(pre, post, 0, pre.length - 1, 0, post.length - 1);
    }
    private TreeNode helper(int[] pre, int[] post, int preL, int preR, int postL, int postR){
        if(preL == preR) return new TreeNode(pre[preL]);
        if(preL > preR) return null;
        TreeNode root = new TreeNode(pre[preL]);
        System.out.println(preL + " " + preR);
        for(int i = postL; i <= postR; i++){
            if(post[i] == pre[preL + 1]){
                root.left = helper(pre, post, preL + 1, preL + i - postL + 1, postL, i);
                root.right = helper(pre, post, preL + i - postL + 2, preR, i + 1, postR - 1);
            }
        }
        return root;
    }
}
