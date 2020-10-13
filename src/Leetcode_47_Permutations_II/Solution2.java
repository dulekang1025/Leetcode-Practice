package Leetcode_47_Permutations_II;

import java.util.*;

class Solution2 {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        Set<Integer> set = new HashSet<>();
        dfs(nums, set, new ArrayList<>(), 0);
        return res;
    }
    private void dfs(int[] nums, Set<Integer> set, List<Integer> list, int index){
        if(list.size() == nums.length){
            res.add(new ArrayList<>(list));
            return;
        }
        for(int i = 0; i < nums.length; i++){
            if(i > 0 && nums[i] == nums[i - 1] && !set.contains(i - 1)) continue;
            if(set.contains(i)) continue;
            list.add(nums[i]);
            set.add(i);
            dfs(nums, set, list, i + 1);
            list.remove(list.size() - 1);
            set.remove(i);
        }
    }
}
