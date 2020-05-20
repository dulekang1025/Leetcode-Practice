package Leetcode_520_Detect_Capital;
class Solution {
    public boolean detectCapitalUse(String word) {
        char[] arr = word.toCharArray();
        int count = 0;
        for(int i = 0; i < arr.length; i++){
            if(arr[i] - 'A' < 26){
                count++;
            }
        }
        System.out.println(count);
        if(count == arr.length){
            return true;
        }else if(count == 1 && arr[0] - 'A' < 25){
            return true;
        }else if(count == 0){
            return true;
        }else{
            return false;
        }
    }
}
