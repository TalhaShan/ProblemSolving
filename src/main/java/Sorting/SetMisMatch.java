package Sorting;

import java.util.Arrays;

public class SetMisMatch {


    public static  int[] findErrorNums(int[] nums) {
        int i = 0 ;

        while (i< nums.length){
            if(nums[i]!=i+1){
                int correct =  nums[i] -1;
                if(nums[i]!= nums[correct]){
                    swap(nums,i,correct);
                }else {
                    i++;
                }
            }else {
                i++;
            }

        }

        for(int idx = 0 ; idx<nums.length; idx++){
            if(idx+1 != nums[idx]){
                return  new int[]{nums[idx],idx+1};
            }
        }
      //  System.out.println(Arrays.toString(nums));
        return new int[]{};
    }
    private static void swap(int[] arr, int i, int index) {
        int temp = arr[i];
        arr[i] = arr[index];
        arr[index] = temp;
    }


    public static void main(String[] args) {
        int nums[] = {8,7,3,5,3,6,1,4};
        System.out.println(Arrays.toString(findErrorNums(nums)));
    }
}
