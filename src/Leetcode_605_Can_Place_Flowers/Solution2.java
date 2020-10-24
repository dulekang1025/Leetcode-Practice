package Leetcode_605_Can_Place_Flowers;

public class Solution2 {
    // 防御式编程思想：在 flowerbed 数组两端各增加一个 0，
    // 这样处理的好处在于不用考虑边界条件，任意位置处只要连续出现三个 0 就可以栽上一棵花。
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int[] arr = new int[flowerbed.length + 2];
        int count = 0;
        arr[0] = 0;
        arr[arr.length - 1] = 0;
        for(int i = 0; i < flowerbed.length; i++){
            arr[i + 1] = flowerbed[i];
        }
        for(int i = 1; i <= flowerbed.length; i++){
            if(arr[i - 1] == 0 && arr[i] == 0 && arr[i + 1] == 0){
                arr[i++] = 1;
                count++;
            }
            if(count >= n) return true;
        }
        return false;
    }
}
