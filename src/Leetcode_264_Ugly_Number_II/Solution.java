package Leetcode_264_Ugly_Number_II;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {
    public int nthUglyNumber(int n) {
        List<Integer> list = new ArrayList<>();
        for(long i = 1; i < Integer.MAX_VALUE; i*=2){
            for(long j = i; j < Integer.MAX_VALUE; j*=3){
                for(long k = j; k < Integer.MAX_VALUE; k*=5){
                    list.add((int)k);
                }
            }
        }
        Collections.sort(list);
        return list.get(n - 1);
    }
}
