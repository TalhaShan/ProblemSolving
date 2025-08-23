package SlidingWindows;

public class MaxConsecutiveOnesIII {

    public int longestOnes(int[] nums, int k) {  //T->0(2N) ,S->O(1)
        int maxLen = 0;
        int left = 0, right = 0;
        int N = nums.length;
        int zerosCount = 0;
        while (right < N) {
            if (nums[right] == 0) {
                zerosCount++;
            }
            while (zerosCount > k) {
                if (nums[left] == 0) {
                    zerosCount--;
                }
                left++;
            }
            maxLen = Math.max(maxLen, right - left + 1);
            right++;
        }
        return maxLen;
    }

    public int longestOnesOptimal(int[] nums, int k) {  //T->0(N) ,S->O(1)
        int maxLen = 0;
        int left = 0, right = 0;
        int N = nums.length;
        int zerosCount = 0;
        while (right < N) {
            if (nums[right] == 0) {
                zerosCount++;
            }
        if(zerosCount>k){
            if(nums[left]==0){
                zerosCount--;
            }
            left++;
        }
        if(zerosCount<=k){
            maxLen = Math.max(maxLen,right-left+1);
        }
            right++;
        }
        return maxLen;
    }
}
