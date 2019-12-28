package Leetcode_349_Intersection_of_Two_Arrays;

import java.util.HashSet;

class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set = new HashSet<>();
        for(int i : nums1){
            for(int j : nums2){
                if(i == j) set.add(i);
            }
        }
        int[] array = new int[set.size()];
        int j = 0;
        for(int i : set){
            array[j] = i;
            j++;
        }
        return array;
    }
}
