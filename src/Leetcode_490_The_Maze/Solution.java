package Leetcode_490_The_Maze;

class Solution {
    int[][] dirs = new int[][]{{0,1}, {1,0},{0,-1},{-1,0}};
    public boolean hasPath(int[][] maze, int[] start, int[] dest) {
        int m = maze.length;
        int n = maze[0].length;
        boolean[][] seen = new boolean[m][n];
        return dfs(maze, seen, start, dest);
    }
    private boolean dfs(int[][] maze, boolean[][] seen, int[] s, int[] dest){
        if(seen[s[0]][s[1]]) return false;
        if(s[0] == dest[0] && s[1] == dest[1]) return true;
        seen[s[0]][s[1]] = true;
        int m = maze.length;
        int n = maze[0].length;
        for(int[] dir : dirs){
            int x = s[0] + dir[0];
            int y = s[1] + dir[1];
            while(x >= 0 && x < m && y >= 0 && y < n && maze[x][y] == 0){
                x += dir[0];
                y += dir[1];
            }
            if(dfs(maze,seen,new int[]{x - dir[0], y - dir[1]},dest)) return true;
        }
        return false;
    }
}
