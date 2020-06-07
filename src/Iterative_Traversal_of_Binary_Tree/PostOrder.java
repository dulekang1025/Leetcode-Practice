package Iterative_Traversal_of_Binary_Tree;

import TreeNode.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

public class PostOrder {

    public void postOrder(TreeNode root){
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode lastVisited = root;
        while(!stack.isEmpty() || root != null){
            while(root != null){
                stack.push(root);
                root = root.left;
            }
            root = stack.peek();
            if(root.right == null || root.right == lastVisited){
                System.out.println(root.val);
                lastVisited = stack.pop();
                root = null;
            }else {
                root = root.right;
            }
        }
    }
}
