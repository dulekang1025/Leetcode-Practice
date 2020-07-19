package Leetcode_1519;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Solution {
    int[] ans;
    Set<Integer> seen = new HashSet<>();
    public int[] countSubTrees(int n, int[][] edges, String labels) {
        char[] s = labels.toCharArray();
        ans = new int[n];
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        for(int i = 0; i < n - 1; i++){
            int p = edges[i][0];
            int c = edges[i][1];
            graph.putIfAbsent(p, new HashSet<>());
            graph.putIfAbsent(c, new HashSet<>());
            graph.get(p).add(c);
            graph.get(c).add(p);
        }
        helper(graph, s, 0);
        return ans;
    }
    private int[] helper(Map<Integer, Set<Integer>> graph, char[] s, int cur){
        int[] curCount = new int[26];
        if(seen.contains(cur)) return curCount;
        seen.add(cur);
        if(graph.get(cur).isEmpty()){
            int[] count = new int[26];
            count[s[cur] - 'a']++;
            ans[cur] = count[s[cur] - 'a'];
            return count;
        }
        for(int child : graph.get(cur)){
            int[] temp = helper(graph, s, child);
            for(int i = 0; i < 26; i++){
                curCount[i] += temp[i];
            }
        }
        curCount[s[cur] - 'a']++;
        ans[cur] = curCount[s[cur] - 'a'];
        return curCount;
    }
}
