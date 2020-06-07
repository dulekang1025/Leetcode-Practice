package Sorting_Algorithm;

public class SelectSort {
    public static void selectSort(int[] arr){
        int len = arr.length;
        for(int i = 0; i < len - 1; i++){
            int minIndex = i;
            for(int j = i + 1; j < len; j++){
                if(arr[minIndex] > arr[j]){
                    minIndex = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }
    }

    public static void main(String[] args) {
        int[] arr = {4,7,9,1,0,23,56,12,2,11,-1,3,100,99};
        selectSort(arr);
        for(int n : arr)
            System.out.print(n + " ");
    }
}
