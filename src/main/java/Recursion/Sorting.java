package Recursion;

import java.util.Arrays;

public class Sorting {

    static void bubbleSort(int[] arr, int row, int col) {
        if (row == 0) {
            return;
        }
        if (col < row) {
            if (arr[col] > arr[col + 1]) {
                int temp = arr[col];
                arr[col] = arr[col + 1];
                arr[col + 1] = temp;
            }
            bubbleSort(arr, row, col + 1);
        } else {
            bubbleSort(arr, row - 1, 0);
        }
    }


    static void selectionSort(int[] arr, int row, int col, int max) {

        if (row == 0) {
            return;
        }
        if (col < row) {

            if (arr[col] > arr[max]) {
                selectionSort(arr, row, col + 1, col);
            } else {
                selectionSort(arr, row, col + 1, max);
            }
        } else {
            int temp = arr[max];
            arr[max] = arr[row - 1];
            arr[row - 1] = temp;
            selectionSort(arr, row - 1, 0, 0);
        }
    }

    static int[] mergeSort(int[] arr) {
        if (arr.length == 1) {
            return arr;
        }
        int mid = arr.length / 2;
        int[] left = mergeSort(Arrays.copyOfRange(arr, 0, mid));
        int[] right = mergeSort(Arrays.copyOfRange(arr, mid, arr.length));

        return merge(left, right);
    }

    private static int[] merge(int[] left, int[] right) {
        int i = 0, j = 0, k = 0;
        int[] mix = new int[left.length + right.length];
        while (i < left.length && j < right.length) {
            if (left[i] < right[j]) {
                mix[k] = left[i];
                i++;
            } else {
                mix[k] = right[j];
                j++;
            }
            k++;

        }
        while (i < left.length) {
            mix[k] = left[i];
            k++;
            i++;
        }
        while (j < right.length) {
            mix[k] = right[j];
            k++;
            j++;

        }

        return mix;
    }

    public static void main(String[] args) {
        int[] arr = {8, 3, 4, 12, 5, 6};
        //   bubbleSort(arr, arr.length - 1, 0);
//        selectionSort(arr, arr.length , 0, 0);
//        System.out.println(Arrays.toString(arr));

        System.out.println(Arrays.toString(mergeSort(arr)));

    }
}
