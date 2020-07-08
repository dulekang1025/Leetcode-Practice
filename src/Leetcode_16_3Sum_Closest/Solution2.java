package Leetcode_16_3Sum_Closest;

import java.util.Arrays;

public class Solution2 {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int ans = nums[0] + nums[1] + nums[2];
        int diff = Math.abs(target - ans);
        for(int i = 0; i < nums.length - 2; i++){
            int low = i + 1;
            int high = nums.length - 1;
            while(low < high){
                int left = nums[low];
                int right = nums[high];
                int cur = nums[i] + left + right;
                int curDiff = Math.abs(target - cur);
                if(diff > curDiff){
                    diff = curDiff;
                    ans = cur;
                }
                if(cur > target){
                    while(low < high && nums[high] == right) high--;  // remove duplication
                }else if(cur < target){
                    while(low < high && nums[low] == left) low++;  // remove duplication
                }else{
                    return cur;
                }
            }
        }
        return ans;
    }
}
