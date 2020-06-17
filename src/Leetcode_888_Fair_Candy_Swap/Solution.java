package Leetcode_888_Fair_Candy_Swap;

class Solution {
    public int[] fairCandySwap(int[] A, int[] B) {
        int[] res = new int[2];
        int sumA = 0, sumB = 0;
        for(int n : A) sumA += n;
        for(int n : B) sumB += n;
        int diff = sumA > sumB ? sumA - sumB : sumB - sumA;
        diff /= 2;
        int[] arr1 = sumA > sumB ? A : B;
        int[] arr2 = sumA > sumB ? B : A;
        for(int i = 0; i < arr1.length; i++){
            for(int j = 0; j < arr2.length; j++){
                if(arr1[i] - arr2[j] == diff){
                    if(arr1 == A){
                        res[0] = arr1[i];
                        res[1] = arr2[j];
                    }else{
                        res[0] = arr2[j];
                        res[1] = arr1[i];
                    }
                }
            }
        }
        return res;
    }
}
