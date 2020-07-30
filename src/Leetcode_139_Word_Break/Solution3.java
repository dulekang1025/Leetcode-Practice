package Leetcode_139_Word_Break;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution3 {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>(wordDict);
        int n = s.length();
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;
        for(int i = 0; i < n; i++){
            for(String word : wordDict){
                int j = i + word.length();
                if(j <= n && dp[i] && set.contains(s.substring(i,j))){
                    dp[j] = true;
                }
            }
        }
        return dp[n];
    }
}
