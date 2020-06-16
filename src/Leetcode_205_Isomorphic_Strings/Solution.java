package Leetcode_205_Isomorphic_Strings;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public boolean isIsomorphic(String s, String t) {
        return helper(s, t) && helper(t, s);
    }
    private boolean helper(String s, String t){
        Map<Character, Character> map = new HashMap<>();
        for(int i = 0; i < s.length(); i++){
            if(!map.containsKey(s.charAt(i))){
                map.put(s.charAt(i), t.charAt(i));
            }else{
                if(map.get(s.charAt(i)) != t.charAt(i))
                    return false;
            }
        }
        return true;
    }
}
