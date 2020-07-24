package Leetcode_797_All_Paths_From_Source_to_Target;

import java.util.ArrayList;
import java.util.List;

public class Solution2 {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        int target = graph.length - 1;
        dfs(graph, 0, target, new ArrayList<>());
        return res;
    }
    private void dfs(int[][] graph, int cur, int target, List<Integer> list){
        if(cur == target){
            list.add(cur);
            res.add(new ArrayList<>(list));
            list.remove(list.size() - 1);
            return;
        }
        list.add(cur);
        for(int next : graph[cur]){
            if(list.contains(next)) continue;
            dfs(graph, next, target, list);
        }
        list.remove(list.size() - 1);
    }
}
