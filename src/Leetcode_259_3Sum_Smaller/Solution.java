package Leetcode_259_3Sum_Smaller;

import java.util.Arrays;

class Solution {
    public int threeSumSmaller(int[] nums, int target) {
        Arrays.sort(nums);
        int res = 0;
        for(int i = 0; i < nums.length; i++){
            int left = i + 1, right = nums.length - 1;
            while(left < right){
                int temp = nums[i] + nums[left] + nums[right];
                if(temp < target){
                    res += right - left;
                    left++;
                }else{
                    right--;
                }
            }
        }
        return res;
    }
}

