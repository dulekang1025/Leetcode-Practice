package Leetcode_684_Redundant_Connection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        HashMap<Integer, LinkedList<Integer>> graph = new HashMap<>();
        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];
            List<Integer> visited = new ArrayList<>();   // caution!
            boolean isPath = dfs(u,v,graph,visited);

            if(isPath){
                return edge;
            }

            if(!graph.containsKey(u)){
                graph.put(u, new LinkedList<Integer>());
            }
            graph.get(u).add(v);

            if(!graph.containsKey(v)){
                graph.put(v, new LinkedList<Integer>());
            }
            graph.get(v).add(u);

        }
        return null;
    }
    public boolean dfs(int u, int v, HashMap<Integer, LinkedList<Integer>> graph, List<Integer> visited){
        if(!graph.containsKey(u) || !graph.containsKey(v)) return false;
        if(u == v) return true;
        visited.add(u);
        for(int z : graph.get(u)){
            if(!visited.contains(z)){
                if(dfs(z,v,graph,visited)) return true;    // here！
            }
        }
        return false;
    }
}
