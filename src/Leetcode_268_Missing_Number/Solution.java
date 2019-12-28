package Leetcode_268_Missing_Number;

class Solution {
    public int missingNumber(int[] nums) {
        int largest = nums.length;
        int t = (largest * (1 + largest)) / 2;
        for(int i : nums){
            t -= i;
        }
        return t;
    }
}
