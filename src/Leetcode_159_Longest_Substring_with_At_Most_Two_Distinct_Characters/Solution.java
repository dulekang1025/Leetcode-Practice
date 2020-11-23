package Leetcode_159_Longest_Substring_with_At_Most_Two_Distinct_Characters;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        int len = s.length();
        if(len <= 2) return len;
        int max = 0;
        Map<Character, Integer> map = new HashMap<>();
        int l = 0, r = 0;
        while(r < len){
            map.put(s.charAt(r), map.getOrDefault(s.charAt(r), 0) + 1);
            while(map.size() > 2){
                char c = s.charAt(l);
                if(map.containsKey(c)){
                    if(map.get(c) == 1){
                        map.remove(c);
                    }else{
                        map.put(c, map.get(c) - 1);
                    }
                }
                l++;
            }
            //eceba
            max = Math.max(max, r - l + 1);
            r++;
        }
        return max;
    }
}
