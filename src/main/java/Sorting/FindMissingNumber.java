package Sorting;

import java.util.Arrays;

public class FindMissingNumber {
    public static  int missingNumber(int[] nums) {
        int i =0 ;
        while (i < nums.length){
            int correct  =  nums[i];
            if(nums[i]<nums.length && nums[i]!=nums[correct]){
                swap(nums,i,correct);
            }else {
                i++;
            }
        }

        for(int idx =0 ; idx<nums.length; idx++){
            if(nums[idx]!=idx){
                return idx;
            }
        }
        return  nums.length;
    }
    private static void swap(int[] arr, int i, int index) {
        int temp = arr[i];
        arr[i] = arr[index];
        arr[index] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {4,0,2,1};
        System.out.println(missingNumber(arr));
    }
}
