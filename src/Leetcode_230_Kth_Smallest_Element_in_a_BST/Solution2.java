package Leetcode_230_Kth_Smallest_Element_in_a_BST;

import TreeNode.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution2 {
    public int kthSmallest(TreeNode root, int k) {
        Deque<TreeNode> stack = new ArrayDeque<>();
        if(root == null) return 0;
        stack.push(root);
        while(!stack.isEmpty() || root != null){
            while(root != null){
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            k--;
            if(k == 0) return root.val;
            root = root.right;
        }
        return 0;
    }
}
