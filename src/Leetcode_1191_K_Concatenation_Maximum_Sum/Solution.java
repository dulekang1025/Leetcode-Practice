package Leetcode_1191_K_Concatenation_Maximum_Sum;

class Solution {
    public int kConcatenationMaxSum(int[] arr, int k) {
        long sum = 0;
        long max1 = 0;
        long max2 = 0;
        long maxTillHere = 0, maxSoFar = 0;
        for(int i = 0; i < arr.length; i++){
            sum += arr[i];
            maxTillHere = Math.max(arr[i], maxTillHere + arr[i]);
            maxSoFar = Math.max(maxSoFar, maxTillHere);
        }
        max1 = maxSoFar;
        maxTillHere = arr[0];
        maxSoFar = arr[0];
        for(int i = 1; i < arr.length * 2; i++){
            maxTillHere = Math.max(arr[i % arr.length], maxTillHere + arr[i % arr.length]);
            maxSoFar = Math.max(maxSoFar, maxTillHere);
        }
        max2 = maxSoFar;
        if(k == 1) return (int)(max1 % (Math.pow(10, 9) + 7));
        else if(k == 2) return (int)(max2 % (Math.pow(10, 9) + 7));
        else return (int)(Math.max(max1, Math.max(max2, max2 + (k - 2) * sum)) % (Math.pow(10, 9) + 7));
    }
}
