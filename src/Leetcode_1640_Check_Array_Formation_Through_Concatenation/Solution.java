package Leetcode_1640_Check_Array_Formation_Through_Concatenation;

public class Solution {
    public boolean canFormArray(int[] arr, int[][] pieces) {
        int i = 0;
        while(i < arr.length){
            int len = check(i, arr, pieces);
            if(len == 0) return false;
            i += len;
        }
        return true;
    }

    private int check(int index, int[] arr, int[][] p){
        //int maxLen = 0;
        for(int i = 0; i < p.length; i++){
            int temp = index;
            if(p[i][0] == arr[temp]){
                int j = 0;
                while(temp < arr.length && j < p[i].length && p[i][j] == arr[temp]){
                    j++;
                    temp++;
                }
                if(j == p[i].length){
                    //maxLen = Math.max(maxLen, j);
                    return j;
                }
            }
        }
        return 0;
    }
}