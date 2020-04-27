package Leetcode_374_Guess_Number_Higher_or_Lower;

public class Solution extends GuessGame {
    public int guessNumber(int n) {
        int low = 1;
        int high = n;
        int mid = 0;
        while(low < high){
            mid = low + (high - low) / 2;
            if(guess(mid) == -1){
                high = mid - 1;
            }else if(guess(mid) == 1){
                low = mid + 1; // mid - 1???
            }else{
                return mid;
            }
        }
        return low;
    }
}

class GuessGame{
    public int guess(int n){
        return 0;
    }
}