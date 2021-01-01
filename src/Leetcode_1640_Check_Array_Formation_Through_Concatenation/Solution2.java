package Leetcode_1640_Check_Array_Formation_Through_Concatenation;

import java.util.HashMap;
import java.util.Map;

class Solution2 {
    public boolean canFormArray(int[] arr, int[][] pieces) {
        Map<Integer, int[]> map = new HashMap<>();
        for(int[] p : pieces){
            map.put(p[0], p);
        }
        for(int i = 0; i < arr.length;){
            if(map.containsKey(arr[i])){
                int[] p = map.get(arr[i]);
                for(int num : p){
                    if(num == arr[i]){
                        i++;
                    }else{
                        return false;
                    }
                }
            }else{
                return false;
            }
        }
        return true;
    }
}
