package Leetcode_787_Cheapest_Flights_Within_K_Stops;

import java.util.PriorityQueue;
import java.util.Queue;

public class Solution2 {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        int[][] graph = new int[n][n];
        for(int[] f : flights){
            graph[f[0]][f[1]] = f[2];
        }
        Queue<int[]> heap = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        heap.add(new int[]{0, src, K + 1});
        while(!heap.isEmpty()){
            int[] cur = heap.poll();
            int cost = cur[0];
            int place = cur[1];
            int stops = cur[2];
            if(place == dst) return cost;
            if(stops > 0){
                for(int i = 0; i < n; i++){
                    if(graph[place][i] > 0){
                        heap.add(new int[]{cost + graph[place][i], i, stops - 1});
                    }
                }
            }
        }
        return -1;
    }
}
