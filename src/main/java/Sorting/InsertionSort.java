package Sorting;

import java.util.Arrays;

public class InsertionSort {

    static void insertionSort(int[] arr) {
        for (int i = 0; i <=arr.length - 2; i++) {  // or <arr.length -1
            for (int j = i + 1; j >0; j--) {
                if (arr[j] > arr[j - 1]) {
                    break;
                }
                swapped(arr, j, j - 1);
            }
        }
        System.out.println(Arrays.toString(arr));
    }

    private static void swapped(int[] arr, int curr, int prev) {
        int temp = arr[curr];
        arr[curr] = arr[prev];
        arr[prev] = temp;
    }

    public static void main(String[] args) {
        int arr[] = {5,4,3,2,1};
        insertionSort(arr);
    }
}
