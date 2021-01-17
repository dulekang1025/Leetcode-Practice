package Leetcode_1641_Count_Sorted_Vowel_Strings;

public class Solution2 {
    public int countVowelStrings(int n) {
        int a = 1, b = 1, c = 1, d = 1, e = 1;
        for(int k = 1; k < n; k++){
            a = a + b + c + d + e;
            b = b + c + d + e;
            c = c + d + e;
            d = d + e;
            e = e;
        }
        return a + b + c + d + e;
    }
}
