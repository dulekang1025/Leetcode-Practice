package Leetcode_152_Maximum_Product_Subarray;

class Solution2 {
    public int maxProduct(int[] nums) {
        if(nums.length == 0) return 0;
        if(nums.length == 1) return nums[0];
        int max = nums[0];
        int imax = nums[0];
        int imin = nums[0];
        for(int i = 1; i < nums.length; i++){
            int curMax = imax * nums[i];
            int curMin = imin * nums[i];
            imax = Math.max(curMax, Math.max(nums[i], curMin));
            imin = Math.min(curMin, Math.min(nums[i], curMax));
            max = Math.max(max, imax);
        }
        return max;
    }
}
