package Leetcode_748_Shortest_Completing_Word;

class Solution {
    public String shortestCompletingWord(String licensePlate, String[] words) {
        int[] target = count(licensePlate);
        String ans = "";
        for(String word : words){
            if((ans.length() == 0 || word.length() < ans.length())
                    && compare(target, count(word))){
                ans = word;
            }
        }
        return ans;
    }
    private int[] count(String word){
        int[] ans = new int[26];
        for(char c : word.toCharArray()){
            int index = Character.toLowerCase(c) - 'a';
            if(index >= 0 && index <26){
                ans[index]++;
            }
        }
        return ans;
    }
    private boolean compare(int[] target, int[] word){
        for(int i = 0; i < 26; i++){
            if(target[i] > word[i])
                return false;
        }
        return true;
    }
}
