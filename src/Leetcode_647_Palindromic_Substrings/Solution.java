package Leetcode_647_Palindromic_Substrings;

class Solution {
    public int countSubstrings(String s) {
        if(s.equals("")) return 0;
        int len = s.length();
        int start = 0;
        int maxLen = 1;
        int res = 0;
        boolean[][] dp = new boolean[len][len];
        // length == 1;
        for(int i = 0; i < len; i++){
            dp[i][i] = true;
            res++;
        }
        //length == 2;
        for(int i = 0; i < len - 1; i++){
            int j = i + 1;
            if(s.charAt(i) == s.charAt(j)){
                dp[i][j] = true;
                res++;
            }
        }
        // length >= 3;
        for(int k = 3; k <= len; k++){
            for(int i = 0; i < len - k + 1; i++){
                int j = i + k - 1;
                if(dp[i + 1][j - 1] && s.charAt(i) == s.charAt(j)){
                    dp[i][j] = true;
                    res++;
                }
            }
        }
        return res;
    }
}
