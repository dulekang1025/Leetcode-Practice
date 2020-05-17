package Leetcode_438_Find_All_Anagrams_in_a_String;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        Map<Character, Integer> target = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();
        List<Integer> res = new ArrayList<>();
        for(int i = 0; i < p.length(); i++){
            target.put(p.charAt(i), target.getOrDefault(p.charAt(i), 0) + 1);
        }
        int left = 0;
        int right = 0;
        int start = 0;
        int count = 0;
        while(right < s.length()){
            char a = s.charAt(right);
            right++;
            if(target.containsKey(a)){
                window.put(a, window.getOrDefault(a, 0) + 1);
                if(window.get(a).equals(target.get(a)))
                    count++;
            }
            while(right - left == p.length()){
                if(count == target.size())
                    res.add(left);
                char b = s.charAt(left);
                left++;
                if(target.containsKey(b)){
                    if(window.get(b).equals(target.get(b)))
                        count--;
                    window.put(b, window.get(b) - 1);
                }
            }
        }
        return res;
    }
}