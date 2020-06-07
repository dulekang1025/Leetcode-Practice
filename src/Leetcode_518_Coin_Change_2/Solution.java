package Leetcode_518_Coin_Change_2;

class Solution {
    public int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for(int coin : coins){
            for(int i = 1; i < amount + 1; i++){
                int subProblem = i - coin;
                if(subProblem < 0) continue;
                dp[i] += dp[subProblem];
            }
        }
        return dp[amount];
    }
}
