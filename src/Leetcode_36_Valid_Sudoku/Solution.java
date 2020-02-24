package Leetcode_36_Valid_Sudoku;

class Solution {
    public boolean isValidSudoku(char[][] board) {
        boolean[][] row = new boolean[9][9];
        boolean[][] col = new boolean[9][9];
        boolean[][] box = new boolean[9][9];
        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                if(board[i][j] != '.'){
                    int v = board[i][j] - 49;
                    int p = (i / 3 * 3) + (j / 3);
                    if(row[i][v] || col[v][j] || box[p][v]) return false;
                    row[i][v] = true;
                    col[v][j] = true;
                    box[p][v] = true;
                }

            }
        }
        return true;
    }
}
