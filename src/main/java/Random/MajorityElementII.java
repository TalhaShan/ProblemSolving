package Random;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class MajorityElementII {
//    Input: nums = [3,2,3]
//    Output: [3]
//Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times

//There can be majority element or there may be not
    public static List<Integer> majorityElement(int[] nums) {
        int candidate1 = -1;
        int candidate2 = -1;
        int count1 = 0;
        int count2 = 0;
        List<Integer> result = new ArrayList();
        for (int element : nums) {
            if (candidate1 == element) {
                count1++;
            } else if (candidate2 == element) {
                count2++;
            } else if (count1 == 0) {
                candidate1 = element;
                count1++;
            } else if (count2 == 0) {
                candidate2 = element;
                count2++;
            } else {
                count1--;
                count2--;
            }
        }
        count1 = 0;
        count2 = 0;

        for(int num : nums){
            if(num == candidate1){
                count1++;
            }
            else if(num == candidate2){
                count2++;
            }
        }

        if(count1 > nums.length / 3){
            result.add(candidate1);
        }
        if(count2 > nums.length / 3){
            result.add(candidate2);
        }
        return result;

    }


    public static void main(String[] args) {
        System.out.println(majorityElement(new int[]{ 2, 2,1,3}));
//        System.out.println(majorityElement(new int[]{1}));
//        System.out.println(majorityElement(new int[]{1, 2}));
    }
}
