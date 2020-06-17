package Leetcode_888_Fair_Candy_Swap;

import java.util.HashSet;
import java.util.Set;

public class Solution2 {
    public int[] fairCandySwap(int[] A, int[] B) {
        // x : A recesive, y : B recesive
        // sumB + y == sumA + x
        int[] res = new int[2];
        int sumA = 0, sumB = 0;
        for(int n : A) sumA += n;
        for(int n : B) sumB += n;
        int diff = (sumB - sumA) / 2;
        Set<Integer> set = new HashSet<>();
        for(int n : B) set.add(n);
        for(int n : A){
            if(set.contains(n + diff)){
                res[0] = n;
                res[1] = n + diff;
                break;
            }
        }
        return res;
    }
}
