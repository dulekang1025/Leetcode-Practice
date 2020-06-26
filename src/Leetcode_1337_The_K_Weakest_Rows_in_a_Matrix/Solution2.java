package Leetcode_1337_The_K_Weakest_Rows_in_a_Matrix;

import java.util.PriorityQueue;
import java.util.Queue;

class Solution2 {
    public int[] kWeakestRows(int[][] mat, int k) {
        // find '0's' lower bound
        Queue<int[]> heap = new PriorityQueue<>((a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        int m = mat.length;
        int n = mat[0].length;
        for(int i = 0; i < m; i++){
            int low = 0, high = n;
            while(low < high){
                int mid = low + (high - low) / 2;
                if(mat[i][mid] == 0){
                    high = mid;
                }else{
                    low = mid + 1;
                }
            }
            int[] pos = new int[]{low, i};
            heap.add(pos);
        }
        int[] ans = new int[k];
        int i = 0;
        while(k > 0){
            ans[i++] = heap.poll()[1];
            k--;
        }
        return ans;
    }
}
