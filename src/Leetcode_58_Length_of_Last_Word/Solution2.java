package Leetcode_58_Length_of_Last_Word;

class Solution2 {
    public int lengthOfLastWord(String s) {
        String[] arr = s.split(" ");
        if(arr.length == 0) return 0;
        return arr[arr.length - 1].length();
    }
}
