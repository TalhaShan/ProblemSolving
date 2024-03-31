package DSAShardaAman;

public class MinimumInRotatedSortedArray {
    public int findMin(int[] arr) {
        int n = arr.length - 1;

        int low = 0;
        int high = n;
        int ans = Integer.MAX_VALUE;
        while (low <= high) {  //low <=high means to handle case for 2 elements as well in array
            int mid = low + (high - low) / 2;
            //Optimization extra
            if (arr[low] <= arr[high]) {
                ans = Math.min(ans, arr[low]);
                break;
            }
            if (arr[low] <= arr[mid]) {
                //left sorted eliminate left and pick low
                ans = Math.min(ans, arr[low]);
                low = mid + 1;
            } else {
                //if not left then right is sorted , that's property of rotated sorted array
                ans = Math.min(ans, arr[mid]);
                high = mid - 1;
            }
        }
        return ans;
    }
}
