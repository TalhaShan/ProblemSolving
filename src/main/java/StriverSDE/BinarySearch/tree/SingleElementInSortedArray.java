package tree;

public class SingleElementInSortedArray {

    public int singleNonDuplicate(int[] nums) {
        int n = nums.length;

        if(n==0) return nums[0];

        int start=0;
        int end= n-1;
        while (start<=end){
            int mid = start + (end-start)/2;
            if(mid==0 && nums[0]!=nums[1]) return  nums[mid];
            if(mid == n-1 && nums[n-1]!=nums[n-2]) return  nums[mid];

            //base check
            if(nums[mid-1]!=nums[mid] && nums[mid]!=nums[mid+1]) return nums[mid];

            if(mid%2 == 0){ //event number elements on both side
                if(nums[mid-1]==nums[mid]){
                    end = mid-1;
                }else{
                    start = mid+1;
                }


            }else{ //odd number elements on both side
                if(nums[mid-1] == nums[mid]){
                    start = mid+1;
                }else {
                    end = mid+1;
                }
            }
        }
        return -1;
    }
}
