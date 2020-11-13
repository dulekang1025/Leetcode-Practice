package Leetcode_47_Permutations_II;

import java.util.*;

public class Solution3 {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        helper(nums, new ArrayList<>(), new HashSet<>());
        return res;
    }
    private void helper(int[] nums, List<Integer> list, Set<Integer> set){
        if(list.size() == nums.length){
            res.add(new ArrayList<>(list));
            return;
        }
        for(int i = 0; i < nums.length; i++){
            if(set.contains(i)) continue;
            set.add(i);
            list.add(nums[i]);
            helper(nums, list, set);
            set.remove(i);
            list.remove(list.size() - 1);
            while(i < nums.length - 1 && nums[i] == nums[i + 1]){
                i++;
            }
        }
    }
}
