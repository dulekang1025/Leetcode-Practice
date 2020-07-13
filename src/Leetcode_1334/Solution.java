package Leetcode_1334;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int[][] g = new int[n][n];
        for(int[] e : edges){
            g[e[0]][e[1]] = e[2];
            g[e[1]][e[0]] = e[2];
        }
        Queue<int[]> ans = new PriorityQueue<>((a, b) -> a[1] == b[1] ? b[0] - a[0] : a[1] - b[1]);
        for(int i = 0; i < n; i++){
            int[] visited = new int[n];
            int[] dest = new int[n];
            Arrays.fill(dest, Integer.MAX_VALUE);
            dest[i] = 0;
            Queue<Integer> heap = new PriorityQueue<>((a, b) -> dest[a] - dest[b]);
            heap.add(i);
            while(!heap.isEmpty()){
                int cur = heap.poll();
                visited[cur] = 1;
                for(int k = 0; k < n; k++){
                    if(g[cur][k] > 0 && visited[k] == 0 && dest[k] > g[cur][k] + dest[cur]){
                        dest[k] = g[cur][k] + dest[cur];
                        heap.offer(k);
                    }
                }
            }
            int count = -1;
            for(int k = 0; k < n; k++){
                if(dest[k] <= distanceThreshold)
                    count++;
            }
            ans.offer(new int[]{i, count});
        }
        return ans.poll()[0];
    }
}
