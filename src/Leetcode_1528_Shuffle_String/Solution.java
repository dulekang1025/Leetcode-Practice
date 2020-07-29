package Leetcode_1528_Shuffle_String;

class Solution {
    public String restoreString(String s, int[] indices) {
        StringBuilder sb = new StringBuilder();
        char[] arr = new char[indices.length];
        for(int i = 0; i < indices.length; i++){
            arr[indices[i]] = s.charAt(i);
        }
        for(char c : arr){
            sb.append(c);
        }
        return sb.toString();
    }
}