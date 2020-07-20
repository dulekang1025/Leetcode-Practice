package Leetcode_395_Longest_Substring_with_At_Least_K_Repeating_Characters;

class Solution {
    public int longestSubstring(String s, int k) {
        int len = s.length();
        if(len == 0 || len < k) return 0;
        return helper(s.toCharArray(), k, 0, len - 1);
    }
    private int helper(char[] s, int k, int left, int right){
        //System.out.println(left + " " + right);
        if(right - left + 1 < k) return 0;
        int[] count = new int[26];
        for(int i = left; i <= right; i++){
            count[s[i] - 'a']++;
        }
        for(int i = left; i <= right; i++){
            if(count[s[i] - 'a'] < k){
                return Math.max(helper(s, k, left, i - 1), helper(s, k, i + 1, right));
            }
        }
        return right - left + 1;
    }
}

