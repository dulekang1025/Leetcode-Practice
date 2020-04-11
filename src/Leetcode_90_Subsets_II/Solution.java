package Leetcode_90_Subsets_II;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    private List<List<Integer>> res = new ArrayList<>();
    private List<Integer> temp = new ArrayList<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        dfs(nums, 0);
        return res;
    }
    private void dfs(int[] nums, int i){
        res.add(new ArrayList<>(temp));
        for(int j = i; j < nums.length; j++){
            temp.add(nums[j]);
            dfs(nums, j + 1);
            temp.remove(temp.size() - 1);
            while(j+1 < nums.length && nums[j] == nums[j+1]) j++;
        }
    }
}
