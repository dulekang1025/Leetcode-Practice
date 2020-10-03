package Leetcode_199_Binary_Tree_Right_Side_View;

import TreeNode.TreeNode;

import java.util.ArrayList;
import java.util.List;

class Solution3 {
    List<Integer> ans = new ArrayList<>();
    public List<Integer> rightSideView(TreeNode root) {
        dfs(root, 0);
        return ans;
    }
    private void dfs(TreeNode root, int depth){
        if(root == null) return;
        if(depth == ans.size()){
            ans.add(root.val);
        }
        dfs(root.right, depth + 1);
        dfs(root.left, depth + 1);
    }
}
