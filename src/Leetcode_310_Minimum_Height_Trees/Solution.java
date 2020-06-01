package Leetcode_310_Minimum_Height_Trees;

import java.util.*;

class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> res = new ArrayList<>();
        if(n == 1){
            res.add(0);
            return res;
        }
        Map<Integer, List<Integer>> graph = new HashMap<>();
        int[] degree = new int[n];
        for(int[] e : edges){
            graph.putIfAbsent(e[0], new ArrayList<>());
            graph.putIfAbsent(e[1], new ArrayList<>());
            graph.get(e[0]).add(e[1]);
            graph.get(e[1]).add(e[0]);
            degree[e[0]]++;
            degree[e[1]]++;
        }
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < degree.length; i++){
            if(degree[i] == 1){
                queue.offer(i);
            }
        }
        while(!queue.isEmpty()){
            int size = queue.size();
            List<Integer> temp = new ArrayList<>();
            for(int i = 0; i < size; i++){
                int cur = queue.poll();
                degree[cur]--;
                temp.add(cur);
                for(int nei : graph.get(cur)){
                    degree[nei]--;
                    if(degree[nei] == 1){
                        queue.offer(nei);
                    }
                }
            }
            res = temp;
        }
        return res;
    }
}
