package Leetcode_409_Longest_Palindrome;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int longestPalindrome(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for(char c : s.toCharArray()){
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        int ans = 0;
        for(char k : map.keySet()){
            int v = map.get(k);
            ans += v / 2 * 2;
            if(v % 2 == 1 && ans % 2 == 0){
                ans++;
            }
        }
        return ans;
        
    }
}
