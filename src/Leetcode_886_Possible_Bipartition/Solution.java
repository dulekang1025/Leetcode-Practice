package Leetcode_886_Possible_Bipartition;

import java.util.*;

class Solution {
    public boolean possibleBipartition(int N, int[][] dislikes) {
        if(dislikes.length == 0) return true;
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int[] e : dislikes){
            map.putIfAbsent(e[0], new ArrayList<>());
            map.putIfAbsent(e[1], new ArrayList<>());
            map.get(e[0]).add(e[1]);
            map.get(e[1]).add(e[0]);
        }
        Queue<Integer> queue = new LinkedList<>();
        int[] visited = new int[N + 1];

        for(int i = 1; i <= N; i++){  // 为了便利到每一个子图，因为可能每个子图不相连
            if(visited[i] != 0 || !map.containsKey(i)) continue;
            queue.add(i);
            visited[i] = 1;
            while(!queue.isEmpty()){
                int cur = queue.poll();
                //System.out.println(cur);
                int neiLabel = visited[cur] == 1 ? 2 : 1;
                for(int nei : map.get(cur)){
                    if(visited[nei] == 0){
                        visited[nei] = neiLabel;
                        queue.add(nei);
                    }else{
                        if(visited[nei] != neiLabel)
                            return false;
                    }
                }
            }
        }
        return true;
    }
}
