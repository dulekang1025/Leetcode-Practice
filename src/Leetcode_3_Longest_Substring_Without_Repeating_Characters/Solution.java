package Leetcode_3_Longest_Substring_Without_Repeating_Characters;

import java.util.HashMap;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character,Integer> map = new HashMap<>();
        int Longest = 0;
        for(int i=0,j=0; i < s.length(); i++){
            if(map.containsKey(s.charAt(i))){
                j = Math.max(j,map.get(s.charAt(i)) + 1);
                // j = map.get(s.charAt(i)) + 1;
            }
            map.put(s.charAt(i),i);
            Longest = Math.max(Longest,i - j + 1);
        }
        return Longest;
    }
}