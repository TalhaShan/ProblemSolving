package SlidingWindows;

import java.util.HashMap;

public class SubArrayWithKDistinctIntegers {

    //see striver SDE sheet solutions

    public int subarraysWithKDistinct(int[] nums, int k) {
        return subArraysLessThanEqualToK(nums, k) - subArraysLessThanEqualToK(nums, k - 1);
    }

    public int subArraysLessThanEqualToK(int[] nums, int k) {
        int left = 0;
        int count = 0;
        int right = 0;

        HashMap<Integer, Integer> map = new HashMap<>();
        while (right < nums.length) {

          //  map.put(map.getOrDefault(nums[right], 0), +1); //wrong way
            map.put(nums[right], map.getOrDefault(nums[right], 0) + 1);

            while (map.size() > k) {
              //  map.put(nums[left], map.get(nums[left] - 1)); //shrinking window wrong way decrement key :D
                map.put(nums[left], map.get(nums[left]) - 1);
                if (map.get(nums[left]) == 0) {
                    map.remove(nums[left]);
                }
                left++;
            }
            count += right - left ;
            right++;
        }
        return count;
    }
}
}
