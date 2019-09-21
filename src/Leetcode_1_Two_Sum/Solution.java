package Leetcode_1_Two_Sum;

class Solution {

    public int[] twoSum(int[] num, int target) {

        for(int i = 0; i< num.length; i++) {
            for(int j = i+1;j< num.length; j++) {
                if(num[i]  == target - num[j]) {
                    return new int[] {i,j};
                }
            }
        }
        throw new IllegalArgumentException("No two sum solution");

    }

}