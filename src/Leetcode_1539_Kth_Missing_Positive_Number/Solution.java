package Leetcode_1539_Kth_Missing_Positive_Number;

class Solution {
    public int findKthPositive(int[] arr, int k) {
        int index = 1;
        int i = 0;
        while(k > 0 && i < arr.length){
            if(index != arr[i]){
                k--;
            }else{
                i++;
            }
            index++;
        }
        if(k == 0) return index - 1;
        else return index + k - 1;
    }
}