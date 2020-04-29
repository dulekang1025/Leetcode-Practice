package Leetcode_744_Find_Smallest_Letter_Greater_Than_Target;

class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        int low = 0;
        int high = letters.length - 1;
        int mid = 0;
        while(low < high){
            mid = low + (high - low) / 2;
            if(letters[mid] > target) high = mid;
            else low = mid + 1;
        }
        return low == letters.length - 1 && letters[low] <= target ? letters[0] : letters[low];
    }
}
