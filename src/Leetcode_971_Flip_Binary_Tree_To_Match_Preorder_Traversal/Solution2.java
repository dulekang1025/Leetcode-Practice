package Leetcode_971_Flip_Binary_Tree_To_Match_Preorder_Traversal;

import TreeNode.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

class Solution2 {
    public List<Integer> flipMatchVoyage(TreeNode root, int[] voyage) {
        List<Integer> ans = new ArrayList<>();
        int index = 0;
        Deque<TreeNode> stack = new ArrayDeque<>();
        while(!stack.isEmpty() || root != null){
            while(root != null){
                if(root.val != voyage[index]){
                    ans.clear();
                    ans.add(-1);
                    return ans;
                }
                if(root.left != null && root.left.val != voyage[index + 1]){
                    TreeNode temp = root.right;
                    root.right = root.left;
                    root.left = temp;
                    ans.add(root.val);
                }
                index++;
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            root = root.right;
        }
        return ans;
    }
}
