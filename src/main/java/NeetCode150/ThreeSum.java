package NeetCode150;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {

        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for(int i=0; i<nums.length && nums[i] <=0; i++){ //nums[i] <=0 how imp is that condition well we our goal is to make 0 as sum of i+left+right
                                                        // since we already sorted can it be 0 if value is <=0 , if nums[i] it's self is +ve or >0 further elements on num[i] will
                                                        //always be left || right >nums[i] since arrays is sorted so that helps us save unnecessary iterations,
                                                        // (intuition)to make 0 definitely we have some 0 and -ve values in the array
            if(i==0 || nums[i]!=nums[i-1]){ //first check i==0 so we won't out of bound for i-1 , 2nd check for duplicates
                twoSum(i,nums,result);
            }
        }
        return result;
    }

    private void twoSum(int i, int[] nums, List<List<Integer>> result) {
        int left = i+1;
        int right = nums.length-1;

        while(left<right){
            int sum = nums[i]+nums[left]+nums[right];
            if(sum<0){
                left++;
            }
            else if(sum>0){
                right--;
            }
            else{
                result.add(List.of(nums[i],nums[left++],nums[right--])); //doing increment and decrement here in same step
                //Handling duplicates
                while(left<right && nums[left]==nums[left-1]){
                    left++;
                }
            }
        }
    }
}
