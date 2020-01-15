package Leetcode_684_Redundant_Connection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

public class Solution2 {
    public int[] findRedundantConnection(int[][] edges) {
        int[] res = null;
        HashMap<Integer, LinkedList<Integer>> graph = new HashMap<>();
        for(int[] e : edges){
            int u = e[0];
            int v = e[1];
            ArrayList<Integer> visited = new ArrayList<>();
            if(helper(u,v,graph, visited)) res = e;
            else{
                if(!graph.containsKey(u)){
                    graph.put(u, new LinkedList<Integer>());
                }
                graph.get(u).add(v);
                if(!graph.containsKey(v)){
                    graph.put(v, new LinkedList<Integer>());
                }
                graph.get(v).add(u);
            }
        }
        return res;
    }
    private boolean helper(int u, int v, HashMap<Integer, LinkedList<Integer>> graph, ArrayList<Integer> visited){
        if(!graph.containsKey(u) || !graph.containsKey(v)) return false;
        if(u == v) return true;
        visited.add(u);
        for(int ne : graph.get(u)){
            if(!visited.contains(ne)){
                visited.add(ne);
                if(helper(ne,v,graph,visited)) return true;
            }
        }
        return false;
    }
}
