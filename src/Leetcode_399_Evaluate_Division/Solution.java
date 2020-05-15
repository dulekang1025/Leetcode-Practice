package Leetcode_399_Evaluate_Division;

import java.util.*;

class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, Map<String, Double>> graph = new HashMap<>();
        buildGraph(equations, values, graph);
        double[] res = new double[queries.size()];
        Arrays.fill(res, -1.0);
        for(int i = 0; i < queries.size(); i++){
            String a = queries.get(i).get(0);
            String b = queries.get(i).get(1);
            Set<String> visited = new HashSet<>();
            if(!graph.containsKey(a) ||!graph.containsKey(b))
                continue;
            res[i] = dfs(a, b, graph, visited, 1.0);
        }
        return res;
    }
    private double dfs(String a, String b, Map<String, Map<String, Double>> graph, Set<String> visited, double temp){
        visited.add(a);
        //System.out.println(a);
        if(graph.get(a).containsKey(b))
            return temp * graph.get(a).get(b);
        if(graph.get(a).size() == 0)
            return -1.0;
        double ans = -1.0;
        for(String cur : graph.get(a).keySet()){
            if(visited.contains(cur))
                continue;
            double tmp = graph.get(a).get(cur);
            ans = dfs(cur, b, graph, visited, tmp * temp);
            if(ans != -1.0) break;
        }
        return ans;
    }
    private void buildGraph(List<List<String>> equations, double[] values, Map<String, Map<String, Double>> graph){
        for(int i = 0; i < equations.size(); i++){
            List<String> list = equations.get(i);
            String a = list.get(0);
            String b = list.get(1);
            graph.putIfAbsent(a, new HashMap<>());
            graph.putIfAbsent(b, new HashMap<>());
            graph.get(a).put(b, values[i]);
            graph.get(b).put(a, 1.0 / values[i]);
            graph.get(a).put(a, 1.0);
            graph.get(b).put(b, 1.0);
        }
    }
}

