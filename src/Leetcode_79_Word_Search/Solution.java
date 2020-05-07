package Leetcode_79_Word_Search;

class Solution {
    public boolean exist(char[][] board, String word) {
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(dfs(board, word, i, j, 0)) return true;
            }
        }
        return false;
    }
    private boolean dfs(char[][] board, String word, int i, int j, int d){
        if(i >= board.length || j >= board[0].length || i < 0 || j < 0) return false;
        if(word.charAt(d) != board[i][j]) return false;
        if(d == word.length() - 1) return true;
        char cur = board[i][j];
        //"对于DFS来说绝大对数的情况下是需要还原的，因为没找到解。这个类型题目的时间复杂度通常为为O(n!) O(2^n) 或者 O(c^n)。
        //只有找连通分量/拓扑排序的时候不需要还原，时间复杂度为O(V+E)"
        board[i][j] = '#';
        boolean found = dfs(board, word, i + 1, j, d + 1) || dfs(board, word, i - 1, j, d + 1)
                || dfs(board, word, i, j + 1, d + 1) || dfs(board, word, i, j - 1, d + 1);
        board[i][j] = cur;
        return found;
    }
}
