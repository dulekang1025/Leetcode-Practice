package Leetcode_1464_Maximum_Product_of_Two_Elements_in_an_Array;

import java.util.Arrays;

class Solution {
    public int maxProduct(int[] nums) {
        Arrays.sort(nums);
        int ans = (nums[nums.length - 1] - 1) * (nums[nums.length - 2] - 1);
        return ans;
    }
}
