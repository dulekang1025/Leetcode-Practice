package Sorting_Algorithm;

public class BubbleSort {
    public static void bubbleSort(int[] a){
        int len = a.length;
        for(int i = 0; i < len - 1; i++){
            for(int j = 0; j < len - i - 1; j++){
                if(a[j] > a[j + 1]){
                    int temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {4,7,9,1,0,23,56,12,2,11,-1,3,100,99};
        bubbleSort(arr);
        for(int n : arr)
            System.out.print(n + " ");
    }
}
