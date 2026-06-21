package NeetCode150;

public class findDuplicateNumber {
    /*
    You must solve the problem without modifying the array nums and using only constant extra space.

Example 1:

Input: nums = [1,3,4,2,2]
Output: 2
Example 2:

Input: nums = [3,1,3,4,2]
Output: 3
Example 3:

Input: nums = [3,3,3,3,3]
Output: 3
     */

    //Approach 1 Hashset extra memory
    //Approach 2 swapping and before swapping like element with their name index and before swapping if swapping like x,y x==y duplicate found... see cyclic sort
    public int findDuplicate(int[] nums) {
        int i =0 ;
        while (i<nums.length){
            int correctIdx = nums[i] -1;
            if(nums[i]!=nums[correctIdx]){
                swap(nums,correctIdx,i);
            }else{
                i++;
            }

        }
        for(int idx = 0  ; idx<nums.length; idx++){
            if(idx+1 != nums[idx]){
                return nums[idx];
            }
        }
        return -1;
    }
    private static void swap(int[] arr, int i, int index) {
        int temp = arr[i];
        arr[i] = arr[index];
        arr[index] = temp;
    }

    //But on above we modified the array

    //Now lests do the optimal one
    //See https://www.youtube.com/watch?v=_n5MR8IxR6c
    public int findDuplicateOptimal(int[] nums) {
        int slow = 0;
        int fast = 0;
        do{
            slow = nums[slow];
            fast = nums[nums[fast]];

        }while(slow!=fast);

        slow = 0; //Only rest slow
        while(slow!=fast){
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }
}
