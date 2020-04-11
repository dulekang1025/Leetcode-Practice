package Leetcode_78_Subsets;

import java.util.ArrayList;
import java.util.List;

class Solution {
    private List<List<Integer>> res = new ArrayList<>();
    private List<Integer> temp = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        dfs(nums, 0);
        return res;
    }
    private void dfs(int[] nums, int i){
        res.add(new ArrayList<>(temp));
        for(int j = i; j < nums.length; j++){
            temp.add(nums[j]);
            dfs(nums, j + 1);
            temp.remove(temp.size() - 1);
        }
    }
}