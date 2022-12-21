package BinarySearchInterviewQuestion;

import java.util.Arrays;

public class SearchInRotatedSortedArrayTwoDuplicates {
    static public boolean search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) return true;
            else if (nums[mid] > nums[left]) {
                //first try official left
                if (target <= nums[mid] && target >= nums[left]) {
                    right = mid - 1;
                    //squeeze rigt
                } else {
                    //sequzee left no other option
                    left = mid + 1;
                }
            } else if (nums[mid] < nums[left]) {
                //official right part
                if (target >= nums[mid] && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }else{
                //duplicated spotted
                left++;
            }
        }
        return  false;
    }

    public static void main(String[] args) {
        int nums[] = {1, 0, 1, 1, 1};
        int target = 0;
        System.out.println(search(nums, target));
    }
}
