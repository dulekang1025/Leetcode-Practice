package Leetcode_873_Length_of_Longest_Fibonacci_Subsequence;

import java.util.HashSet;
import java.util.Set;

class Solution {
    public int lenLongestFibSubseq(int[] A) {
        int res = 2;
        int max = 0;
        int a1 = 0, a2 = 0;
        Set<Integer> set = new HashSet<>();
        for(int n : A) set.add(n);
        for(int i = 0; i < A.length - 2; i++){
            for(int j = i + 1; j < A.length - 1; j++){
                a1 = A[i];
                a2 = A[j];
                int a3 = a1 + a2;
                res = 2;
                while(set.contains(a3)){
                    res++;
                    max = Math.max(max, res);
                    a1 = a2;
                    a2 = a3;
                    a3 = a1 + a2;
                }
            }
        }
        return max;
    }
}
