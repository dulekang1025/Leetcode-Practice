package Leetcode_1232_Check_If_It_Is_a_Straight_Line;

class Solution {
    public boolean checkStraightLine(int[][] coordinates) {
        double k = (coordinates[1][1] - coordinates[0][1]) / ((coordinates[1][0] - coordinates[0][0]) * 1.0);
        //System.out.println(k);
        for(int i = 2; i < coordinates.length; i++){
            double j = (coordinates[i][1] - coordinates[i - 1][1]) / ((coordinates[i][0] - coordinates[i - 1][0]) * 1.0);
            //System.out.println(j);
            if(j != k) return false;
        }
        return true;
    }
}
