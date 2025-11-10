package binarySearch;

public class FirstAndLastOccurrence {
    public int[] searchRange(int[] nums, int target) {
        int[] res = { -1, -1 };

        int first = findFirstOccurrence(nums, target, nums.length);

        if (first == -1)
            return res; //no need to perform for last as target no exist

        int last = findLastOccurrence(nums, target, nums.length);
        res[0] = first;
        res[1] = last;
        return res;
    }

    private int findFirstOccurrence(int[] nums, int target, int length) {
        int low = 0;
        int high = length - 1;
        int first = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                first = mid;
                high = mid - 1;
            } else if (nums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return first;
    }

    private int findLastOccurrence(int[] nums, int target, int length) {

        int low = 0;
        int high = length - 1;
        int last = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                last = mid;
                low = mid + 1;
            } else if (nums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return last;
    }
}
