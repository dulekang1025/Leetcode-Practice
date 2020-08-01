package Leetcode_520_Detect_Capital;

public class Solution2 {
    public boolean detectCapitalUse(String word) {
        if(word.length() == 1) return true;
        boolean first = false;
        boolean othersCap = false;
        boolean othersLow = false;
        // FlaG
        for(int i = 0; i < word.length(); i++){
            if(i == 0 && Character.isUpperCase(word.charAt(i))) first = true;
            else if(i != 0 && Character.isUpperCase(word.charAt(i))) othersCap = true;
            else if(i != 0 && !Character.isUpperCase(word.charAt(i))) othersLow = true;
        }
        if(first){
            if((othersCap && !othersLow) || (!othersCap && othersLow)) return true;
            else return false;
        }else{
            if(!othersCap && othersLow) return true;
            else return false;
        }
    }
}
