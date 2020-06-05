package Sorting_Algorithm;

public class BubbleSort {
    public void bubbleSort(int[] a){
        int len = a.length;
        for(int i = 0; i < len - 1; i++){
            for(int j = 0; j < len - i - 1; j++){
                if(a[j] > a[j + 1]){
                    int temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = a[j];
                }
            }
        }
    }
}
