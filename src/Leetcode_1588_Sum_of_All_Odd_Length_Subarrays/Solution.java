package Leetcode_1588_Sum_of_All_Odd_Length_Subarrays;

class Solution {
    public int sumOddLengthSubarrays(int[] arr) {
        int sum = 0;
        int gap = 1;
        while(gap <= arr.length){
            for(int i = 0; i < arr.length; i++){
                int temp = i;
                for(int j = 0; j < gap && temp + gap <= arr.length; j++){
                    sum += arr[i];
                    i++;
                }
                i = temp;
            }
            gap += 2;
        }
        return sum;
    }
}
