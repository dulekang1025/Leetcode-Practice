package Leetcode_1443_Minimum_Time_to_Collect_All_Apples_in_a_Tree;

import java.util.*;

class Solution {
    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        Map<Integer, List<Integer>> g = new HashMap<>();
        for(int[] e : edges){
            g.putIfAbsent(e[0], new ArrayList<>());
            g.putIfAbsent(e[1], new ArrayList<>());
            g.get(e[0]).add(e[1]);
            g.get(e[1]).add(e[0]);
        }
        Set<Integer> set = new HashSet<>();
        return dfs(g, hasApple, set, 0);
    }
    private int dfs(Map<Integer, List<Integer>> g, List<Boolean> hasApple, Set<Integer> set, int cur){
        int total = 0;
        if(g.get(cur) == null) return total;
        set.add(cur);
        for(int n : g.get(cur)){
            if(set.contains(n)) continue;
            int cost = dfs(g, hasApple, set, n);
            if(cost > 0 || hasApple.get(n)){
                total += cost + 2;
            }
        }
        return total;
    }
}
