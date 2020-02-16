package Leetcode_383_Ransom_Note;

class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] temp = new int[26];
        for(int i = 0; i < magazine.length(); i++) ++temp[magazine.charAt(i) - 'a'];
        for(int i = 0; i < ransomNote.length(); i++){
            if(--temp[ransomNote.charAt(i) - 'a'] < 0) return false;
        }
        return true;
    }
}
