package Leetcode_332_Reconstruct_Itinerary;

import java.util.*;

class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String, Queue<String>> graph = new HashMap<>();
        for(List<String> ticket : tickets){
            String from = ticket.get(0);
            String to = ticket.get(1);
            graph.putIfAbsent(from, new PriorityQueue<>());
            graph.putIfAbsent(to, new PriorityQueue<>());
            graph.get(from).offer(to);
        }
        List<String> res = new ArrayList<>();
        dfs(graph, res, "JFK");
        return res;
    }
    private void dfs(Map<String, Queue<String>> graph, List<String> res, String from){
        Queue<String> arrivals = graph.get(from);
        while(!arrivals.isEmpty()){
            String to = arrivals.poll();
            dfs(graph, res, to);
        }
        res.add(0, from);
    }
}
