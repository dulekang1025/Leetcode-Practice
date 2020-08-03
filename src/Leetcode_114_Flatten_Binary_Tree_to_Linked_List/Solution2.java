package Leetcode_114_Flatten_Binary_Tree_to_Linked_List;

import TreeNode.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution2 {
    public void flatten(TreeNode root) {
        Deque<TreeNode> stack = new ArrayDeque<>();
        while(!stack.isEmpty() || root != null){
            while(root != null){
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            TreeNode temp = root.right;
            root.right = root.left;
            root.left = null;
            TreeNode cur = root;
            while(cur.right != null){
                cur = cur.right;
            }
            cur.right = temp;
            root = root.right;
        }
    }
}
