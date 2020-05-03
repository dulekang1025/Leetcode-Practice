package Leetcode_1261_Find_Elements_in_a_Contaminated_Binary_Tree;

import TreeNode.TreeNode;

import java.util.HashSet;
import java.util.Set;

public class FindElements2 {

    Set<Integer> set = new HashSet<>();

    public FindElements2(TreeNode root) {
        helper(root);
    }

    public void helper(TreeNode root){
        if(root == null) return;
        root.val = root.val == -1 ? 0 : root.val;
        set.add(root.val);
        if(root.left != null){
            root.left.val = 2 * root.val + 1;
            helper(root.left);
        }
        if(root.right != null){
            root.right.val = 2 * root.val + 2;
            helper(root.right);
        }
    }

    public boolean find(int target) {
        return set.contains(target);
    }
}
