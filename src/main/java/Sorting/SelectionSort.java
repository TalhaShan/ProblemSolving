package Sorting;

import java.util.Arrays;

public class SelectionSort {
        //finding the max and placing in it last
        //then finding the 2nd max and placing in it 2nd last
    //so on
    public static void selectionSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int last = arr.length - i - 1;
            int maxIndex = findMaxIndex(arr, last); //find max element at which index with in given range
            swapped(arr, maxIndex, last);
        }
        System.out.println(Arrays.toString(arr));
    }

    private static void swapped(int[] arr, int max, int last) {
        int temp = arr[max];
        arr[max] = arr[last];
        arr[last] = temp;
    }

    private static int findMaxIndex(int[] arr, int last) {
        int max = 0;
        for (int i = 0; i <= last; i++) {
            if (arr[max] < arr[i]) {
                max = i;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int arr[] = {5, 4, 3, 2, 1};
        selectionSort(arr);
    }
}