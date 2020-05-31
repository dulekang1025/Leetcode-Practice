package Leetcode_1465_Maximum_Area_of_a_Piece_of_Cake_After_Horizontal_and_Vertical_Cuts;

import java.util.Arrays;

class Solution {
    public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        Arrays.sort(horizontalCuts);
        Arrays.sort(verticalCuts);
        double max1 = Double.MIN_VALUE;
        double max2 = Double.MIN_VALUE;
        int start = 0;
        for(int i = 0; i < horizontalCuts.length; i++){
            max1 = Math.max(horizontalCuts[i] - start, max1);
            start = horizontalCuts[i];
        }
        max1 = Math.max(h - start, max1);
        start = 0;
        for(int i = 0; i < verticalCuts.length; i++){
            max2 = Math.max(verticalCuts[i] - start, max2);
            start = verticalCuts[i];
        }
        max2 = Math.max(w - start, max2);
        return (int)((max1 * max2) % (Math.pow(10,9) + 7));
    }
}
