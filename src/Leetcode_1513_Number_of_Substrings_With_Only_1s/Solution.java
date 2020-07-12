package Leetcode_1513_Number_of_Substrings_With_Only_1s;

class Solution {
    public int numSub(String s) {
        int[] arr = new int[s.length()];
        double ans = 0;
        int sum = 0;
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '0')
                sum = 0;
            else{
                sum += 1;
                arr[i] = sum;
                ans += sum;
            }
        }
        return (int)(ans % (Math.pow(10, 9) + 7));
    }
}
