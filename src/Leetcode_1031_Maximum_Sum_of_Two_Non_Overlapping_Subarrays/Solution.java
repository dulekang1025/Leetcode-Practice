package Leetcode_1031_Maximum_Sum_of_Two_Non_Overlapping_Subarrays;

class Solution {
    public int maxSumTwoNoOverlap(int[] A, int L, int M) {
        int lSum = 0, initMSum = 0;
        for(int i = 0; i < L - 1; i++){
            lSum += A[i];
        }
        for(int i = 0; i < M - 1; i++){
            initMSum += A[i];
        }
        int lRight = L - 1, lLeft = 0;
        int res = -1;
        while(lRight < A.length){
            lSum += A[lRight];
            int mRight = M - 1, mLeft = 0;
            int mSum = initMSum;
            while(mRight < A.length){
                mSum += A[mRight];
                if(mRight < lLeft || mLeft > lRight){
                    int sum = lSum + mSum;
                    //System.out.println(lLeft + " " + lRight + ", " + mLeft + " " + mRight);
                    if(sum > res){
                        res = sum;
                    }
                }
                mSum -= A[mLeft];
                mRight++;
                mLeft++;
            }
            lSum -= A[lLeft];
            lRight++;
            lLeft++;
        }
        return res;
    }
}