package Leetcode_1509;

import java.util.Arrays;

class Solution {
    public int minDifference(int[] nums) {
        int res = Integer.MAX_VALUE;
        if(nums.length < 5) return 0;
        Arrays.sort(nums);
        //for(int n : nums) System.out.print(n + " ");
        //System.out.println();
        for(int i = 0; i < 4; i++){
            res = Math.min(res, nums[nums.length - 1 - (3 - i)] - nums[i]);
            //System.out.println(res + " " + nums[i] + " " + nums[nums.length - 1 - (3 - i)]);
        }
        return res;
    }
}
