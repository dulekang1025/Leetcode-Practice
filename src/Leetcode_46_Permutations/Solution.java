package Leetcode_46_Permutations;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(res, new ArrayList<>(), nums);
        return res;
    }
    private void dfs(List<List<Integer>> res, List<Integer> sublist, int[] nums){
        if(sublist.size() == nums.length){
            res.add(new ArrayList<>(sublist));
            return;
        }
        for(int i = 0; i < nums.length; i++){
            if(sublist.contains(nums[i])) continue;
            sublist.add(nums[i]);
            dfs(res, sublist, nums);
            sublist.remove(sublist.size() - 1);
        }
    }
}
