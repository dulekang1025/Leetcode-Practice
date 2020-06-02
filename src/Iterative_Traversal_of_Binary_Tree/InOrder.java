package Iterative_Traversal_of_Binary_Tree;

import TreeNode.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

public class InOrder {
    public static void inOrder(TreeNode root){
        Deque<TreeNode> stack = new ArrayDeque<>();
        while(!stack.isEmpty() || root != null){
            while(root != null){
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            System.out.println(root.val);
            root = root.right;
        }
    }

    public static void main(String[] args) {
        // [1,3,null,null,2]
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.left.right = new TreeNode(2);
        inOrder(root);
    }
}
