package Leetcode_733_Flood_Fill;

class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if(newColor == image[sr][sc]) return image;
        dfs(image, sr, sc, newColor, image[sr][sc]);
        return image;
    }
    private void dfs(int[][] image, int sr, int sc, int newColor, int orgColor){
        if(sr < 0 || sc < 0 || sr > image.length - 1
                || sc > image[0].length - 1 || image[sr][sc] != orgColor)
            return;
        image[sr][sc] = newColor;
        dfs(image, sr + 1, sc, newColor, orgColor);
        dfs(image, sr - 1, sc, newColor, orgColor);
        dfs(image, sr, sc + 1, newColor, orgColor);
        dfs(image, sr, sc - 1, newColor, orgColor);
    }
}
