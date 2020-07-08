package Leetcode_1365_How_Many_Numbers_Are_Smaller_Than_the_Current_Number;

import java.util.Arrays;

class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] ans = new int[nums.length];
        int[] copy = Arrays.copyOf(nums, nums.length);
        Arrays.sort(nums);
        for(int i = 0; i< nums.length; i++){
            ans[i] = bs(nums, copy[i]);
        }
        return ans;
    }
    // find lower bound
    private int bs(int[] nums, int target){
        int res = 0;
        int low = 0, high = nums.length;
        while(low < high){
            int mid = low + (high - low) / 2;
            if(nums[mid] >= target) high = mid;
            else low = mid + 1;
        }
        return low;
    }
}
