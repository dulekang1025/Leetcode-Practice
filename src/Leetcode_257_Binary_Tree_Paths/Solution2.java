package Leetcode_257_Binary_Tree_Paths;

import TreeNode.TreeNode;

import java.util.ArrayList;
import java.util.List;

class Solution2 {
    List<String> ans = new ArrayList<>();
    List<Integer> list = new ArrayList<>();
    public List<String> binaryTreePaths(TreeNode root) {
        dfs(root);
        return ans;
    }
    private void dfs(TreeNode root){
        if(root == null) return;
        if(root.left == null && root.right == null){
            StringBuilder sb = new StringBuilder();
            for(int n : list){
                sb.append(n).append("->");
            }
            sb.append(root.val);
            ans.add(sb.toString());
        }
        list.add(root.val);
        dfs(root.left);
        dfs(root.right);
        list.remove(list.size() - 1);
    }
}
