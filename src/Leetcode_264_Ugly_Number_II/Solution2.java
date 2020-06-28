package Leetcode_264_Ugly_Number_II;

class Solution2 {
    class Ugly{
        int[] arr = new int[1690];
        int p2 = 0, p3 = 0, p5 = 0;
        public Ugly(){
            arr[0] = 1;
            for(int i = 1; i < 1690; i++){
                int ugly = Math.min(arr[p2] * 2, Math.min(arr[p3] * 3, arr[p5] * 5));
                arr[i] = ugly;
                if(arr[i] == arr[p2] * 2) p2++;
                if(arr[i] == arr[p3] * 3) p3++;
                if(arr[i] == arr[p5] * 5) p5++;
            }
        }
    }
    public int nthUglyNumber(int n) {
        Ugly ugly = new Ugly();
        return ugly.arr[n - 1];
    }
}
