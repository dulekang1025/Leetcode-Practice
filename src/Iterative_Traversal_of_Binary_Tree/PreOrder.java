package Iterative_Traversal_of_Binary_Tree;


import TreeNode.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

public class PreOrder {
    public static void preOrder(TreeNode root){
        Deque<TreeNode> stack = new ArrayDeque<>();
        while(!stack.isEmpty() || root != null){
            while(root != null){
                System.out.println(root.val);
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            root = root.right;
        }
    }

    public static void main(String[] args) {
        // [1,3,null,null,2]
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.left.right = new TreeNode(2);
        preOrder(root);
    }
}
