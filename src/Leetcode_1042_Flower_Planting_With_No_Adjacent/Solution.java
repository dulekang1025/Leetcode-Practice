package Leetcode_1042_Flower_Planting_With_No_Adjacent;

import java.util.*;

class Solution {
    public int[] gardenNoAdj(int N, int[][] paths) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        int[] res = new int[N];
        for(int i = 0; i <= N; i++){
            graph.put(i, new ArrayList<>());
        }
        for(int[] e : paths){
            int p1 = e[0];
            int p2 = e[1];
            graph.get(p1).add(p2);
            graph.get(p2).add(p1);
        }
        for(int i = 1; i <= N; i++){
            Set<Integer> neighbors = new HashSet<>();
            for(int nei : graph.get(i)){
                neighbors.add(res[nei - 1]); // get all neighbors' flowers
            }
            for(int flower = 1; flower <= 4; flower++){
                if(!neighbors.contains(flower)){
                    res[i - 1] = flower;
                }
            }
        }
        return res;
    }
}
