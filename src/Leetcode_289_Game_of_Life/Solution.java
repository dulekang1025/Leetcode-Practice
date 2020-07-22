package Leetcode_289_Game_of_Life;

import java.util.Arrays;

class Solution {
    public void gameOfLife(int[][] board) {
        int m = board.length;
        int n = board[0].length;
        int[][] next = new int[m][n];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                int neis = getNeis(board, i, j);
                if(board[i][j] == 1){
                    if(neis < 2) next[i][j] = 0;
                    else if(neis >= 2 && neis <= 3) next[i][j] = 1;
                    else if(neis > 3) next[i][j] = 0;
                }else{
                    if(neis == 3) next[i][j] = 1;
                }
            }
        }
        for(int i = 0; i < m; i++){
            board[i] = Arrays.copyOf(next[i], next[i].length);
        }
        return;
    }
    private int getNeis(int[][] board, int i, int j){
        int m = board.length;
        int n = board[0].length;
        int ans = 0;
        if(i - 1 >= 0 && board[i - 1][j] == 1) ans++;
        if(i + 1 < m && board[i + 1][j] == 1) ans++;
        if(j - 1 >= 0 && board[i][j - 1] == 1) ans++;
        if(j + 1 < n && board[i][j + 1] == 1) ans++;
        if(i - 1 >= 0 && j - 1 >= 0 && board[i - 1][j - 1] == 1) ans++;
        if(i - 1 >= 0 && j + 1 < n && board[i - 1][j + 1] == 1) ans++;
        if(i + 1 < m && j - 1 >= 0 && board[i + 1][j - 1] == 1) ans++;
        if(i + 1 < m && j + 1 < n && board[i + 1][j + 1] == 1) ans++;
        return ans;
    }
}
