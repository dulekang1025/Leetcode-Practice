package Leetcode_207_Course_Schedule;

import java.util.ArrayList;
import java.util.HashMap;

public class Course_Schedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
//        ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
//        //先创建头节点
//        for(int i = 0; i < numCourses; i++){
//            graph.add(new ArrayList<Integer>());
//        }
//
//        for(int i = 0; i < prerequisites.length; i++){
//            int course = prerequisites[i][0];
//            int prerequisite = prerequisites[i][1];
//            graph.get(course).add(prerequisite);
//        }
//
//        int[] visited = new int[numCourses];
//
//        for(int i = 0; i < numCourses; i++){
//            if(dfs(i,visited,graph)) return false;
//        }
//        return true;
//    }
//
//    public boolean dfs(int i,int[] visited,  ArrayList<ArrayList<Integer>> graph){
//        if(visited[i] == 1) return true;
//        if(visited[i] == 2) return false;
//        visited[i] = 1;
//        for(int adj : graph.get(i)){
//            if(dfs(adj, visited, graph)) return true;
//        }
//
//        visited[i] = 2;
//        return false;

        //Another try, to see if there is a cycle in the graph
        HashMap<Integer, ArrayList<Integer>> graph = new HashMap<>();

        for(int i = 0; i<prerequisites.length; i++){
            if(!graph.containsKey(prerequisites[i][0])){
                graph.put(prerequisites[i][0],new ArrayList<>());
            }
        }

        for(int i=0;i<prerequisites.length;i++){
            graph.get(prerequisites[i][0]).add(prerequisites[i][1]);
        }

        // dfs
        int[] visited = new int[numCourses];
        for(int i : graph.keySet()){
            if(dfs(graph,i,visited)) return false;
        }


        return true;
    }

    public boolean dfs(HashMap<Integer, ArrayList<Integer>> graph, int i, int[] visited){
        if(visited[i] == 1) return true;
        if(visited[i] == 2) return false;

        visited[i] = 1;
        for(int j : graph.get(i)){
            dfs(graph,j,visited);
        }
        visited[i] = 2;
        return true;
    }

}

//class Solution {
//    public boolean canFinish(int numCourses, int[][] prerequisites) {
//        ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
//        //先创建头节点
//        for(int i = 0; i < numCourses; i++){
//            graph.add(new ArrayList<Integer>());
//        }
//
//        for(int i = 0; i < prerequisites.length; i++){
//            int course = prerequisites[i][0];
//            int prerequisite = prerequisites[i][1];
//            graph.get(course).add(prerequisite);
//        }
//
//        int[] visited = new int[numCourses];
//
//        for(int i = 0; i < numCourses; i++){
//            if(dfs(i,visited,graph)) return false;
//        }
//        return true;
//    }
//
//    public boolean dfs(int i,int[] visited,  ArrayList<ArrayList<Integer>> graph){
//        if(visited[i] == 1) return true;     //visiting
//        if(visited[i] == 2) return false;    //visited
//        visited[i] = 1;
//        for(int adj : graph.get(i)){
//            if(dfs(adj, visited, graph)) return true;
//        }
//
//        visited[i] = 2;                  //visited
//        return false;
//    }
//}
