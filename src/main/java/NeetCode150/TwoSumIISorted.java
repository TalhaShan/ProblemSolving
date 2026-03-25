package NeetCode150;

import java.util.Arrays;

public class TwoSumIISorted {
    //Best One
    public int[] twoSum(int[] numbers, int target) {
        int left =0;
        int right = numbers.length-1;

        while(left<right){
            if(numbers[left]+numbers[right]<target){
                left++;
            } else if (numbers[left]+numbers[right]>target) {
                right--;
            }else {
                return new int[]{left+1,right+1};
            }

        }
        return new int[0];
    }
    //Better One let's do by Binary search
    public int[] twoSumBS(int[] numbers, int target) {
        for(int i=0; i<numbers.length; i++){
            int find = target-numbers[i];
            int index = Arrays.binarySearch(numbers,i+1,numbers.length,find);
            if(index>=0){
                return new int[]{i+1,index+1};
            }
        }
        return new int[0];
    }
}
