package Sorting;

import java.util.Arrays;

public class CyclicSort {
    static void cyclicSort(int[] arr) {
        int i = 0;
        while (i <= arr.length - 1) {
            {
                int index = arr[i] - 1;
                if (index != i) {
                    swap(arr, i, index);
                }
                i++;
            }
        }

        System.out.println(Arrays.toString(arr));
    }


    public static void cyclicSortK(int arr[]){
        int i =0 ;
        while (i<arr.length){
            int correct = arr[i]-1;
            if(arr[i]!=arr[correct]){
                swap(arr,i,correct);
            }else {
                i++; //both already at  right  index move correct and index points to same location
            }
        }
        System.out.println(Arrays.toString(arr));
    }
    private static void swap(int[] arr, int i, int index) {
        int temp = arr[i];
        arr[i] = arr[index];
        arr[index] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {5,4,3,2,1};
        cyclicSort(arr);
        cyclicSortK(arr);

    }
}