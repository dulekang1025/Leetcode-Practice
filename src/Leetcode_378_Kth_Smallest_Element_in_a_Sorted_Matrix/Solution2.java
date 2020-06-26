package Leetcode_378_Kth_Smallest_Element_in_a_Sorted_Matrix;

class Solution2 {
    public int kthSmallest(int[][] matrix, int k) {
        // find lower bound
        int n = matrix.length;
        int low = matrix[0][0];
        int high = matrix[n - 1][n - 1];
        while(low < high){
            int mid = low + (high - low) / 2;
            if(count(matrix, mid) >= k){
                high = mid;
            }else{
                low = mid + 1;
            }
        }
        return low;
    }
    private int count(int[][] matrix, int mid){
        int count = 0;
        int n = matrix.length - 1;
        int i = n;
        int j = 0;
        while(i >= 0 && j <= n){
            if(matrix[i][j] <= mid){
                count += i + 1;
                j++;
            }else{
                i--;
            }
        }
        return count;
    }
}
