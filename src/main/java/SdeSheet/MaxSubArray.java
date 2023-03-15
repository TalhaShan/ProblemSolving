package SdeSheet;

public class MaxSubArray {
    public int maxSubArray(int[] nums) {

        int maxSum = Integer.MIN_VALUE;
        int maxSoFar  = 0;
        for(int i=0; i<nums.length; i++){

            maxSoFar+=nums[i];
            maxSum = Math.max(maxSoFar,maxSum);
            if(maxSoFar<=0){
                maxSoFar = 0;
            }
        }
        return maxSum;
    }
}
