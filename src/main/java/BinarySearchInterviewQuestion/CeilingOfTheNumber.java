package BinarySearchInterviewQuestion;

public class CeilingOfTheNumber {

    public static int searchInsert(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;

        while (start <= end) {
            int middle = start + (end - start) / 2;
            if (target == nums[middle]) {
                return middle;
            } else if (target > nums[middle]) {
                start = middle + 1;
            } else{
                end = middle - 1;
            }

        }
        return start;

    }

    public static void main(String[] args) {
        int nums[] = {2, 3, 5, 9, 14, 16, 18};
        int target = 15;
        System.out.println(searchInsert(nums, target));
    }

}
