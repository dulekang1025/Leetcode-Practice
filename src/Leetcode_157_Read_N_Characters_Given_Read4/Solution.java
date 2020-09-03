package Leetcode_157_Read_N_Characters_Given_Read4;

//public class Solution extends Reader4 {
//    /**
//     * @param buf Destination buffer
//     * @param n   Number of characters to read
//     * @return    The number of actual characters read
//     */
//    public int read(char[] buf, int n) {
//        char[] temp = new char[4];
//        int res = 0;
//        int index = 0;
//        while(index < n){
//            int c = read4(temp);
//            for(int i = 0; i < c && index < n; i++){
//                buf[index++] = temp[i];
//                res++;
//            }
//            if(c < 4) break;
//        }
//        return Math.min(res, n);
//    }
//}

