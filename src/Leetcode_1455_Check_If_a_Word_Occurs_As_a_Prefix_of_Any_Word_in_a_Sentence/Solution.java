package Leetcode_1455_Check_If_a_Word_Occurs_As_a_Prefix_of_Any_Word_in_a_Sentence;

class Solution {
    public int isPrefixOfWord(String sentence, String searchWord) {
        int ans = -1;
        int len = searchWord.length();
        String[] words = sentence.split(" ");
        for(int i = 0; i < words.length; i++){
            if(words[i].length() >= len && words[i].substring(0, len).equals(searchWord)){
                ans = i + 1;
                break;
            }
        }
        return ans;
    }
}
