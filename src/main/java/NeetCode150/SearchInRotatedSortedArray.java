package NeetCode150;

public class SearchInRotatedSortedArray {

    //niki
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {

            int mid = left + (right - left) / 2;

            // Check if the middle element is greater
            // than the right element
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return nums[left]; //property of rotates sorted array
    }

//st
    public int findMin2(int[] arr) {
        int n = arr.length-1;

        int low = 0;
        int high = n;
        int ans = Integer.MAX_VALUE;
        while (low <= high) {  //low <=high means to handle case for 2 elements as well in array
            int mid = low + (high - low) / 2;
            //Optimization extra
            if(arr[low]<=arr[high]){
                ans = Math.min(ans,arr[low]);
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
