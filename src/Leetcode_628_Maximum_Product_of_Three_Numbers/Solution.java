package Leetcode_628_Maximum_Product_of_Three_Numbers;

import java.util.Arrays;

class Solution {
    public int maximumProduct(int[] nums) {
        int len = nums.length;
        Arrays.sort(nums);
        int max1 = nums[0] * nums[1] * nums[len - 1];
        int max2 = nums[len - 1] * nums[len - 2] * nums[len - 3];
        return Math.max(max1, max2);
    }
}
