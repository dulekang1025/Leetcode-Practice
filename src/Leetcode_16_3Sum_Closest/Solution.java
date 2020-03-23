package Leetcode_16_3Sum_Closest;

import java.util.Arrays;

class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int closest = nums[0] + nums[1] + nums[2];
        int diff = Math.abs(target - closest);
        Arrays.sort(nums);
        for(int i = 0; i < nums.length - 2; i++){
            int low = i + 1;
            int high = nums.length - 1;
            while(low < high){
                int sum = nums[i] + nums[low] + nums[high];
                int tempDiff = Math.abs(target - sum);
                if(tempDiff < diff) {
                    diff = tempDiff;
                    closest = sum;
                }
                if(sum > target){
                    high--;
                }else{
                    low++;
                }
            }
        }
        return closest;
    }
}
