package Leetcode_52_N_Queens_II;

class Solution {
    int res = 0;
    public int totalNQueens(int n) {
        int[][] board = new int[n][n];
        helper(board, 0);
        return res;
    }
    private void helper(int[][] board, int rowIndex){
        if(rowIndex == board.length){
            res+=1;
            return;
        }
        for(int colIndex = 0; colIndex < board.length; colIndex++){
            if(isVaild(rowIndex, colIndex, board)){
                board[rowIndex][colIndex] = 1;
                helper(board, rowIndex + 1);
                board[rowIndex][colIndex] = 0;
            }
        }
    }
    private boolean isVaild(int rowIndex, int colIndex, int[][] board){
        for(int i = rowIndex - 1; i >=0; i--){
            if(board[i][colIndex] == 1) return false;
        }
        for(int i = rowIndex - 1, j = colIndex - 1; i >= 0 && j >= 0; i--, j--){
            if(board[i][j] == 1) return false;
        }
        for(int i = rowIndex - 1, j = colIndex + 1; i >= 0 && j < board.length; i--, j++){
            if(board[i][j] == 1) return false;
        }
        return true;
    }
}
