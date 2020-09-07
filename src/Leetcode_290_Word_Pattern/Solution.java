package Leetcode_290_Word_Pattern;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public boolean wordPattern(String pattern, String str) {
        int n = pattern.length();
        String[] arr = str.split(" ");
        if(n != arr.length) return false;
        Map<Character, String> cToS = new HashMap<>();
        Map<String, Character> sToC = new HashMap<>();
        for(int i = 0; i < n; i++){
            if(cToS.containsKey(pattern.charAt(i))){
                if(!cToS.get(pattern.charAt(i)).equals(arr[i])){
                    return false;
                }
            }else{
                if(sToC.containsKey(arr[i])){
                    return false;
                }else{
                    cToS.put(pattern.charAt(i), arr[i]);
                    sToC.put(arr[i], pattern.charAt(i));
                }
            }
        }
        return true;
    }
}
