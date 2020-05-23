package Leetcode_5_Longest_Palindromic_Substring;

class Solution2 {
    public String longestPalindrome(String s) {
        if(s.equals("")) return "";
        int len = s.length();
        char[] arr = s.toCharArray();
        boolean[][] dp = new boolean[len][len];
        int start = 0;
        int maxLen = 1;
        // lenght == 1
        for(int i = 0; i < len; i++){
            dp[i][i] = true;
        }
        //length == 2
        for(int i = 0; i < len - 1; i++){
            int j = i + 1;
            if(arr[i] == arr[j]){
                dp[i][j] = true;
                start = i;
                maxLen = 2;
            }
        }
        // length >= 3
        for(int k = 3; k <= len; k++){
            for(int i = 0; i < len - k + 1; i++){
                int j = i + k - 1;
                if(arr[i] == arr[j] && dp[i + 1][j - 1]){
                    dp[i][j] = true;
                    if(k > maxLen){
                        start = i;
                        maxLen = k;
                    }
                }
            }
        }
        return s.substring(start, start + maxLen);
    }
}
