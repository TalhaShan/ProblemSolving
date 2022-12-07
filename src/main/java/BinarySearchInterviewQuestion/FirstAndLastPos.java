package BinarySearchInterviewQuestion;

public class FirstAndLastPos {


    public static  int[] searchRange(int[] nums, int target) {
        int[] ans = {-1,-1};
        if(nums.length==0){return  ans;}
        ans[0] = findAnswer(nums,target,true);
        if(ans[0]!=-1) {
            ans[1] = findAnswer(nums, target, false);
        }
        return ans;
    }

    static int findAnswer(int[] nums, int target, boolean firstOccur) {
        int ans = -1;
        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {

            int mid = start + (end - start) / 2;
            if (target < nums[mid]) {
                end = mid - 1;
            } else if (target > nums[mid]) {
                start = mid + 1;
            } else {
                ans = mid;
                if (firstOccur) {
                    //potential ans mid  = = target
                    end = mid-1;
                } else {
                    start = mid+1;
                }
            }
        }
        return ans;
    }


    public static void main(String[] args) {
        int num[]=  {5,7,7,8,8,10};
        int target = 8;
        System.out.println(searchRange(num,target));

    }
}
