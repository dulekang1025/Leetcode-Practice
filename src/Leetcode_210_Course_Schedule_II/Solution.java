package Leetcode_210_Course_Schedule_II;

import java.util.ArrayList;
import java.util.HashMap;

class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        HashMap<Integer, ArrayList<Integer>> graph = new HashMap<>();
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i = 0; i < numCourses; i++){
            graph.put(i, new ArrayList<>());
        }
        for(int[] e : prerequisites){
            int c = e[0];
            int pre = e[1];
            graph.get(c).add(pre);
        }
        // graph created
        int[] visited = new int[numCourses];
        for(int c : graph.keySet()){

            if(!helper(c, graph, visited, ans)) return new int[0];
        }
        int[] res = new int[numCourses];
        //System.out.println(ans);
        int i = 0;
        for(int x : ans){
            res[i++] = x;
        }
        return res;
    }
    private boolean helper(int course, HashMap<Integer, ArrayList<Integer>> graph, int[] visited, ArrayList<Integer> ans){
        // 1 : visiting, 2 : visited
        if(visited[course] == 1) return false;
        if(visited[course] == 2) return true;
        visited[course] = 1;
        for(int c : graph.get(course)){
            if(!helper(c, graph, visited, ans)) return false;
        }
        visited[course] = 2;
        ans.add(course);
        return true;
    }
}
