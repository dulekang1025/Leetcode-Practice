package Leetcode_414_Third_Maximum_Number;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

class Solution {
    public int thirdMax(int[] nums) {
        Queue<Integer> pq = new PriorityQueue<>();
        Set<Integer> set = new HashSet<>();
        for(int i : nums){
            set.add(i);
        }
        for(int i : set){
            if(pq.size() < 3) pq.add(i);
            else{
                int temp = pq.peek();
                if(temp < i){
                    pq.poll();
                    pq.add(i);
                }
            }
        }
        while(pq.size() < 3 && pq.size() > 1){
            pq.poll();
        }
        return pq.peek();
    }
}