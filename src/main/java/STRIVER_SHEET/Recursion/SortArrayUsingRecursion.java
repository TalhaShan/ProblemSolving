package com.demo.project;

import java.util.List;

public class SortArrayUsingRecursion {
    public static void sort(List<Integer> arr) {

        if (arr.size() <= 1) {
            return;
        }

        int temp = arr.get(arr.size() - 1);
        arr.remove(arr.size() - 1);

        //or int temp = list.remove(list.size() - 1);

        sort(arr);
        insert(arr, temp);
    }

    public static void insert(List<Integer> arr, int temp) {

        if (arr.size() == 0 || arr.get(arr.size() - 1) <= temp) {
            arr.add(temp);
            return;
        }
        int val = arr.remove(arr.size() - 1);
        insert(arr, temp);
        arr.add(val);
    }

    public class RecursiveSortWithArray {


        // Sort function
        public static void sort(int[] arr, int size) {
            if (size == 1) {
                return;
            }

            int temp = arr[size - 1];
            sort(arr, size - 1); //in array instead of remove do this
            insert(arr, temp, size - 1);
        }

            // Insert function
            public static void insert(int[] arr, int temp, int size) {
                if (size == 0 || arr[size - 1] <= temp) {
                    arr[size] = temp; // insert at the end
                    return;
                }

                int val = arr[size - 1];
                insert(arr, temp, size - 1);
                arr[size] = val;
            }
        }

}
