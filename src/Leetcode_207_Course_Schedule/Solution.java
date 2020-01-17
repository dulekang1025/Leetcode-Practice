package Leetcode_207_Course_Schedule;

import java.util.ArrayList;
import java.util.HashMap;

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        HashMap<Integer, ArrayList<Integer>> graph = new HashMap<>();
        for(int[] e : prerequisites){
            int course = e[0];
            int pre = e[1];
            if(!graph.containsKey(course)){
                graph.put(course, new ArrayList<>());
            }
            graph.get(course).add(pre);
            if(!graph.containsKey(pre)){
                graph.put(pre, new ArrayList<>());
            }
        }
        for(int c : graph.keySet()){
            int[] visited = new int[numCourses];
            if(helper(c, graph, visited)) return false;
        }
        return true;
    }
    private boolean helper(int course, HashMap<Integer, ArrayList<Integer>> graph, int[] visited){
        // visited == 1 : visited; visited == 2 : visiting.
        if(visited[course] == 1) return false;
        if(visited[course] == 2) return true;
        visited[course] = 2;
        for(int c : graph.get(course)){
            if(helper(c, graph, visited)) return true;
        }
        visited[course] = 1;
        return false;
    }
}
