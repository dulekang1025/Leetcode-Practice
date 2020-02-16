package Leetcode_387_First_Unique_Character_in_a_String;

import java.util.HashMap;

class Solution {
    public int firstUniqChar(String s) {
        HashMap<Character,Integer> map = new HashMap<>();
        for(int i = 0; i < s.length(); i++){
            if(!map.containsKey(s.charAt(i))){
                map.put(s.charAt(i), 1);
            }else{
                int temp = map.get(s.charAt(i)) + 1;
                map.put(s.charAt(i), temp);
            }
        }
        for(int i = 0; i < s.length(); i++){
            if(map.get(s.charAt(i)) == 1) return i;
        }
        return -1;
    }
}
