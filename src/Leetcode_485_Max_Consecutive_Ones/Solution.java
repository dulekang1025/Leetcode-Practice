package Leetcode_485_Max_Consecutive_Ones;

class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int sum = 0;
        int max = 0;
        for(int n : nums){
            if(n == 1){
                sum += 1;
                max = Math.max(max, sum);
            }else{
                sum = 0;
            }
        }
        return max;
    }
}
