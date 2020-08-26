package Leetcode_490_The_Maze;

public class Solution2 {
    int[][] dirs = new int[][]{{0,1}, {0,-1}, {1,0},{-1,0}};
    public boolean hasPath(int[][] maze, int[] start, int[] dest) {
        return dfs(maze, start, dest);
    }
    private boolean dfs(int[][] maze, int[] start, int[] dest){
        if(maze[start[0]][start[1]] == -1) return false;
        if(start[0] == dest[0] && start[1] == dest[1]) return true;
        maze[start[0]][start[1]] = -1;
        for(int[] dir : dirs){
            int x = start[0];
            int y = start[1];
            while(x >= 0 && x < maze.length && y >= 0 && y < maze[0].length && maze[x][y] != 1){
                x += dir[0];
                y += dir[1];
            }
            x -= dir[0];
            y -= dir[1];
            if(maze[x][y] != -1 && dfs(maze, new int[]{x, y}, dest)) return true;
        }
        return false;
    }
}
