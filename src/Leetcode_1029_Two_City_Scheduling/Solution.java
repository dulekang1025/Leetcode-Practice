package Leetcode_1029_Two_City_Scheduling;

import java.util.PriorityQueue;
import java.util.Queue;

class Solution {
    public int twoCitySchedCost(int[][] costs) {
        Queue<Integer> pq = new PriorityQueue<>();
        int res = 0;
        for(int[] n : costs){
            res += n[0];
            pq.add(n[1] - n[0]);
        }
        for(int i = 0; i < costs.length / 2; i++){
            res += pq.poll();
        }
        return res;
    }
}
