package Leetcode_1014_Best_Sightseeing_Pair;

class Solution {
    public int maxScoreSightseeingPair(int[] A) {
        int preMax = A[0] + 0;
        int ans = Integer.MIN_VALUE;
        for(int i = 1; i < A.length; i++){
            ans = Math.max(ans, preMax + A[i] - i);
            preMax = Math.max(preMax, A[i] + i);
        }
        return ans;
    }
}
