package Leetcode_91_Decode_Ways;

public class Solution {
    public int numDecodings(String s) {
        if(s == null || s.length() == 0 || s.charAt(0) == '0')
            return 0;
        int[] dp = new int[s.length() + 1];
        dp[0] = 1;
        dp[1] = 1;

        for(int i = 2; i < dp.length; i++) {
            int num = Integer.parseInt(s.substring(i - 2, i));
            int twoStepsBehind = (num <= 26 && num >= 10) ? dp[i - 2] : 0;
            int oneStepBehind = s.charAt(i - 1) != '0' ? dp[i - 1] : 0;
            dp[i] = twoStepsBehind + oneStepBehind;
        }

        return dp[s.length()];
    }
}
