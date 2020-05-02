package leetcode_1110_Delete_Nodes_And_Return_Forest;

import TreeNode.TreeNode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {
    private List<TreeNode> ans = new ArrayList<>();
    Set<Integer> set = new HashSet<>();
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        for(int n : to_delete) set.add(n);
        root = helper(root, true);
        return ans;
    }
    private TreeNode helper(TreeNode root, Boolean isRoot){
        if(root == null) return null;
        Boolean delete = set.contains(root.val);
        if(isRoot && !delete) ans.add(root);
        root.left = helper(root.left, delete);
        root.right = helper(root.right, delete);
        return delete ? null : root;
    }
}
