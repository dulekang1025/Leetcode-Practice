package Leetcode_769_Max_Chunks_To_Make_Sorted;

class Solution {
    public int maxChunksToSorted(int[] arr) {
        int res = 0;
        int max = 0;
        for(int i = 0; i < arr.length; i++){
            max = Math.max(max, arr[i]);
            if(i == max) res++;
        }
        return res;
    }
}
