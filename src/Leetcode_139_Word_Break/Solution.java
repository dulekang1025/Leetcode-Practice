package Leetcode_139_Word_Break;

import java.util.*;

class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>(wordDict);
        Map<Integer, Boolean> map = new HashMap<>();
        return dfs(s, set, map, 0);
    }
    private boolean dfs(String s, Set<String> set, Map<Integer, Boolean> map, int start){
        if(start == s.length()) return true;
        if(map.containsKey(start)) return map.get(start);
        for(int end = start + 1; end <= s.length(); end++){
            if(set.contains(s.substring(start, end))){
                if(dfs(s, set, map, end)){
                    System.out.println(end);
                    map.put(start, true);
                    return true;
                }
            }
        }
        map.put(start, false);
        return false;
    }
}
