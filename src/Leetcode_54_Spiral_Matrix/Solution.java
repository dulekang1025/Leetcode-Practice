package Leetcode_54_Spiral_Matrix;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        //   r1 ---- c1
        //    |       |
        //    |       |
        //   c2 ---- r2
        List<Integer> ans = new ArrayList<>();
        if(matrix.length == 0) return ans;
        int m = matrix.length;
        int n = matrix[0].length;
        int r1 = 0; int r2 = m - 1;
        int c1 = n - 1; int c2 = 0;
        while(r1 <= r2 && c2 <= c1){
            for(int i = c2; i <= c1 ; i++) ans.add(matrix[r1][i]);
            for(int i = r1 + 1; i <= r2; i++) ans.add(matrix[i][c1]);
            if(r1 < r2 && c2 < c1){
                for(int i = c1 - 1; i > c2; i--) ans.add(matrix[r2][i]);
                for(int i = r2; i > r1; i--) ans.add(matrix[i][c2]);
            }
            r1++;
            r2--;
            c2++;
            c1--;
        }
        return ans;
    }
}
