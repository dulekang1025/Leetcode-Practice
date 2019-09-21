package Leetcode_1122_Relative_Sort_Array;

class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int[] res = new int[arr1.length];
        int r = 0;
        for(int i = 0; i < arr2.length; i++){
            int p = arr2[i];
            for(int j = 0; j < arr1.length; j++){
                if(p == arr1[j]){
                    res[r] = p;
                    r++;
                    arr1[j] = -1;
                }
            }
        }

        while(r < arr1.length){
            int l = 1001;
            int li = 0;
            for(int i = 0; i < arr1.length; i++){
                if(arr1[i] != -1 && l > arr1[i]){
                    l = arr1[i];
                    li = i;
                }
            }
            res[r] = l;
            r++;
            arr1[li] = -1;
        }

        return res;
    }
}
