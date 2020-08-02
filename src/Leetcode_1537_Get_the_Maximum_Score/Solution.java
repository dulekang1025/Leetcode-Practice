package Leetcode_1537_Get_the_Maximum_Score;

class Solution {
    int module = 1000000007;
    public int maxSum(int[] nums1, int[] nums2) {
        long sum1 = 0, sum2 = 0;
        int n1 = nums1.length, n2 = nums2.length;
        int i = 0, j = 0;
        long ans = 0;
        while(i < n1 && j < n2){
            if(nums1[i] < nums2[j]){
                sum1 += nums1[i];
                i++;
            }else if(nums1[i] > nums2[j]){
                sum2 += nums2[j];
                j++;
            }else{
                sum1 += nums1[i];
                sum2 += nums2[j];
                ans += Math.max(sum1, sum2);
                ans %= module;
                sum1 = 0;
                sum2 = 0;
                i++;
                j++;
            }
        }
        while(i < n1){
            sum1 += nums1[i];
            i++;
        }
        while(j < n2){
            sum2 += nums2[j];
            j++;
        }
        ans += Math.max(sum1, sum2);
        ans %= module;
        return (int)ans;
    }
}
