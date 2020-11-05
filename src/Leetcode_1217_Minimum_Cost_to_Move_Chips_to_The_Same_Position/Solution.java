package Leetcode_1217_Minimum_Cost_to_Move_Chips_to_The_Same_Position;

class Solution {
    public int minCostToMoveChips(int[] position) {
        int odd = 0, even = 0;
        for(int i = 0; i < position.length; i++){
            if(position[i] % 2 == 0) even++;
            else odd++;
        }
        return Math.min(odd, even);
    }
}
