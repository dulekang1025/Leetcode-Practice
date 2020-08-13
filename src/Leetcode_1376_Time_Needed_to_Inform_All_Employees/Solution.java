package Leetcode_1376_Time_Needed_to_Inform_All_Employees;

import java.util.*;

class Solution {
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int i = 0; i < n; i++){
            List<Integer> list = map.getOrDefault(manager[i], new ArrayList<>());
            list.add(i);
            map.put(manager[i], list);
        }
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(headID, informTime[headID]));
        int res = 0;
        while(!queue.isEmpty()){
            Node cur = queue.poll();
            for(int k : map.getOrDefault(cur.id, new ArrayList<>())){
                queue.offer(new Node(k, cur.time + informTime[k]));
            }
            res = Math.max(cur.time, res);
        }
        return res;
    }
}

class Node{
    int time;
    int id;
    public Node(int id, int time){
        this.id = id;
        this.time = time;
    }
}
