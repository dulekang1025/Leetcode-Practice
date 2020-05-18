package Leetcode_3_Longest_Substring_Without_Repeating_Characters;

import java.util.HashMap;
import java.util.Map;

class Solution2 {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> window = new HashMap<>();
        int right = 0;
        int left = 0;
        int len = 0;
        while(right < s.length()){
            char a = s.charAt(right);
            right++;
            window.put(a, window.getOrDefault(a, 0) + 1);
            //System.out.println(a);
            while(window.get(a) > 1){
                char b = s.charAt(left);
                left++;
                window.put(b, window.get(b) - 1);
            }
            len = right - left > len ? right - left : len;
        }
        return len;
    }
}
