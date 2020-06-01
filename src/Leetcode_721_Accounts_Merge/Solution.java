package Leetcode_721_Accounts_Merge;

import java.util.*;

class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        List<List<String>> ans = new ArrayList<>();
        Map<String, Set<String>> graph = new HashMap<>();
        Map<String, String> emailToName = new HashMap<>();
        for(List<String> account : accounts){
            String name = account.get(0);
            for(int i = 1; i < account.size(); i++){
                graph.putIfAbsent(account.get(i), new HashSet<>());
                emailToName.put(account.get(i), name);
                for(int j = 1; j < account.size(); j++){
                    graph.get(account.get(i)).add(account.get(j));
                }
            }
        }
        Set<String> visited = new HashSet<>();
        int count = 0;
        for(String email : graph.keySet()){
            if(visited.contains(email)) continue;
            count++;
            List<String> list = new ArrayList<>();
            dfs(list, graph, visited, email);
            ans.add(list);
        }
        //System.out.println(count);
        for(List<String> list : ans){
            Collections.sort(list);
            String email = list.get(0);
            String name = emailToName.get(email);
            list.add(0, name);
        }
        return ans;
    }
    private void dfs(List<String> list, Map<String, Set<String>> graph,  Set<String> visited, String email){
        if(visited.contains(email)) return;
        visited.add(email);
        list.add(email);
        for(String nei : graph.get(email)){
            dfs(list, graph, visited, nei);
        }
    }
}
