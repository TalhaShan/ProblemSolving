package BinarySearchInterviewQuestion;

public class AllocatingMinimumNumberPages {

    static int findPages(int[] nums, int n, int m) {
        int sum = 0;
        int max = 0;
        for (int val : nums) {
            sum += val;
            max = Math.max(max, val);
        }
        int high = sum;
        int low = max;
        int ans = 0;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (isPossible(nums, mid, m)) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }

    private static boolean isPossible(int[] nums, int mid, int m) {
        int ans = 0;
        int sa = 1;
        for (int i = 0; i < nums.length; i++) {
            ans += nums[i];
            if (ans > mid) {
                sa++;
                ans = nums[i];
            }
        }

        return sa <= m;
    }

    public static void main(String[] args) {
        int arr[] = {12, 34, 67,
                90}; // Number of pages in books

        int m = 2; // No. of students

        System.out.println("Minimum number of pages = "
                + findPages(arr, arr.length, m));
    }
}

