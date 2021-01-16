package Leetcode_1646_Get_Maximum_in_Generated_Array;

class Solution {
    public int getMaximumGenerated(int n) {
        if(n == 0) return 0;
        if(n == 1) return 1;
        int[] arr = new int[n + 1];
        arr[0] = 0;
        arr[1] = 1;
        int max = 0;
        for(int i = 1; i <= n; i++){
            if(2 * i <= n){
                arr[2 * i] = arr[i];
            }
            if(2 * i + 1 <= n){
                arr[2 * i + 1] = arr[i] + arr[i + 1];
            }
            max = Math.max(max, arr[i]);
        }
        return max;
    }
}
