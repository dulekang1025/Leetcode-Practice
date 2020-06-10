package Leetcode_173_Binary_Search_Tree_Iterator;

import TreeNode.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

// Space : O(N)
class BSTIterator {

    List<Integer> inOrder;
    int index;

    public BSTIterator(TreeNode root) {
        Deque<TreeNode> stack = new ArrayDeque<>();
        inOrder = new ArrayList<>();
        while(root != null || !stack.isEmpty()){
            while(root != null){
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            inOrder.add(root.val);
            root = root.right;
        }
        index = 0;
    }

    /** @return the next smallest number */
    public int next() {
        return inOrder.get(index++);
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return index < inOrder.size();
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */
