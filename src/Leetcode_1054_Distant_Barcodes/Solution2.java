package Leetcode_1054_Distant_Barcodes;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

class Solution2 {
    public int[] rearrangeBarcodes(int[] barcodes) {
        Map<Integer, Integer> map = new HashMap<>();
        Queue<int[]> pq = new PriorityQueue<>((a, b) -> b[1] - a[1]); // max heap
        for(int i : barcodes) map.put(i, map.getOrDefault(i, 0) + 1);
        for(int i : map.keySet()) pq.add(new int[]{i, map.get(i)});
        int[] ans = new int[barcodes.length];
        int i = 0;
        int n = barcodes.length;
        while(pq.size() > 0){
            int[] temp = pq.poll();
            while(temp[1]-- > 0){
                ans[i] = temp[0];
                i += 2;
                if(i >= barcodes.length) i = 1;
            }
        }
        return ans;
    }
}
