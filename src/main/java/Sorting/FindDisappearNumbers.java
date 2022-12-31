package Sorting;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindDisappearNumbers {

    public static List<Integer> findDisappearedNumbers(int[] nums) {
       List<Integer> res = new ArrayList<>();
        int i =0 ;
        while (i < nums.length){
            int correct  =  nums[i]-1;
            if(nums[i]!=nums[correct]){  //2nd condition already not contained the duplicate of current at that is handled.
                swap(nums,i,correct);
            }else {
                i++;
            }
        }

//        System.out.println(Arrays.toString(nums));

        for(int idx =0 ; idx<nums.length; idx++){
            if(idx+1 != nums[idx]){  //why not idx out of bound because we ain't doing on arr we just normally idx+1 value
                res.add(idx+1);
            }
        }
        return  res;
    }


    private static void swap(int[] arr, int i, int index) {
        int temp = arr[i];
        arr[i] = arr[index];
        arr[index] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {4,3,2,7,8,2,3,1};
        System.out.println(findDisappearedNumbers(nums));
    }
}
