package Leetcode_165_Compare_Version_Numbers;

public class Solution3 {
    public int compareVersion(String version1, String version2) {
        String[] arr1 = version1.split("\\.");
        String[] arr2 = version2.split("\\.");
        int i = 0, j = 0;
        while(i < arr1.length && j < arr2.length){
            int n1 = Integer.valueOf(arr1[i]);
            int n2 = Integer.valueOf(arr2[j]);
            if(n1 > n2) return 1;
            if(n1 < n2) return -1;
            i++;
            j++;
        }
        while(i < arr1.length){
            if(Integer.valueOf(arr1[i]) > 0) return 1;
            i++;
        }
        while(j < arr2.length){
            if(Integer.valueOf(arr2[j]) > 0) return -1;
            j++;
        }
        return 0;
    }
}
