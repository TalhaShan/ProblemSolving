package STRIVER_SHEET.Arrays;

import java.util.Arrays;

public class LongestConsecutiveSquenece {
    public int longestConsecutive(int[] nums) {
   if (nums == null || nums.length == 0) {
            return 0;
        }

        Arrays.sort(nums);
        int prev = nums[0];
        int current = 1;
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == prev + 1) {
                current++;
                count = Math.max(count, current);
            } else if (nums[i] != prev) {
                current = 1;
            }
            prev = nums[i];

        }

        return count;
}
}