package BinarySearchInterviewQuestion;

public class SearchInRotatedSortedII {

    static public boolean search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) return true;
            if (nums[mid] > nums[left]) {
                if (nums[left] <= target && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else if (nums[mid] < nums[left]) {
                if (nums[mid] <= target && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            } else {
                left++;// move a step ahead. cause  there is no gaurantee the target will show on which part. cause the shap of first part[left, mid] is not decided.
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int nums[] = {1, 0, 1, 1, 1};
        //        int nums[] = {4, 5, 6, 7, 0, 1, 2};
        int target = 0;
        System.out.println(search(nums, target));
    }
}
