package Leetcode_1337_The_K_Weakest_Rows_in_a_Matrix;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
        int[] res = new int[k];
        // use pq to maintain the sequence, first sort by value, if values are same then sort by key
        Queue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>
                ((a,b) -> a.getValue() != b.getValue() ? a.getValue() - b.getValue() : a.getKey() - b.getKey());
        Map<Integer, Integer> map = new HashMap<>();
        int m = mat.length;
        int n = mat[0].length;
        for(int i = 0; i < m; i++){
            int low = 0;
            int high = n - 1;
            int mid = 0;
            while(low < high){
                mid = (low + high) / 2;
                if(mat[i][mid] > 0) low = mid + 1;
                else{
                    high = mid;
                }
            }
            if(low == n - 1 && mat[i][low] == 1) low += 1; // special case here
            map.put(i, low); // {row, first zreo's index}
        }
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            pq.add(entry);
        }
        // get top k
        for(int i = 0; i < k; i++){
            res[i] = pq.poll().getKey();
        }
        return res;
    }
}
