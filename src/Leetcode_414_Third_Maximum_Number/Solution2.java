package Leetcode_414_Third_Maximum_Number;

import java.util.PriorityQueue;
import java.util.Queue;

class Solution2 {
    public int thirdMax(int[] nums) {
        Queue<Integer> pq = new PriorityQueue<>();
        for(int i : nums){
            if(pq.contains(i)) continue;
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
    public static void main(String[] args){
        Solution2 s2 = new Solution2();
        int[] nums = new int[]{1,2,2,5,3,5};
        System.out.println(s2.thirdMax(nums));
    }
}
