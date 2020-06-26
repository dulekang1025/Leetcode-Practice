package Leetcode_223_Rectangle_Area;

class Solution {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int area1 = (C - A) * (D - B);
        int area2 = (G - E) * (H - F);
        if(C <= E || D <= F || G <= A || H <= B){
            return area1 + area2;
        }
        int upperX = Math.min(C, G);
        int upperY = Math.min(D, H);
        int bottomX = Math.max(A, E);
        int bottomY = Math.max(B, F);
        return area1 - (upperX - bottomX) * (upperY - bottomY) + area2;
    }
}
