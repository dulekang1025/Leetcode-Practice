package Leetcode_988_Smallest_String_Starting_From_Leaf;

import TreeNode.TreeNode;

class Solution {
    StringBuilder sb = new StringBuilder();
    String min = "";
    public String smallestFromLeaf(TreeNode root) {
        dfs(root);
        return min;
    }
    private void dfs(TreeNode root){
        if(root == null) return;
        sb.append((char)(root.val + 'a'));
        if(root.left == null && root.right == null){
            String temp = sb.reverse().toString();
            if(min == ""){
                min = temp;
            }else{
                min = temp.compareTo(min) < 0 ? temp : min;
            }
            sb.reverse();
        }
        dfs(root.right);
        dfs(root.left);
        sb.deleteCharAt(sb.length() - 1);
    }
}
