package Leetcode_389_Find_the_Difference;

import java.util.HashMap;
import java.util.Map;

public class Solution2 {
    public char findTheDifference(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();
        for(char c : s.toCharArray()){
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for(char c : t.toCharArray()){
            if(map.getOrDefault(c, 0) == 0){
                return c;
            }else{
                map.put(c, map.get(c) - 1);
            }
        }
        return ' ';
    }
}
// O(N)
