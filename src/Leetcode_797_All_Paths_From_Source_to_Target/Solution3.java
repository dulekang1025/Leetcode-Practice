package Leetcode_797_All_Paths_From_Source_to_Target;

import java.util.ArrayList;
import java.util.List;

public class Solution3 {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        int target = graph.length - 1;
        List<Integer> list = new ArrayList<>();
        list.add(0);
        dfs(graph, 0, target, list);
        return res;
    }
    private void dfs(int[][] graph, int cur, int target, List<Integer> list){
        if(cur == target){
            res.add(new ArrayList<>(list));
            return;
        }
        for(int next : graph[cur]){
            if(list.contains(next)) continue;
            list.add(next);
            dfs(graph, next, target, list);
            list.remove(list.size() - 1);
        }
    }
}
