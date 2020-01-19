package Leetcode_219_Contains_Duplicate_II;

import java.util.HashSet;
import java.util.Set;

public class Solution2 {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if(k == 0) return false;
        Set<Integer> win = new HashSet<>();
        for(int i = 0; i < nums.length; i++){
            if(win.contains(nums[i])) return true;
            if(i >= k) win.remove(nums[i - k]);
            win.add(nums[i]);
        }
        return false;
    }
}
