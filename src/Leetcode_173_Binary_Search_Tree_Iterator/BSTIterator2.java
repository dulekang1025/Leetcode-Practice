package Leetcode_173_Binary_Search_Tree_Iterator;

import TreeNode.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

class BSTIterator2 {

    Deque<TreeNode> stack = new ArrayDeque<>();

    public BSTIterator2(TreeNode root) {
        while(root != null){
            stack.push(root);
            root = root.left;
        }
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode cur = stack.pop();
        int res = cur.val;
        while(cur != null){
            cur = cur.right;
            while(cur != null){
                stack.push(cur);
                cur = cur.left;
            }
        }
        return res;
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stack.isEmpty();
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */