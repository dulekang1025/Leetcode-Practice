package Leetcode_1245_Tree_Diameter;

import java.util.*;

class Solution {
    Map<Integer, List<Integer>> g = new HashMap<>();
    Set<Integer> set = new HashSet<>();
    int depth = 0;
    Integer deepest = null;
    public int treeDiameter(int[][] edges) {
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < edges.length; i++){
            g.putIfAbsent(edges[i][0], new ArrayList<>());
            g.putIfAbsent(edges[i][1], new ArrayList<>());
            g.get(edges[i][0]).add(edges[i][1]);
            g.get(edges[i][1]).add(edges[i][0]);
        }
        dfs(0, 0);
        set.clear();
        dfs(deepest, 0);
        return depth;
    }
    private void dfs(int s, int d){
        set.add(s);
        if(d > depth){
            depth = d;
            deepest = s;
        }
        List<Integer> neis = g.get(s);
        for(int n : neis){
            if(!set.contains(n)){
                dfs(n, d + 1);
            }
        }
    }
}
