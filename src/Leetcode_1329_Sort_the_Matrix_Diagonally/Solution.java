package Leetcode_1329_Sort_the_Matrix_Diagonally;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {
    public int[][] diagonalSort(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        // loop through top row
        for(int i = n - 1; i >= 0; i--){
            List<Integer> list = new ArrayList<>();
            // i : col, j : row
            // i++, j++
            int j = 0;
            int temp_i = i;
            while(j < m && i < n){
                list.add(mat[j][i]);
                i++;
                j++;
            }
            i = temp_i;
            j = 0;
            Collections.sort(list);
            for(int k = 0; k < list.size(); k++){
                mat[j][i] = list.get(k);
                i++;
                j++;
            }
            i = temp_i;
        }
        // loop through left colum
        for(int i = 1; i < m; i++){
            List<Integer> list = new ArrayList<>();
            int j = 0;
            int temp_i = i;
            while(i < m && j < n){
                list.add(mat[i][j]);
                i++;
                j++;
            }
            i = temp_i;
            j = 0;
            Collections.sort(list);
            for(int k = 0; k < list.size(); k++){
                mat[i][j] = list.get(k);
                i++;
                j++;
            }
            i = temp_i;
        }
        return mat;
    }
}
