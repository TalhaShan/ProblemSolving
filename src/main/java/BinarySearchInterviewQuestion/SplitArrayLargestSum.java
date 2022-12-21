package BinarySearchInterviewQuestion;

public class SplitArrayLargestSum {

    public int splitArray(int[] nums, int k) {

        int max = 0;
        int sum =  0 ;
        int ans =  0;
        for(int val: nums){
            sum += val;
            max = Math.max(max,val);
        }
        if(k==nums.length){
            return max;
        }
        int low = max;
        int high = sum;
        while (low<=high){
            int mid =  low  + (high-low)/2;
            if(isPossible(nums,mid,k)){
                ans = mid;
                high = mid-1;
            }else{
                low = mid+1;
            }
        }
        return  ans;

    }

    private boolean isPossible(int[] nums, int mid, int k) {
        int sa =1 ;
        int sum =  0;
        for(int i =0; i<nums.length; i++){
            sum+=nums[i];
            if(sum>mid){
                sa++;
                sum = nums[i];
            }
        }
        return sa<=k;
    }

    public static void main(String[] args) {

    }
}
