package Leetcode_841_Keys_and_Rooms;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        Set<Integer> visited = new HashSet<>();
        int count = 0;
        for(int i = 0; i < rooms.size(); i++){
            if(!visited.contains(i)){
                count++;
                dfs(rooms, visited, i);
            }
        }
        return count == 1 ? true : false;
    }
    private void dfs(List<List<Integer>> rooms, Set<Integer> visited, int i){
        if(visited.contains(i)) return;
        visited.add(i);
        List<Integer> neis = rooms.get(i);
        for(int nei : neis){
            dfs(rooms, visited, nei);
        }
    }
}
