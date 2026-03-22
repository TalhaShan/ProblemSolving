package NeetCode150;

import java.util.Arrays;
import java.util.HashSet;

public class LongestConsecitiveSequence {


    //Approach 1

    public int longestConsecutive1(int[] nums) {

        if(nums.length ==0){
            return 0;
        }

        HashSet<Integer> numSet = new HashSet<>();
        for(int i=0; i<nums.length; i++){
            numSet.add(nums[i]);
        }

        int longestSub = 1;

        for(int num:numSet){
            if(numSet.contains(num-1)){
                continue;
            }
            else{
                int currentNum = num;
                int currentSub = 1;
                while(numSet.contains(currentNum+1)){
                    currentNum++;
                    currentSub++;
                }

                longestSub = Math.max(longestSub, currentSub);
            }


        }
        return longestSub;

    }
    //Approach 2
    public int longestConsecutive(int[] nums) {
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
}
}
