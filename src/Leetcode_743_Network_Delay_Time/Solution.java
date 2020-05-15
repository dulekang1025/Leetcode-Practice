package Leetcode_743_Network_Delay_Time;

import java.util.*;

class Solution {
    public int networkDelayTime(int[][] times, int N, int K) {
        Map<Integer, List<int[]>> graph = new HashMap<>();
        for(int[] e : times){
            int s = e[0];
            int t = e[1];
            int w = e[2];
            if(!graph.containsKey(s)){
                graph.put(s, new ArrayList<>());
            }
            if(!graph.containsKey(t)){
                graph.put(t, new ArrayList<>());
            }
            graph.get(s).add(new int[]{t, w});
        }
        Queue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        Map<Integer, Integer> visited = new HashMap<>();
        pq.add(new int[]{0, K});
        while(!pq.isEmpty()){
            int[] cur = pq.poll();
            int distance = cur[0];
            int node = cur[1];
            if(visited.containsKey(node))
                continue;
            visited.put(node, distance);
            for(int[] neighbor : graph.get(node)){
                int nei = neighbor[0];
                int weight = neighbor[1];
                if(!visited.containsKey(nei))
                    pq.add(new int[]{distance + weight, nei});
            }
        }
        int ans = -1;
        for(int i : visited.values()){
            ans = Math.max(ans, i);
        }
        return visited.size() != N ? -1 : ans;
    }
}
