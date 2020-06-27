package Leetcode_1492_The_kth_Factor_of_n;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public int kthFactor(int n, int k) {
        List<Integer> list = new ArrayList<>();
        for(int i = 1; i <= n; i++){
            if(n % i == 0){
                list.add(i);
                if(list.size() == k) return i;
            }
        }
        //System.out.print(list);
        return -1;
    }
}
