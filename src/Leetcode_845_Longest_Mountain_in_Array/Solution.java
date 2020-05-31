package Leetcode_845_Longest_Mountain_in_Array;

class Solution {
    public int longestMountain(int[] A) {
        int start = 0;
        int end = 0;
        int max = 0;
        int top = 0;
        while(start < A.length - 2){
            end = start;
            if(A[end] < A[end + 1]){
                while(end < A.length - 1 && A[end] < A[end + 1]){
                    end++;
                }
                top = end;
                if(end < A.length - 1 && A[end] > A[end + 1]){
                    while(end < A.length - 1 && A[end] > A[end + 1]){
                        end++;
                    }
                    max = Math.max(max, end - start + 1);
                    start = end;
                }else{
                    start = end + 1;
                }
            }else{
                start++;
            }
        }
        return max;
    }
}
