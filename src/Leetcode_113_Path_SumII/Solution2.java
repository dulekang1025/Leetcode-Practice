package Leetcode_113_Path_SumII;

import TreeNode.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution2 {
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        helper(root, sum, new ArrayList<>());
        return ans;
    }
    private void helper(TreeNode root, int sum, List<Integer> list){
        if(root == null) return;
        sum -= root.val;
        list.add(root.val);
        if(root.left == null && root.right == null && sum == 0){
            ans.add(new ArrayList<>(list));
        }
        helper(root.left, sum, list);
        helper(root.right, sum, list);
        list.remove(list.size() - 1);
    }
}
