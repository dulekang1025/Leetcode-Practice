package Leetcode_47_Permutations_II;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> visited = new ArrayList<>();
        dfs(res, new ArrayList<>(), nums, visited);
        return res;
    }
    private void dfs(List<List<Integer>> res, List<Integer> sublist, int[] nums, List<Integer> visited){
        if(sublist.size() == nums.length && !res.contains(sublist)){
            res.add(new ArrayList<>(sublist));
            return;
        }
        for(int i = 0; i < nums.length; i++){
            if(visited.contains(i)) continue;
            sublist.add(nums[i]);
            visited.add(i);
            dfs(res, sublist, nums, visited);
            sublist.remove(sublist.size() - 1);
            visited.remove(visited.indexOf(i));
        }
    }
}
