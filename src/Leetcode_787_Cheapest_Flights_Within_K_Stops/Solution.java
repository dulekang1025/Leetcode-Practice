package Leetcode_787_Cheapest_Flights_Within_K_Stops;

import java.util.*;

class Solution {
    int min = Integer.MAX_VALUE;
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        Map<Integer, Map<Integer, Integer>> graph = new HashMap<>();
        List<Integer> cost = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> curPath = new ArrayList<>();
        for(int[] flight : flights){
            int s = flight[0];
            int t = flight[1];
            int w = flight[2];
            graph.putIfAbsent(s, new HashMap<>());
            graph.get(s).put(t, w);
        }
        Set<Integer> visited = new HashSet<>();
        visited.add(src);
        dfs(graph, visited, 0, 0, src, dst, K);
        return min == Integer.MAX_VALUE ? -1 : min;
    }

    private void dfs(Map<Integer, Map<Integer, Integer>> graph, Set<Integer> visited, int curCost, int curK, int src, int dst, int K){
        if(src == dst){
            min = Math.min(min, curCost);
            return;
        }
        if(curK > K || curCost >= min)
            return;
        Map<Integer, Integer> temp = graph.get(src);
        if(temp == null) return;
        for(int t : temp.keySet()){
            if(visited.contains(t)) continue;
            visited.add(t);
            dfs(graph, visited, curCost + temp.get(t), curK + 1, t, dst, K);
            visited.remove(t);
        }
    }
}
