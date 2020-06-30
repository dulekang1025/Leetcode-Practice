package Leetcode_212_Word_Search_II;

import java.util.ArrayList;
import java.util.List;

class Solution {
    char[][] board;
    public List<String> findWords(char[][] board, String[] words) {
        List<String> res = new ArrayList<>();
        this.board = board;
        for(String s : words){
            if(helper(s)){
                res.add(s);
            }
        }
        return res;
    }
    private boolean helper(String s){
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(dfs(s, 0, i, j)) return true;
            }
        }
        return false;
    }
    private boolean dfs(String s, int pos, int i, int j){
        if(i < 0 || j < 0 || i > board.length - 1 || j > board[0].length - 1 || board[i][j] != s.charAt(pos))
            return false;
        if(pos == s.length() - 1) return true;
        char c = board[i][j];
        board[i][j] = '#';
        boolean found = dfs(s, pos + 1, i + 1, j) || dfs(s, pos + 1, i - 1, j) ||
                dfs(s, pos + 1, i, j + 1) || dfs(s, pos + 1, i, j - 1);
        board[i][j] = c;
        return found;
    }
}
