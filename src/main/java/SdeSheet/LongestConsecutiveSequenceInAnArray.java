package SdeSheet;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class LongestConsecutiveSequenceInAnArray {

    //    Input: nums = [100,4,200,1,3,2]
    //[1,2,3,4,100]
    public static int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        Arrays.sort(nums);
        int prev = nums[0];
        int current = 1;
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == prev + 1) {
                current++;
                count = Math.max(count, current);
            } else if (nums[i] != prev) {
                current = 1;
            }
            prev = nums[i];


        }

        return count;
    }


    //Approach #2 Optimal
    //    Input: nums = [100,4,200,1,3,2]
    //[1,2,3,4,100]
    public static int longestConsecutiveOptimize(int[] nums) {
    Set<Integer> numSet = new HashSet<>();
       for(int x:nums){
           numSet.add(x);
       }

       int longestStreak = 0 ;
       for(int num:nums){
           if(!numSet.contains(num-1)){   // if there is some element exist it means current element
                                          // is the part of the chain so we will ignore
                                            //instead of that we will find start of the chain so all elemnts will be covered int that while
               // for example start count from 1,2,3,4,5 instead of 2,3,4 or 3,4,5

               int currentNum = num;
               int currentStreak = 1;

               while (numSet.contains(currentNum+1)){
                   currentNum+=1;
                   currentStreak+=1;

               }
            longestStreak = Math.max(currentStreak,longestStreak);
           }
       }
    return longestStreak;
    }

        public static void main(String[] args) {
        System.out.println(longestConsecutiveOptimize(new int[]{100, 4, 200, 1, 3, 2}));
    }
}
