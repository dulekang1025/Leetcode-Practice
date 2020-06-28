package Leetcode_1497_Check_If_Array_Pairs_Are_Divisible_by_k;

class Solution {
    public boolean canArrange(int[] arr, int k) {
        int[] mod = new int[k];
        for(int i = 0; i < arr.length; i++){
            mod[(arr[i] % k + k) % k]++;
        }
        for(int i = 1; i < k; i++){
            if(mod[i] != mod[k - i]) return false;
        }
        return mod[0] % 2 == 0;
    }
}
