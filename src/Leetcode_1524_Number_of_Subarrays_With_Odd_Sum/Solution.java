package Leetcode_1524_Number_of_Subarrays_With_Odd_Sum;

class Solution {
    public int numOfSubarrays(int[] arr) {
        int odd = 0;
        int even = 0;
        long result = 0;
        for (int i : arr) {
            if (i % 2 == 0) {
                even++;
            } else {
                int temp = even;
                even = odd;
                odd = temp + 1;
            }
            result += odd;
        }
        //System.out.println(result); 10^9 + 7
        return (int)(result % (long)1000000007);
    }
}
