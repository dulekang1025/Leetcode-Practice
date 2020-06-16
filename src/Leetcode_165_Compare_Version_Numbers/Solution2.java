package Leetcode_165_Compare_Version_Numbers;

class Solution2 {
    public int compareVersion(String version1, String version2) {
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");
        int len1 = v1.length;
        int len2 = v2.length;
        for(int i = 0; i < Math.max(len1, len2); i++){
            int a = (i < len1 ? Integer.parseInt(v1[i]) : 0);
            int b = (i < len2 ? Integer.parseInt(v2[i]) : 0);
            if(a < b) return -1;
            else if(a > b) return 1;
        }
        return 0;
    }
}
