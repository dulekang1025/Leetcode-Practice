package Leetcode_785_Is_Graph_Bipartite;

import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public boolean isBipartite(int[][] graph) {
        int[] visited = new int[graph.length];
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < graph.length; i++){
            if(visited[i] != 0)
                continue;
            queue.add(i);
            visited[i] = 1;
            while(!queue.isEmpty()){
                int cur = queue.poll();
                int neiLabel = visited[cur] == 1 ? 2 : 1;
                for(int n : graph[cur]){
                    if(visited[n] == 0){
                        visited[n] = neiLabel;
                        queue.add(n);
                    }else{
                        if(visited[n] != neiLabel)
                            return false;
                    }
                }
            }
        }
        return true;
    }
}
