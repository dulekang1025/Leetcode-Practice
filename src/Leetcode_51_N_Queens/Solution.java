package Leetcode_51_N_Queens;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        char[][] board = new char[n][n];
        for(int i = 0; i < board.length; i++){
            Arrays.fill(board[i], '.');
        }
        helper(res, board, 0);
        return res;
    }
    private void helper(List<List<String>> res, char[][] board, int rowIndex){
        if(rowIndex == board.length){
            res.add(generate(board));
            return;
        }
        for(int colIndex = 0; colIndex < board.length; colIndex++){
            if(isVaild(rowIndex, colIndex, board)){
                board[rowIndex][colIndex] = 'Q';
                helper(res, board, rowIndex + 1);
                board[rowIndex][colIndex] = '.';
            }
        }
    }
    private boolean isVaild(int rowIndex, int colIndex, char[][] board){
        for(int i = rowIndex - 1; i >= 0; i--){
            if(board[i][colIndex] == 'Q') return false;
        }
        for(int i = rowIndex - 1, j = colIndex - 1; i >= 0 && j >= 0; i--, j--){
            if(board[i][j] == 'Q') return false;
        }
        for(int i = rowIndex - 1, j = colIndex + 1; i >= 0 && j < board.length; i--, j++){
            if(board[i][j] == 'Q') return false;
        }
        return true;
    }
    private List<String> generate(char[][] board){
        List<String> ans = new ArrayList<>();
        for(char[] row : board){
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < board.length; i++){
                sb.append(row[i]);
            }
            ans.add(sb.toString());
        }
        return ans;
    }
}
