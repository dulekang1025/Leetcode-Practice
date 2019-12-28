package Leetcode_202_Happy_Number;

import java.util.HashSet;

class Solution {
    public boolean isHappy(int n) {
        if(n == 0) return false;
        HashSet<Integer> set = new HashSet<>();
        while(n != 1){
            int sum = 0;
            while(n > 0){
                sum += (n % 10) * (n % 10);
                n = n/10;
            }
            n = sum;
            if(n == 1) break;
            if(set.contains(n)) return false;
            set.add(n);
        }
        return true;
    }
}
