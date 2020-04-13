package Leetcode_525_Contiguous_Array;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int findMaxLength(int[] nums) {
        int max = 0;
        int count = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        for(int i = 0; i< nums.length; i++){
            if(nums[i] == 0) count += -1;
            else count += 1;
            if(!map.containsKey(count)) map.put(count, i);
            else max = max > i - map.get(count) ? max : i - map.get(count);
        }
        return max;
    }
}
