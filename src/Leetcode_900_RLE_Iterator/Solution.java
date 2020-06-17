package Leetcode_900_RLE_Iterator;

class RLEIterator {

    int[] arr;
    int index;

    public RLEIterator(int[] A) {
        this.arr = A;
        this.index = 0;
    }

    public int next(int n) {
        while(n > 0){
            if(index >= arr.length) return -1;
            int cur = arr[index];
            if(cur > n){
                arr[index] -= n;
                n -= cur;
                return arr[index + 1];
            }else if(cur < n){
                n -= cur;
                arr[index] = 0;
                index += 2;
            }else{
                n = 0;
                arr[index] = 0;
                index += 2;
                return arr[index - 1];
            }
        }
        return -1;
    }
}

/**
 * Your RLEIterator object will be instantiated and called as such:
 * RLEIterator obj = new RLEIterator(A);
 * int param_1 = obj.next(n);
 */
