package Leetcode_151_Reverse_Words_in_a_String;

class Solution {
    public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        String[] arr = s.trim().split(" ", -1);
        for(int i = arr.length - 1; i >= 0; i--){
            System.out.println(arr[i]);
            if(!arr[i].equals("") || !arr[i].equals(" ")){
                sb.append(arr[i].trim());
                if(i != 0){
                    sb.append(" ");
                }
            }
        }
        return sb.toString();
    }
}
