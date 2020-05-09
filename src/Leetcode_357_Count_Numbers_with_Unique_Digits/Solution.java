package Leetcode_357_Count_Numbers_with_Unique_Digits;

class Solution {
    public int countNumbersWithUniqueDigits(int n) {
        if(n == 0) return 1;
        if(n == 1) return 10;
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 10;
        dp[2] = 81;
        int sum = dp[1] + dp[2];
        for(int i = 3; i <= n; i++){
            dp[i] = dp[i - 1] * (10 - i + 1);
            sum += dp[i];
        }
        return sum;
    }
}
