package Leetcode_220_Contains_Duplicate_III;

import java.util.TreeSet;

class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        TreeSet<Integer> set = new TreeSet<>();
        for(int i = 0; i < nums.length; i++){
            Integer ceil = set.ceiling(nums[i]);
            if(ceil != null && ceil <= t + nums[i]) return true;
            Integer floor = set.floor(nums[i]);
            if(floor != null && nums[i] <= t + floor) return true;
            set.add(nums[i]);
            if(set.size() > k){
                set.remove(nums[i - k]);
            }
        }
        return false;
    }
}
