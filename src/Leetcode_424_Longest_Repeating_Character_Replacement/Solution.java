package Leetcode_424_Longest_Repeating_Character_Replacement;

class Solution {
    public int characterReplacement(String s, int k) {
        int right = 0;
        int left = 0;
        int maxLen = 0;
        char[] arr = s.toCharArray();
        int[] map = new int[26];
        while(right < s.length()){
            char a = arr[right++];
            map[a - 'A']++;
            maxLen = Math.max(maxLen, map[a - 'A']);
            if(right - left > maxLen + k){
                map[(arr[left++] - 'A')]--;
            }
        }
        return arr.length - left;
    }
}
