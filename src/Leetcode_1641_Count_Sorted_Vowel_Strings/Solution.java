package Leetcode_1641_Count_Sorted_Vowel_Strings;

class Solution {
    int ans = 0;
    public int countVowelStrings(int n) {
        char[] arr = new char[]{'a','e','i','o','u'};
        helper(arr, n, new StringBuilder());
        return ans;
    }
    private void helper(char[] arr, int n, StringBuilder sb){
        if(n == 0){
            ans++;
            return;
        }
        for(int i = 0; i < 5; i++){
            if(sb.length() != 0 && arr[i] >= sb.charAt(sb.length() - 1)) sb.append(arr[i]);
            else if(sb.length() == 0) sb.append(arr[i]);
            else continue;
            helper(arr, n - 1, sb);
            sb.delete(sb.length() - 1, sb.length());
        }
    }
}
