package Leetcode_1615_Maximal_Network_Rank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public int maximalNetworkRank(int n, int[][] roads) {
        if(roads.length == 0) return 0;
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int i = 0; i < roads.length; i++){
            int s = roads[i][0];
            int t = roads[i][1];
            map.putIfAbsent(s, new ArrayList<>());
            map.putIfAbsent(t, new ArrayList<>());
            map.get(s).add(t);
            map.get(t).add(s);
        }
        int max = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(i == j || !map.containsKey(i) || !map.containsKey(j)) continue;
                int s = i;
                int t = j;
                int rank = map.get(s).size() + map.get(t).size();
                if(map.get(s).contains(t)){
                    rank -= 1;
                }
                max = Math.max(max, rank);
            }
        }
        return max;
    }
}
