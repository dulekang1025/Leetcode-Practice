package Leetcode_971_Flip_Binary_Tree_To_Match_Preorder_Traversal;

import TreeNode.TreeNode;

import java.util.ArrayList;
import java.util.List;

class Solution {
    List<Integer> ans = new ArrayList<>();
    int index = 0;
    boolean flag = false;
    public List<Integer> flipMatchVoyage(TreeNode root, int[] voyage) {
        dfs(root, voyage);
        return ans;
    }
    public void dfs(TreeNode root, int[] voyage){
        if(root == null) return;
        if(root.val != voyage[index]){
            ans.clear();
            ans.add(-1);
            return;
        }
        if(root.left != null && root.left.val != voyage[index + 1]){
            TreeNode temp = root.right;
            root.right = root.left;
            root.left = temp;
            ans.add(root.val);
        }
        index++;
        dfs(root.left, voyage);
        dfs(root.right, voyage);
    }
}
