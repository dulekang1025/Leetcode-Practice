package Leetcode_1261_Find_Elements_in_a_Contaminated_Binary_Tree;

import TreeNode.TreeNode;

import java.util.HashSet;
import java.util.Set;

class FindElements {

    Set<Integer> set = new HashSet<>();

    public FindElements(TreeNode root) {
        if(root != null) root.val = 0;
        set.add(root.val);
        helper(root.left, 1, root.val); // left : 1
        helper(root.right, 0, root.val); // right : 0
    }

    public void helper(TreeNode root, int isLeft, int parentVal){
        if(root == null) return;
        if(isLeft == 1){
            root.val = 2 * parentVal + 1;
        }else{
            root.val = 2 * parentVal + 2;
        }
        set.add(root.val);
        helper(root.left, 1, root.val);
        helper(root.right, 0, root.val);
    }

    public boolean find(int target) {
        return set.contains(target);
    }
}

/**
 * Your FindElements object will be instantiated and called as such:
 * FindElements obj = new FindElements(root);
 * boolean param_1 = obj.find(target);
 */
