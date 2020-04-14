package Leetcode_973_K_Closest_Points_to_Origin;

import java.util.PriorityQueue;

class Solution {
    public int[][] kClosest(int[][] points, int K) {
        PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> (a[0]*a[0]+a[1]*a[1]) - (b[0]*b[0]+b[1]*b[1]));
        for(int[] p : points){
            heap.add(p);
        }
        int[][] ans = new int[K][2];
        for(int i = 0; i < K; i++){
            ans[i] = heap.remove();
        }
        return ans;
    }
}
