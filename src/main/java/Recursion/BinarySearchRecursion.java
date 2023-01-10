package Recursion;

public class BinarySearchRecursion {

    public static void main(String[] args) {
        int arr[] = {10, 20, 30, 40, 100};
        System.out.println(BS(arr, 100, 0, arr.length - 1));
    }

    static int BS(int arr[], int target, int start, int end) {

        if (start > end) {
            return -1;
        }

        int mid = start + (end - start) / 2;
        if (target == arr[mid]) {
            return mid;
        }
        if (target < arr[mid]) {
            return BS(arr, target, start, mid - 1);
        }

        return BS(arr, target, mid + 1, end);


    }
}
