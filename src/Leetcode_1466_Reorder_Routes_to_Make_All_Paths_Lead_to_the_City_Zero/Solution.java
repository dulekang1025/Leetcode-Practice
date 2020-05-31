package Leetcode_1466_Reorder_Routes_to_Make_All_Paths_Lead_to_the_City_Zero;

import java.util.*;

class Solution {
    public int minReorder(int n, int[][] connections) {
        Set<String> set = new HashSet<>();
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int[] e : connections){
            map.putIfAbsent(e[0], new ArrayList<>());
            map.putIfAbsent(e[1], new ArrayList<>());
            map.get(e[0]).add(e[1]);
            map.get(e[1]).add(e[0]);
            set.add(e[0] + "-" + e[1]);
        }
        int ans = 0;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        boolean[] visited = new boolean[n];
        while(!queue.isEmpty()){
            int cur = queue.poll();
            visited[0] = true;
            for(int nei : map.get(cur)){
                if(visited[nei]) continue;
                visited[nei] = true;
                if(!set.contains(nei + "-" + cur)) ans++;
                queue.add(nei);
            }
        }
        return ans;
    }
}
