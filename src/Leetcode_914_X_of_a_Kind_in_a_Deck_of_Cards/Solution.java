package Leetcode_914_X_of_a_Kind_in_a_Deck_of_Cards;

class Solution {
    public boolean hasGroupsSizeX(int[] deck) {
        // find common divisor of counts of each unique number
        // gcd
        int[] a = new int[10000];
        for(int n : deck){
            a[n]++;
        }
        int x = 0;
        for(int n : a){
            if(n > 0){
                x = gcd(x, n);
                if(x == 1) return false;
            }
        }
        return true;
    }
    private int gcd(int a, int b){
        return b == 0 ? a : gcd(b, a % b);
    }
}
