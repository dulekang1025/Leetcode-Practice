package Leetcode_118_Pascals_Triangle;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> generate(int numRows) {
        ArrayList<List<Integer>> res = new ArrayList<>();
        if(numRows == 0){
            return res;
        }
        ArrayList<Integer> base = new ArrayList<>();
        ArrayList<Integer> second = new ArrayList<>();
        base.add(1);
        second.add(1);
        second.add(1);
        if(numRows == 1){
            res.add(base);
            return res;
        }
        if(numRows == 2){
            res.add(base);
            res.add(second);
            return res;
        }
        res.add(base);
        res.add(second);
        ArrayList<Integer> prev = second;
        for(int i = 2; i < numRows; i++){
            ArrayList<Integer> next = new ArrayList<>();
            next.add(1);
            for(int j = 0; j < prev.size() - 1; j++){
                int val = prev.get(j) + prev.get(j + 1);
                next.add(val);
            }
            next.add(1);
            prev = next;
            res.add(next);
        }
        return res;
    }
}
