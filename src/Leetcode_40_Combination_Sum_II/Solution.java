package Leetcode_40_Combination_Sum_II;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        Arrays.sort(candidates);
        helper(ans, candidates, target, 0, cur);
        return ans;
    }
    private void helper(List<List<Integer>> ans, int[] candidates, int target, int i, List<Integer> cur){
        if(target < 0) return;
        if(target == 0){
            ans.add(new ArrayList<>(cur));
            return;
        }
        for(int j = i; j < candidates.length; j++){
            if(j > i && candidates[j] == candidates[j - 1]) continue;
            cur.add(candidates[j]);
            helper(ans, candidates, target - candidates[j], j + 1, cur);
            cur.remove(cur.size() - 1);
        }
    }
}
