package Leetcode_119_Pascals_Triangle_II;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> getRow(int rowIndex) {
        ArrayList<List<Integer>> res = new ArrayList<>();
        ArrayList<Integer> base = new ArrayList<>();
        ArrayList<Integer> second = new ArrayList<>();
        base.add(1);
        second.add(1);
        second.add(1);
        if(rowIndex == 0){
            return base;
        }
        if(rowIndex == 1){
            return second;
        }
        res.add(base);
        res.add(second);
        ArrayList<Integer> prev = second;
        for(int i = 2; i < rowIndex + 1; i++){
            ArrayList<Integer> next = new ArrayList<>();
            next.add(1);
            for(int j = 0; j < prev.size() - 1; j++){
                int val = prev.get(j) + prev.get(j + 1);
                next.add(val);
            }
            next.add(1);
            prev = next;
        }
        return prev;
    }
}
