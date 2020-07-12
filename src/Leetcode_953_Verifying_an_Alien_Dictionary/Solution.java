package Leetcode_953_Verifying_an_Alien_Dictionary;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        if(words.length == 1) return true;
        Map<Character, Integer> map = new HashMap<>();
        int k = 0;
        for(char c : order.toCharArray()){
            map.put(c, k++);
        }
        for(int i = 1; i < words.length; i++){
            if(!compare(words[i - 1], words[i], map))
                return false;
        }
        return true;
    }
    private boolean compare(String s1, String s2, Map<Character, Integer> map){
        int i = 0, j = 0;
        while(i < s1.length() && j < s2.length()){
            if(map.get(s1.charAt(i)) < map.get(s2.charAt(j)))
                return true;
            if(map.get(s1.charAt(i)) > map.get(s2.charAt(j)))
                return false;
            i++;
            j++;
        }
        if(s1.length() > s2.length())
            return false;
        return true;
    }
}
