package Leetcode_3_Longest_Substring_Without_Repeating_Characters;

import java.util.HashSet;
import java.util.Set;

public class Solution4 {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int len = s.length();
        int left = 0, right = 0;
        int max = 0;
        while(right < len){
            while(right < len && !set.contains(s.charAt(right))){
                set.add(s.charAt(right));
                right++;
            }
            max = Math.max(max, right - left);
            while(right < len && left < right && set.contains(s.charAt(right))){
                set.remove(s.charAt(left));
                left++;
            }
        }
        return max;
    }
}
