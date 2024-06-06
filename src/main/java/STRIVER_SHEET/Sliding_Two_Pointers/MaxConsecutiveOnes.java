package STRIVER_SHEET.Sliding_Two_Pointers;

public class MaxConsecutiveOnes {
    public int longestOnesNaive(int[] nums, int k) {
        int maxLen = 0;
        for (int i = 0; i < nums.length; i++) {
            int zeroCount = 0;
            for (int j = i; j < nums.length; j++) {

                if (nums[j] == 0) {
                    zeroCount++;
                }
                if (zeroCount <= k) {
                    maxLen = Math.max(maxLen, j - i + 1);
                } else {
                    break;
                }
            }
        }
        return maxLen;
    }

    public static int longestOnesNaiveTwoPointers(int[] nums, int k) {
        int left = 0;
        int right = 0;
        int N = nums.length;
        int maxLen = 0;
        int zCount = 0;
        while (right < N) {
            if (zCount <= k) {
                if (nums[right] == 0) {
                    zCount++;
                }
                if (zCount > k) {
                    right++;
                    continue;
                }
                maxLen = Math.max(maxLen, right - left + 1);
                right++;

            } else {
                while (zCount > k) {
                    if (nums[left] == 0) {
                        zCount--;
                    }
                    left++;
                }
            }

        }
        return maxLen;
    }

    public static int longestOnesOptimal(int[] nums, int k) {
        int left = 0;
        int right = 0;
        int N = nums.length;
        int maxLen = 0;
        int zCount = 0;
        while (right < N) {
            if (nums[right] == 0) {
                zCount++;
            }
            if (zCount > k) {
                if (nums[left] == 0) zCount--;
                left++;
            }
            if (zCount <= k) {
                maxLen = Math.max(maxLen, right - left + 1);
            }
            right++;
        }
        return maxLen;
    }

    public static void main(String[] args) {
        System.out.println(longestOnesNaiveTwoPointers(new int[]{1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0}, 2));
    }
}
