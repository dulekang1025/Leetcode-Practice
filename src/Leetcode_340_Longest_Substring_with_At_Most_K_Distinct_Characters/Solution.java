package Leetcode_340_Longest_Substring_with_At_Most_K_Distinct_Characters;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        int len = s.length();
        int max = 0;
        Map<Character, Integer> map = new HashMap<>();
        int l = 0, r = 0;
        while(r < len){
            map.put(s.charAt(r), map.getOrDefault(s.charAt(r), 0) + 1);
            while(map.size() > k){
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
