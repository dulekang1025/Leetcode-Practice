package Leetcode_528_Random_Pick_with_Weight;

import java.util.Random;

class Solution {

    Random random = new Random();
    int[] preSum;

    public Solution(int[] w) {
        preSum = new int[w.length];
        int temp = 0;
        int i = 0;
        for(int n : w){
            temp += n;
            preSum[i++] = temp;
        }
    }

    public int pickIndex() {
        int x = random.nextInt(preSum[preSum.length - 1]);
        int low = 0;
        int high = preSum.length - 1;
        int mid = 0;
        while(low < high){
            mid = low + (high - low) / 2;
            if(x < preSum[mid]) high = mid;
            else low = mid + 1;
        }
        return low;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */