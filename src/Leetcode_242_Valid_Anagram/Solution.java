package Leetcode_242_Valid_Anagram;

public class Solution {
    public boolean isAnagram(String s, String t) {
        int s1 = s.length();
        int s2 = t.length();
        int[] ans = new int[26];
        if(s1 != s2) return false;
        for(int i = 0; i < s1; i++) ans[s.charAt(i) - 'a']++;
        for(int i = 0; i < s2; i++){
            if((--ans[t.charAt(i) - 'a']) < 0) return false;
        }
        return true;
    }
}
