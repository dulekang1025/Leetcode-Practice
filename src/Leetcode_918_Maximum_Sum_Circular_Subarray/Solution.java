package Leetcode_918_Maximum_Sum_Circular_Subarray;

class Solution {
    public int maxSubarraySumCircular(int[] A) {
        // https://www.youtube.com/watch?v=UcRham8J5rI
        int maxTillHere = A[0];
        int maxInTotal = A[0];
        int minTillHere = A[0];
        int minInTotal = A[0];
        int sum = A[0];

        for(int i = 1; i < A.length; i++){
            maxTillHere = Math.max(A[i], A[i] + maxTillHere);
            maxInTotal = Math.max(maxInTotal, maxTillHere);
            minTillHere = Math.min(A[i], A[i] + minTillHere);
            minInTotal = Math.min(minTillHere, minInTotal);
            sum += A[i];
        }

        if(sum == minInTotal) return maxInTotal;
        else return Math.max(sum - minInTotal, maxInTotal);
    }
}
