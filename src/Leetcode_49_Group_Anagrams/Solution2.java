package Leetcode_49_Group_Anagrams;

import java.util.ArrayList;
import java.util.List;

public class Solution2 {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        for(int i = 0; i < strs.length; i++){
            if(strs[i].equals("!@_@!")) continue;
            List<String> l = new ArrayList<>();
            l = helper(i, l, strs);
            res.add(l);
        }
        return res;
    }
    private List<String> helper(int i, List<String> l, String[] strs){
        String temp = strs[i];
        l.add(strs[i]);
        strs[i] = "!@_@!";
        i += 1;
        for(; i < strs.length; i++){
            if(strs[i].equals("!@_@!")) continue;
            if(ana(temp, strs[i])) {
                l.add(strs[i]);
                strs[i] = "!@_@!";
            }
        }
        return l;
    }
    private boolean ana(String s, String t){
        int s1 = s.length();
        int s2 = t.length();
        if(s1 != s2) return false;
        int[] ans = new int[26];
        for(int i = 0; i < s.length(); i++) ++ans[s.charAt(i) - 'a'];
        for(int i = 0; i < t.length(); i++){
            if(--ans[t.charAt(i) - 'a'] < 0) return false;
        }
        return true;
    }
}
