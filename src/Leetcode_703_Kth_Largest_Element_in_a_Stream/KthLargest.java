package Leetcode_703_Kth_Largest_Element_in_a_Stream;

import java.util.PriorityQueue;
import java.util.Queue;

class KthLargest {
    private Queue<Integer> pq;
    private int k;
    public KthLargest(int k, int[] nums) {
        this.k = k;
        this.pq = new PriorityQueue<>();
        for(int n : nums){
            if(pq.size() < k) pq.add(n);
            else{
                int peek = pq.peek();
                if(peek < n){
                    pq.poll();
                    pq.add(n);
                }
            }
        }
    }

    public int add(int val) {
        if(pq.size() < this.k) pq.add(val);
        else{
            int peek = pq.peek();
            if(peek < val){
                pq.poll();
                pq.add(val);
            }
        }
        return pq.peek();
    }
}
