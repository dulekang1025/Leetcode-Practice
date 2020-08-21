package Leetcode_905_Sort_Array_By_Parity;

class Solution {
    public int[] sortArrayByParity(int[] A) {
        int low = 0, high = A.length - 1;
        while(low < high){
            while(low < high && A[low] % 2 == 0){
                low++;
            }
            while(low < high && A[high] % 2 == 1){
                high--;
            }
            int temp = A[high];
            A[high] = A[low];
            A[low] = temp;
        }
        return A;
    }
}
