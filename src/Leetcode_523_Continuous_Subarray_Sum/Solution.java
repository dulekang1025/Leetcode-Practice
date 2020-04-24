package Leetcode_523_Continuous_Subarray_Sum;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        int sum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0,-1); // (sum mod k, position)
        for(int i = 0; i < nums.length; i++){
            sum += nums[i];
            int t = k == 0 ? sum : sum % k;
            if(map.containsKey(t) && i - map.get(t) > 1) return true;
            map.putIfAbsent(t, i);
        }
        return false;
    }
}
