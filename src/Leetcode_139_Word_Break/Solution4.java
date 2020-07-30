package Leetcode_139_Word_Break;

import java.util.*;

class Solution4 {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>(wordDict);
        Map<String, Boolean> map = new HashMap<>();
        return dfs(s, set, map);
    }
    public boolean dfs(String s, Set<String> set, Map<String, Boolean> map){
        if(map.containsKey(s)) return map.get(s);
        if(set.contains(s)){
            map.put(s, true);
            return map.get(s);
        }
        for(int i = 1; i < s.length(); i++){
            if(set.contains(s.substring(0, i)) && dfs(s.substring(i, s.length()), set, map)){
                map.put(s, true);
                return map.get(s);
            }
        }
        map.put(s, false);
        return map.get(s);
    }
}
