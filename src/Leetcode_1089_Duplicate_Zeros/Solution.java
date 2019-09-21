package Leetcode_1089_Duplicate_Zeros;

class Solution {
    public void duplicateZeros(int[] arr) {
        if(arr.length == 0) return;
        for(int i = 0; i < arr.length - 1; i++){
            if(arr[i] == 0){
                reverse(arr,i);
                i++;
            }
        }
    }

    public void reverse(int[] arr, int postion){
        for(int i = arr.length - 1; i > postion; i--){
            arr[i] = arr[i-1];
        }
    }
}
