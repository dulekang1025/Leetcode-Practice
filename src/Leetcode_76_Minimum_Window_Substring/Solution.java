package Leetcode_76_Minimum_Window_Substring;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public String minWindow(String s, String t) {
        int left = 0;
        int right = 0;
        int len = Integer.MAX_VALUE;
        int start = 0;
        Map<Character, Integer> target = new HashMap<>();
        Map<Character, Integer> source = new HashMap<>();
        for(int i = 0; i < t.length(); i++){
            target.put(t.charAt(i), target.getOrDefault(t.charAt(i), 0) + 1);
        }
        int count = 0;
        while(right < s.length()){
            char add = s.charAt(right);
            right++;
            if(target.containsKey(add)){
                source.put(add, source.getOrDefault(add, 0) + 1);
                if(target.get(add).equals(source.get(add))){
                    count++;
                }
            }
            while(count == target.size()){
                if(right - left < len){
                    len = right - left;
                    start = left;
                }
                char delete = s.charAt(left);
                left++;
                if(target.getOrDefault(delete, 0) > 0){
                    if(source.get(delete).equals(target.get(delete)))
                        count--;
                    source.put(delete, source.get(delete) - 1);
                }
            }
        }
        return len == Integer.MAX_VALUE ? "" : s.substring(start, start + len);
    }
}
