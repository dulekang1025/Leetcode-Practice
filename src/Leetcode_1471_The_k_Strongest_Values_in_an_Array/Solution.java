package Leetcode_1471_The_k_Strongest_Values_in_an_Array;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

class Solution {
    public int[] getStrongest(int[] arr, int k) {
        Arrays.sort(arr);
        int len = arr.length;
        int m = arr[(len - 1) / 2];
        Queue<Integer> pq = new PriorityQueue<>
                ((a, b) -> Math.abs(a - m) == Math.abs(b - m) ? b - a : Math.abs(b - m) - Math.abs(a - m));
        for(int n : arr){
            pq.add(n);
        }
        System.out.println(m);
        System.out.println(pq);
        int[] ans = new int[k];
        int i = 0;
        while(k > 0){
            ans[i++] = pq.poll();
            k--;
        }
        return ans;
    }
}
