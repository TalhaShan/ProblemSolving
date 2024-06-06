package STRIVER_SHEET.Arrays;

public class KandensAlgorithm {
    public static int maxSubArray(int[] nums) {

        int maxSum = Integer.MIN_VALUE;
        int maxSoFar = 0;
        for (int i = 0; i < nums.length; i++) {

            maxSoFar += nums[i];
            maxSum = Math.max(maxSoFar, maxSum);
            if (maxSoFar <= 0) {
                maxSoFar = 0;
            }
        }
        return maxSum;
    }

    public static void main(String[] args) {
        int a[] = {4, -1, 2, 1};
        System.out.println(maxSubArray(a));
    }
}
