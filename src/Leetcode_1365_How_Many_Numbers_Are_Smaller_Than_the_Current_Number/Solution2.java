package Leetcode_1365_How_Many_Numbers_Are_Smaller_Than_the_Current_Number;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution2 {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] ans = new int[nums.length];
        int[] copy = Arrays.copyOf(nums, nums.length);
        Arrays.sort(copy);
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = copy.length - 1; i >= 0; i--){
            map.put(copy[i], i);
        }
        for(int i = 0; i < nums.length; i++){
            ans[i] = map.get(nums[i]);
        }
        return ans;
    }
}
