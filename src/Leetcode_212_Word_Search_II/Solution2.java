package Leetcode_212_Word_Search_II;

import java.util.ArrayList;
import java.util.List;

class Solution2 {
    class TireNode{
        char c;
        TireNode[] children;
        String word;
        public TireNode(char x){
            this.c = x;
            children = new TireNode[26];
            word = null;
        }
    }
    TireNode root = new TireNode(' ');
    List<String> res = new ArrayList<>();
    public List<String> findWords(char[][] board, String[] words) {
        buildTire(words);
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                dfs(board, root, i, j);
            }
        }
        return res;
    }
    private void dfs(char[][] board, TireNode cur, int i, int j){
        if(i < 0 || j < 0 || i > board.length - 1 || j > board[0].length - 1) return;
        char c = board[i][j];
        if(c == '*') return;
        if(cur.children[c - 'a'] == null) return;
        board[i][j] = '*';
        cur = cur.children[c - 'a'];
        if(cur.word != null){
            res.add(cur.word);
            cur.word = null;
        }
        dfs(board, cur, i + 1, j);
        dfs(board, cur, i - 1, j);
        dfs(board, cur, i, j + 1);
        dfs(board, cur, i, j - 1);
        board[i][j] = c;
    }
    private void buildTire(String[] words){
        for(String s : words){
            TireNode cur = root;
            for(char c : s.toCharArray()){
                if(cur.children[c - 'a'] == null){
                    cur.children[c - 'a'] = new TireNode(c);
                }
                cur = cur.children[c - 'a'];
            }
            cur.word = s;
        }
    }
}
