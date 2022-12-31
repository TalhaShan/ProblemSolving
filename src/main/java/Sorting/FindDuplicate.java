package Sorting;

public class FindDuplicate {
    public static int findDuplicate(int[] nums) {
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

    public static void main(String[] args) {
            int num[]= {1,3,4,2,2};
        System.out.println(findDuplicate(num));
    }
}
