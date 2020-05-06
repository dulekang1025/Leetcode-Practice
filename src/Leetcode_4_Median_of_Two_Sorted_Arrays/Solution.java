package Leetcode_4_Median_of_Two_Sorted_Arrays;

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        //merge sort
        int[] arr = new int[nums1.length + nums2.length];
        int i = 0; int j = 0; int p = 0;
        while(i < nums1.length && j < nums2.length){
            arr[p++] = nums1[i] < nums2[j] ? nums1[i++] : nums2[j++];
        }
        while(i < nums1.length){
            arr[p++] = nums1[i++];
        }
        while(j < nums2.length){
            arr[p++] = nums2[j++];
        }
        return arr.length % 2 == 0 ? (arr[(arr.length - 1) / 2] + arr[arr.length / 2]) / 2.0 : (double)arr[arr.length / 2];
    }
}
