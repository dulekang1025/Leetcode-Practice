package Leetcode_299_Bulls_and_Cows;

class Solution {
    public String getHint(String secret, String guess) {
        int a = 0, b = 0;
        int[] mapA = new int[10];
        int[] mapB = new int[10];
        for(int i = 0; i < secret.length(); i++){
            int s = secret.charAt(i) - '0';
            int g = guess.charAt(i) - '0';
            if(s == g) a++;
            mapA[s]++;
            mapB[g]++;
        }
        for(int i = 0; i < 10; i++){
            b += Math.min(mapA[i], mapB[i]);
        }
        return a + "A" + (b - a) + "B";
    }
}
