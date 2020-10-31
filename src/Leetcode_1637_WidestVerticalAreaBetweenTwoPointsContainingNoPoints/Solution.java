package Leetcode_1637_WidestVerticalAreaBetweenTwoPointsContainingNoPoints;

import java.util.Arrays;

public class Solution {
    public int maxWidthOfVerticalArea(int[][] points) {
        int[] arr = new int[points.length];
        int i = 0;
        for(int[] p : points){
            arr[i++] = p[0];
        }
        Arrays.sort(arr);
        Integer max = null;
        for(int j = 0; j < arr.length - 1; j++){
            if(max == null){
                max = arr[j + 1] - arr[j];
            }else{
                max = Math.max(max, arr[j + 1] - arr[j]);
            }
        }
        return max;
    }
}