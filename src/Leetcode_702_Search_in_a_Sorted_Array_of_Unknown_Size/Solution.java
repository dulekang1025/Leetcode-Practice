package Leetcode_702_Search_in_a_Sorted_Array_of_Unknown_Size;
class ArrayReader {
    public int get(int index) {return 0;}
 }
class Solution {
    public int search(ArrayReader reader, int target) {
        int low = 0, high = 9999;
        while(low <= high){
            int mid = low + (high - low) / 2;
            int n = reader.get(mid);
            if(n == Integer.MAX_VALUE){
                high = mid - 1;
                continue;
            }
            if(target == n) return mid;
            else if(n < target){
                low = mid + 1;
            }else if(n > target){
                high = mid - 1;
            }
        }
        return -1;
    }
}
