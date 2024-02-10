package DSAShardaAman;



public class SearchInRotateSorted {

    //intuition
    // format = [ascending,pivot,ascending];
    //i.e  [3,4,5,6,7,0,1,2]
    //pivot is 7 here

    //kunal khuswa


    private static int findTarget(int[] arr, int target) {

        int pivot = findPivot(arr);

        if (pivot == -1) {
            return binarySearch(arr, target, 0, arr.length - 1);
        }
        if (target == arr[pivot]) {
            return pivot;
        } else if (target >= arr[0]) {
            return binarySearch(arr, target, 0, pivot - 1);
        }
        return binarySearch(arr, target, pivot + 1, arr.length - 1);
    }

    private static int findPivot(int[] arr) {
        //pivot find largest
        //the shift of series from asc desc asc
//        4 5 6 7 0 1 2 3
        int start = 0;
        int end = arr.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (mid > start && arr[mid] < arr[mid - 1]) {
                return mid - 1;
            }
            if (mid < end && arr[mid] > arr[mid + 1]) {
                return mid;
            }
            if (arr[mid] <= arr[start]) {
                end = mid - 1;
            }
            start = mid + 1;
        }

        return -1;
    }

    static int binarySearch(int[] arr, int target, int start, int end) {
        while (start <= end) {
            // find the middle element
//            int mid = (start + end) / 2; // might be possible that (start + end) exceeds the range of int in java
            int mid = start + (end - start) / 2;

            if (target < arr[mid]) {
                end = mid - 1;
            } else if (target > arr[mid]) {
                start = mid + 1;
            } else {
                // ans found
                return mid;
            }
        }
        return -1;
    }
}
