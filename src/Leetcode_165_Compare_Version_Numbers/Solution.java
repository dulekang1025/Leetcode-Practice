package Leetcode_165_Compare_Version_Numbers;

class Solution {
    public int compareVersion(String version1, String version2) {
        if(version1.equals("") && version2.equals("")) return 0;
        if(version1.equals("") || version2.equals("")){
            return version1.equals("") ? -1 : 1;
        }
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");
        int len1 = v1.length;
        int len2 = v2.length;
        int i = 0;
        while(len1 > 0 && len2 > 0){
            int n1 = Integer.parseInt(v1[i]);
            int n2 = Integer.parseInt(v2[i]);
            System.out.println(n1 + " " + n2);
            if(n1 > n2) return 1;
            else if(n1 < n2) return -1;
            i++;
            len1--;
            len2--;
        }
        //System.out.println(len1 + " " + len2);
        if(len1 > 0){
            while(len1 > 0){
                if(Integer.parseInt(v1[i]) > 0) return 1;
                i++;
                len1--;
            }
        }else if(len2 > 0){
            while(len2 > 0){
                if(Integer.parseInt(v2[i]) > 0) return -1;
                i++;
                len2--;
            }
        }
        return 0;
    }
}
