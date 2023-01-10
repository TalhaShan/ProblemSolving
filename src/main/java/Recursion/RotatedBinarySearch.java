package Recursion;

public class RotatedBinarySearch {

    static int findBS(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;
        while (start < end) {
            int mid = start + (end - start) / 2;

            if (arr[mid] == target) {
                return mid;
            }
            if (arr[start] > arr[mid] && target < arr[mid]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }

            if (target > arr[mid] && target < arr[end]) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return -1;
    }


    static int findBSRecursive(int[] arr, int target, int s, int e) {

        if (s > e) {
            return -1;
        }
        int mid = s + (e - s) / 2;
        if (arr[mid] == target) {
            return mid;
        }
        if(arr[s]<=arr[mid]){
            if(target<=arr[mid] && target>=arr[s]){
                return findBSRecursive(arr,target,s,mid-1);

            }else {
                return findBSRecursive(arr,target,mid+1,e);
            }

        }else if(target>=arr[mid] && target <=arr[e]){
            return findBSRecursive(arr,target,mid+1,e);

        }else {
            return findBSRecursive(arr,target,s,mid-1);
        }

    }

    public static void main(String[] args) {
        int arr[] = {5,6,6,8,9,1,1,2,2,3};
        System.out.println(findBSRecursive(arr,3,0, arr.length-1));
    }
}
