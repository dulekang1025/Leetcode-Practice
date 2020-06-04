package Leetcode_1457_Pseudo_Palindromic_Paths_in_a_Binary_Tree;

import TreeNode.TreeNode;

class Solution {
    int[] count = new int[10];
    int res = 0;
    public int pseudoPalindromicPaths (TreeNode root) {
        dfs(root);
        return res;
    }
    private void dfs(TreeNode root){
        if(root == null){
            return;
        }
        count[root.val]++;
        if(root.left == null && root.right == null){
            if(isPalindromic()){
                res++;
            }
        }
        dfs(root.left);
        dfs(root.right);
        count[root.val]--;
    }
    private boolean isPalindromic(){
        int hasMoreThanOneOdd = 0;
        boolean hasNode = false;
        for(int n : count){
            if(n == 0) continue;
            hasNode = true;
            if(n % 2 == 1){
                hasMoreThanOneOdd += 1;
            }
            if(hasMoreThanOneOdd > 1){
                return false;
            }
        }
        return hasNode;
    }
}
