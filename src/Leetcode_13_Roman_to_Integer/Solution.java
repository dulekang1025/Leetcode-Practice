package Leetcode_13_Roman_to_Integer;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int romanToInt(String s) {
        int ans = 0;
        char prev = '0';
        Map<Character, Integer> map = new HashMap<>(){{
            put('I', 1); put('V', 5); put('X', 10); put('L', 50);
            put('C', 100); put('D', 500); put('M', 1000);
        }};
        for(int i = 0; i < s.length(); i++){
            char cur = s.charAt(i);
            ans += map.get(cur);
            if(prev != '0' && map.get(cur) > map.get(prev)){
                ans -= 2 * map.get(prev);
            }
            prev = cur;
        }
        return ans;
    }
}
