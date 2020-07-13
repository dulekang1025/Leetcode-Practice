package Leetcode_1514_Path_with_Maximum_Probability;

import javafx.util.Pair;

import java.util.*;

class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        Map<Integer, Map<Integer, Double>> graph = new HashMap<>();
        for(int i = 0; i < edges.length; i++){
            int s = edges[i][0];
            int t = edges[i][1];
            double c = succProb[i];
            graph.putIfAbsent(s, new HashMap<>());
            graph.putIfAbsent(t, new HashMap<>());
            graph.get(s).put(t, c);
            graph.get(t).put(s, c);
        }
        if(!graph.containsKey(start) || !graph.containsKey(end)) return 0;
        Set<Integer> set = new HashSet<>();
        Queue<Pair<Integer, Double>> heap = new PriorityQueue<>((a, b) -> b.getValue() > a.getValue() ? 1 : -1);
        heap.add(new Pair<>(start, 1.0));
        while(!heap.isEmpty()){
            Pair<Integer, Double> pair = heap.poll();
            int cur = pair.getKey();
            if(cur == end) return pair.getValue();
            set.add(cur);
            Map<Integer, Double> neis = graph.get(cur);
            for(int key : neis.keySet()){
                if(set.contains(key)) continue;
                double curCost = neis.get(key) * pair.getValue();
                heap.offer(new Pair<>(key, curCost));
            }
        }
        return 0;
    }
}
