package Leetcode_501_Find_Mode_in_Binary_Search_Tree;


import TreeNode.TreeNode;

import java.util.ArrayList;
import java.util.List;

// O(1) Space
class Solution2 {

    Integer prev = null;
    int count = 1;
    int max = 0;

    public int[] findMode(TreeNode root) {
        List<Integer> modes = new ArrayList<>();
        helper(root, modes);
        int[] ans = new int[modes.size()];
        for(int i = 0; i < ans.length; i++){
            ans[i] = modes.get(i);
        }
        return ans;
    }

    private void helper(TreeNode root, List<Integer> modes){
        if(root == null) return;
        helper(root.left, modes);
        if(prev != null){
            if(prev == root.val){
                count++;
            }else{
                count = 1;
            }
        }
        if(count > max){
            max = count;
            modes.clear();
            modes.add(root.val);
        }else if(count == max){
            modes.add(root.val);
        }
        prev = root.val;
        helper(root.right, modes);
    }
}
