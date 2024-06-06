package STRIVER_SHEET.Arrays;

public class MaxProductSubArray {
    public static int maxProduct(int[] nums) {
        int prefix = 1;
        int suffix = 1;
        int n = nums.length;
        int ans = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (prefix == 0) prefix = 1;  // To handle zero values encountered
            if (suffix == 0) suffix = 1;

            prefix = prefix * nums[i];
            suffix = suffix * nums[n - i - 1];
            ans = Math.max(ans, Math.max(prefix, suffix));
        }
        return ans;
    }
}
