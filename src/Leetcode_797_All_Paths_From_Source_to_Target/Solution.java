package Leetcode_797_All_Paths_From_Source_to_Target;

import java.util.*;

class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        Map<Integer, Set<Integer>> g = new HashMap<>();
        int target = graph.length - 1;
        for(int i = 0; i < graph.length; i++){
            g.putIfAbsent(i, new HashSet<>());
            int[] l = graph[i];
            for(int n : l){
                g.get(i).add(n);
            }
        }
        dfs(g, 0, target, new ArrayList<>());
        return res;
    }
    private void dfs(Map<Integer, Set<Integer>> g, int cur, int target, List<Integer> list){
        if(cur == target){
            list.add(cur);
            res.add(new ArrayList(list));
            list.remove(list.size() - 1);
            return;
        }
        Set<Integer> neis = g.get(cur);
        list.add(cur);
        for(int n : neis){
            if(list.contains(n)) continue;
            dfs(g, n, target, list);
        }
        list.remove(list.size() - 1);
        return;
    }
}
