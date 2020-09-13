package Leetcode_1582_Special_Positions_in_a_Binary_Matrix;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public int numSpecial(int[][] mat) {
        Set<Integer> col = new HashSet<>();
        Set<Integer> row = new HashSet<>();
        int res = 0;
        for(int i = 0; i < mat.length; i++){
            if(row.contains(i)) continue;
            for(int j = 0; j < mat[0].length; j++){
                if(col.contains(j)) continue;
                if(mat[i][j] == 1){
                    if(helper(mat, i, j)){
                        res++;
                    }
                    row.add(i);
                    col.add(j);
                }
            }
        }
        return res;
    }
    private boolean helper(int[][] mat, int i, int j){
        for(int r = 0; r < mat.length; r++){
            if(i == r) continue;
            if(mat[r][j] == 1) return false;
        }
        for(int c = 0; c < mat[0].length; c++){
            if(j == c) continue;
            if(mat[i][c] == 1) return false;
        }
        return true;
    }
}
