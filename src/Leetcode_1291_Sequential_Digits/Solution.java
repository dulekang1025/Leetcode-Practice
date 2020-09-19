package Leetcode_1291_Sequential_Digits;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        List<Integer> res = new ArrayList<>();
        for(int i = 1; i <= 9; i++){
            int num = i;
            for(int j = i + 1; j <= 9; j++){
                num = num * 10 + j;
                if(num >= low && num <= high){
                    res.add(num);
                }
                if(num > high) break;
            }
        }
        Collections.sort(res);
        return res;
    }
}
