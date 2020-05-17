package Leetcode_567_Permutation_in_String;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public boolean checkInclusion(String t, String s) {
        int left = 0;
        int right = 0;
        Map<Character, Integer> win = new HashMap<>();
        Map<Character, Integer> tar = new HashMap<>();
        for(int i = 0; i < t.length(); i++){
            tar.put(t.charAt(i), tar.getOrDefault(t.charAt(i), 0) + 1);
        }
        //System.out.println(tar.size());
        int count = 0;
        while(right < s.length()){
            char a = s.charAt(right);
            right++;
            if(tar.containsKey(a)){
                win.put(a, win.getOrDefault(a, 0) + 1);
                if(win.get(a).equals(tar.get(a)))
                    count++;
            }

            while(right - left == t.length()){
                if(count == tar.size())
                    return true;
                char b = s.charAt(left);
                left++;
                if(tar.containsKey(b)){
                    if(win.get(b).equals(tar.get(b)))
                        count--;
                    win.put(b, win.get(b) - 1);
                }
            }
        }
        return false;
    }
}
