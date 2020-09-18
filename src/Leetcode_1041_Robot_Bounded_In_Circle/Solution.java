package Leetcode_1041_Robot_Bounded_In_Circle;

class Solution {
    public boolean isRobotBounded(String instructions) {
        // L : (0, 1) -> (-1, 0) -> (0, -1) -> (1, 0)
        // R : (0, 1) -> (1, 0) -> (0, -1) -> (-1, 0)
        int[][] moves = new int[][]{{0, 1}, {-1, 0}, {0, -1}, {1, 0}};
        int dir = 0;
        int[] loc = new int[]{0, 0};
        for(char c : instructions.toCharArray()){
            if(c == 'G'){
                loc[0] += moves[dir][0];
                loc[1] += moves[dir][1];
            }else if(c == 'L'){
                dir = (dir + 1) % 4;
            }else{
                dir = (dir + 3) % 4;
            }
        }
        return (loc[0] == 0 && loc[1] == 0) || dir != 0;
    }
}
