package Leetcode_73_Set_Matrix_Zeroes;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public void setZeroes(int[][] matrix) {
        List<Integer[]> p = new ArrayList<>();
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                if(matrix[i][j] == 0) p.add(new Integer[]{i, j});
            }
        }
        // set '0'
        for(Integer[] l : p){
            int row = l[0];
            int col = l[1];
            for(int i = 0; i < matrix[0].length; i++){
                matrix[row][i] = 0;
            }
            for(int i = 0; i < matrix.length; i++){
                matrix[i][col] = 0;
            }
        }
    }
}
