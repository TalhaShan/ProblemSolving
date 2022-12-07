package BinarySearchInterviewQuestion;

public class TargetInInfiniteArray {
    static int ans(int arr[],int target){
        int start = 0;
        int end = 1;

        while (target>arr[end]){
            int temp = end+1;
            end = end+(end-start+1)*2;
            start = temp+1;
        }
        return  binarySearchOn(arr,start,end,target);
    }

    private static int binarySearchOn(int[] arr, int start, int end, int target) {

        while(start <= end) {
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
    public static void main(String[] args) {
        int[] arr = {3, 5, 7, 9, 10, 90,
                100, 130, 140, 160, 170};
        int target = 10;
        System.out.println(ans(arr, target));
    }
}
