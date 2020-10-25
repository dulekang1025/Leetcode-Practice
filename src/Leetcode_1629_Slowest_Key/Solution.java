package Leetcode_1629_Slowest_Key;

class Solution {
    public char slowestKey(int[] releaseTimes, String keysPressed) {
        int n = releaseTimes.length;
        long[] arr = new long[26];
        long maxTime = 0;
        char maxChar = 'a';
        for(int i = 0; i < n; i++){
            char c = keysPressed.charAt(i);
            if(i == 0){
                arr[c - 'a'] = releaseTimes[i];
            }else{
                arr[c - 'a'] = releaseTimes[i] - releaseTimes[i - 1];
            }
            if((arr[c - 'a'] > maxTime) || (arr[c - 'a'] == maxTime && c > maxChar)){
                maxTime = arr[c - 'a'];
                maxChar = c;
            }
        }
        //System.out.println(arr['o' - 'a'] + " " + arr['n' - 'a'] );
        return maxChar;
    }
}
