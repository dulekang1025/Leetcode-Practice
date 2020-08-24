package Leetcode_605_Can_Place_Flowers;

public class Solution2 {
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
