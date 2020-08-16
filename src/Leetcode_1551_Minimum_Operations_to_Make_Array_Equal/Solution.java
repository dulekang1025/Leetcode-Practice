package Leetcode_1551_Minimum_Operations_to_Make_Array_Equal;

class Solution {
    public int minOperations(int n) {
        int low = 0, high = n - 1;
        int ans = 0;
        while(low < high){
            ans += ((high * 2 + 1) + (low * 2 + 1)) / 2 - (low * 2 + 1);
            low++;
            high--;
        }
        return ans;
    }
}
