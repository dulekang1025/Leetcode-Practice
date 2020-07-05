package Leetcode_1502_Can_Make_Arithmetic_Progression_From_Sequence;

import java.util.Arrays;

class Solution {
    public boolean canMakeArithmeticProgression(int[] arr) {
        Arrays.sort(arr);
        int diff = 0;
        for(int i = 0; i < arr.length - 1; i++){
            if(i == 0){
                diff = arr[i] - arr[i + 1];
            }
            if(diff != arr[i] - arr[i + 1]) return false;
        }
        return true;
    }
}
