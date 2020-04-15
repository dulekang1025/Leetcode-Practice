package Leetcode_215_Kth_Largest_Element_in_an_Array;

import java.util.PriorityQueue;
import java.util.Queue;

class Solution {
    public int findKthLargest(int[] nums, int k) {
        Queue<Integer> pq = new PriorityQueue<>((a, b) -> (a-b));
        for(int i : nums){
            if(pq.size() < k) pq.add(i);
            else{
                int temp = pq.peek();
                if(temp < i){
                    pq.poll();
                    pq.add(i);
                }
            }
        }
        return pq.peek();
    }
}