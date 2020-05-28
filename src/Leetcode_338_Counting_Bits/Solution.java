package Leetcode_338_Counting_Bits;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[] countBits(int num) {
        List<Integer> res = new ArrayList<>();
        res.add(0);
        for(int i = 1; i <= num; i++){
            if(i % 2 == 0){
                res.add(res.get(i / 2));
            }else{
                res.add(res.get(i - 1) + 1);
            }
        }
        int[] ans = new int[res.size()];
        int i = 0;
        for(int n : res){
            ans[i++] = n;
        }
        return ans;
    }
}
