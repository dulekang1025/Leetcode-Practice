package Leetcode_209_Minimum_Size_Subarray_Sum;

class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        // s = 7, nums = [2,3,1,2,4,3]
        int l = 0;
        int r = 0;
        int sum = 0;
        int min = Integer.MAX_VALUE;
        while(r < nums.length){
            while(sum < s && r < nums.length){
                sum += nums[r];
                r++;
            }
            while(sum >= s){
                System.out.println(l + " " + r);
                min = Math.min(min, r - l);
                sum -= nums[l];
                l++;
            }

        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }
}
