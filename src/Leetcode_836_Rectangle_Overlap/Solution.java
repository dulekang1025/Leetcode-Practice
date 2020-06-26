package Leetcode_836_Rectangle_Overlap;

class Solution {
    //       - - - - (x2, y2)
    //      |           |
    //      |    rec1   |
    //   (x1, y1) - - - -
    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        if(rec2[0] >= rec1[2] || rec1[1] >= rec2[3] || rec1[0] >= rec2[2] || rec1[3] <= rec2[1]){
            return false;
        }
        return true;
    }
}
