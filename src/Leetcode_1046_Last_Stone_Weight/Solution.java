package Leetcode_1046_Last_Stone_Weight;

import java.util.Arrays;

class Solution {
    public static int lastStoneWeight(int[] stones) {
        Arrays.sort(stones);
        for(int i = stones.length - 1; i > 0; i--){
            // must put new value on index i - 1, because index i will never be visited again.
            // we need this new value to participate in next round computation.
            stones[i-1] = stones[i] - stones[i-1];
            Arrays.sort(stones);
        }
        return stones[0];
    }
}
