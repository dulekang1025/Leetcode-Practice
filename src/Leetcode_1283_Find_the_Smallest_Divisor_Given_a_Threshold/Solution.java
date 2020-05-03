package Leetcode_1283_Find_the_Smallest_Divisor_Given_a_Threshold;

class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        // first, find divisor's range, should not be greater than the largest number in array
        int high = Integer.MIN_VALUE;
        int low = 1;
        int mid = 0;
        for(int n : nums) high = Math.max(high, n);
        while(low < high){
            mid = low + (high - low) / 2;
            int sum = 0;
            for(int n : nums){
                sum += n / mid + (n % mid == 0 ? 0 : 1);
            }
            if(sum > threshold) low = mid + 1;
            else high = mid;
        }
        return low;
    }
}
