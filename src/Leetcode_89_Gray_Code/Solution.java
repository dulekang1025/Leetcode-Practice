package Leetcode_89_Gray_Code;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> grayCode(int n) {
        List<Integer> res = new ArrayList<>();
        res.add(0);
        if(n == 0) return res;
        for(int i = 0; i < n; i++){
            int len = res.size();
            for(int j = len - 1; j >= 0; j--){
                res.add(res.get(j) | (1 << i));
            }
        }
        return res;
    }
}
