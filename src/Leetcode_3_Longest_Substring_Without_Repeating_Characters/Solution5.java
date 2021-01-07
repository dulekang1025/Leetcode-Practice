package Leetcode_3_Longest_Substring_Without_Repeating_Characters;

import java.util.HashSet;
import java.util.Set;

public class Solution5 {
    public int lengthOfLongestSubstring(String s) {
        if(s == null || s.length() == 0) return 0;
        int left = 0, right = 0, max = 1;
        Set<Character> set = new HashSet<>();
        char[] arr = s.toCharArray();
        while(right < s.length()){
            if(set.contains(arr[right])){
                while(set.contains(arr[right])){
                    set.remove(arr[left]);
                    left++;
                }
            }
            max = Math.max(max, right - left + 1);
            set.add(arr[right]);
            right++;
        }
        return max;
    }
}
